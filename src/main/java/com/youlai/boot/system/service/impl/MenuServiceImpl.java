package com.youlai.boot.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youlai.boot.core.security.util.SecurityUtils;
import com.youlai.boot.system.converter.MenuConverter;
import com.youlai.boot.system.mapper.MenuMapper;
import com.youlai.boot.shared.codegen.model.entity.GenConfig;
import com.youlai.boot.system.model.entity.Menu;
import com.youlai.boot.system.model.form.MenuForm;
import com.youlai.boot.system.model.query.MenuQuery;
import com.youlai.boot.system.model.vo.MenuVO;
import com.youlai.boot.system.model.vo.RouteVO;
import com.youlai.boot.common.constant.SystemConstants;
import com.youlai.boot.system.enums.MenuTypeEnum;
import com.youlai.boot.common.enums.StatusEnum;
import com.youlai.boot.common.model.KeyValue;
import com.youlai.boot.common.model.Option;
import com.youlai.boot.system.service.MenuService;
import com.youlai.boot.system.service.RoleMenuService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 菜单服务实现类
 *
 * @author Ray.Hao
 * @since 2020/11/06
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    private final MenuConverter menuConverter;

    private final RoleMenuService roleMenuService;


    /**
     * 菜单列表
     *
     * @param queryParams {@link MenuQuery}
     */
    @Override
    public List<MenuVO> listMenus(MenuQuery queryParams) {
        List<Menu> menus = this.list(new LambdaQueryWrapper<Menu>()
                .like(StrUtil.isNotBlank(queryParams.getKeywords()), Menu::getName, queryParams.getKeywords())
                .orderByAsc(Menu::getSort)
        );
        // 获取所有菜单ID
        Set<Long> menuIds = menus.stream()
                .map(Menu::getId)
                .collect(Collectors.toSet());

        // 获取所有父级ID
        Set<Long> parentIds = menus.stream()
                .map(Menu::getParentId)
                .collect(Collectors.toSet());

        // 获取根节点ID（递归的起点），即父节点ID中不包含在部门ID中的节点，注意这里不能拿顶级菜单 O 作为根节点，因为菜单筛选的时候 O 会被过滤掉
        List<Long> rootIds = parentIds.stream()
                .filter(id -> !menuIds.contains(id))
                .toList();

        // 使用递归函数来构建菜单树
        return rootIds.stream()
                .flatMap(rootId -> buildMenuTree(rootId, menus).stream())
                .collect(Collectors.toList());
    }

    /**
     * 递归生成菜单列表
     *
     * @param parentId 父级ID
     * @param menuList 菜单列表
     * @return 菜单列表
     */
    private List<MenuVO> buildMenuTree(Long parentId, List<Menu> menuList) {
        return CollectionUtil.emptyIfNull(menuList)
                .stream()
                .filter(menu -> menu.getParentId().equals(parentId))
                .map(entity -> {
                    MenuVO menuVO = menuConverter.toVo(entity);
                    List<MenuVO> children = buildMenuTree(entity.getId(), menuList);
                    menuVO.setChildren(children);
                    return menuVO;
                }).toList();
    }

    /**
     * 菜单下拉数据
     *
     * @param onlyParent 是否只查询父级菜单 如果为true，排除按钮
     */
    @Override
    public List<Option<Long>> listMenuOptions(boolean onlyParent) {
        List<Menu> menuList = this.list(new LambdaQueryWrapper<Menu>()
                .in(onlyParent, Menu::getType, MenuTypeEnum.CATALOG.getValue(), MenuTypeEnum.MENU.getValue())
                .orderByAsc(Menu::getSort)
        );
        return buildMenuOptions(SystemConstants.ROOT_NODE_ID, menuList);
    }

    /**
     * 递归生成菜单下拉层级列表
     *
     * @param parentId 父级ID
     * @param menuList 菜单列表
     * @return 菜单下拉列表
     */
    private List<Option<Long>> buildMenuOptions(Long parentId, List<Menu> menuList) {
        List<Option<Long>> menuOptions = new ArrayList<>();

        for (Menu menu : menuList) {
            if (menu.getParentId().equals(parentId)) {
                Option<Long> option = new Option<>(menu.getId(), menu.getName());
                List<Option<Long>> subMenuOptions = buildMenuOptions(menu.getId(), menuList);
                if (!subMenuOptions.isEmpty()) {
                    option.setChildren(subMenuOptions);
                }
                menuOptions.add(option);
            }
        }

        return menuOptions;
    }

    /**
     * 获取菜单路由列表
     */
    @Override
    public List<RouteVO> getCurrentUserRoutes() {

        Set<String> roleCodes = SecurityUtils.getRoles();

        if (CollectionUtil.isEmpty(roleCodes)) {
            return Collections.emptyList();
        }
        List<Menu> menuList;
        if (SecurityUtils.isRoot()) {
            // 超级管理员获取所有菜单
            menuList = this.list(new LambdaQueryWrapper<Menu>()
                    .ne(Menu::getType, MenuTypeEnum.BUTTON.getValue())
                    .orderByAsc(Menu::getSort)
            );
        } else {
            menuList = this.baseMapper.getMenusByRoleCodes(roleCodes);
        }
        return buildRoutes(SystemConstants.ROOT_NODE_ID, menuList);
    }

    /**
     * 递归生成菜单路由层级列表
     *
     * @param parentId 父级ID
     * @param menuList 菜单列表
     * @return 路由层级列表
     */
    private List<RouteVO> buildRoutes(Long parentId, List<Menu> menuList) {
        List<RouteVO> routeList = new ArrayList<>();

        for (Menu menu : menuList) {
            if (menu.getParentId().equals(parentId)) {
                RouteVO routeVO = toRouteVo(menu);
                List<RouteVO> children = buildRoutes(menu.getId(), menuList);
                if (!children.isEmpty()) {
                    routeVO.setChildren(children);
                }
                routeList.add(routeVO);
            }
        }

        return routeList;
    }

    /**
     * 根据RouteBO创建RouteVO
     */
    private RouteVO toRouteVo(Menu menu) {
        RouteVO routeVO = new RouteVO();
        // 获取路由名称
        String routeName = menu.getRouteName();
        if (StrUtil.isBlank(routeName)) {
            // 路由 name 需要驼峰，首字母大写
            routeName = StringUtils.capitalize(StrUtil.toCamelCase(menu.getRoutePath(), '-'));
        }
        // 根据name路由跳转 this.$router.push({name:xxx})
        routeVO.setName(routeName);

        // 根据path路由跳转 this.$router.push({path:xxx})
        routeVO.setPath(menu.getRoutePath());
        routeVO.setRedirect(menu.getRedirect());
        routeVO.setComponent(menu.getComponent());

        RouteVO.Meta meta = new RouteVO.Meta();
        meta.setTitle(menu.getName());
        meta.setIcon(menu.getIcon());
        meta.setHidden(StatusEnum.DISABLE.getValue().equals(menu.getVisible()));
        // 【菜单】是否开启页面缓存
        if (MenuTypeEnum.MENU.getValue().equals(menu.getType())
                && ObjectUtil.equals(menu.getKeepAlive(), 1)) {
            meta.setKeepAlive(true);
        }
        meta.setAlwaysShow(ObjectUtil.equals(menu.getAlwaysShow(), 1));

        String paramsJson = menu.getParams();
        // 将 JSON 字符串转换为 Map<String, String>
        if (StrUtil.isNotBlank(paramsJson)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Map<String, String> paramMap = objectMapper.readValue(paramsJson, new TypeReference<>() {
                });
                meta.setParams(paramMap);
            } catch (Exception e) {
                throw new RuntimeException("解析参数失败", e);
            }
        }
        routeVO.setMeta(meta);
        return routeVO;
    }

    /**
     * 新增/修改菜单
     */
    @Override
    @CacheEvict(cacheNames = "menu", key = "'routes'")
    public boolean saveMenu(MenuForm menuForm) {

        Integer menuType = menuForm.getType();

        if (MenuTypeEnum.CATALOG.getValue().equals(menuType)) {  // 如果是目录
            String path = menuForm.getRoutePath();
            if (menuForm.getParentId() == 0 && !path.startsWith("/")) {
                menuForm.setRoutePath("/" + path); // 一级目录需以 / 开头
            }
            menuForm.setComponent("Layout");
        } else if (MenuTypeEnum.EXTLINK.getValue().equals(menuType)) {
            // 外链菜单组件设置为 null
            menuForm.setComponent(null);
        }
        if (Objects.equals(menuForm.getParentId(), menuForm.getId())) {
            throw new RuntimeException("父级菜单不能为当前菜单");
        }
        Menu entity = menuConverter.toEntity(menuForm);
        String treePath = generateMenuTreePath(menuForm.getParentId());
        entity.setTreePath(treePath);

        List<KeyValue> params = menuForm.getParams();
        // 路由参数 [{key:"id",value:"1"}，{key:"name",value:"张三"}] 转换为 [{"id":"1"},{"name":"张三"}]
        if (CollectionUtil.isNotEmpty(params)) {
            entity.setParams(JSONUtil.toJsonStr(params.stream()
                    .collect(Collectors.toMap(KeyValue::getKey, KeyValue::getValue))));
        } else {
            entity.setParams(null);
        }
        // 新增类型为菜单时候 路由名称唯一
        if (MenuTypeEnum.MENU.getValue().equals(menuType)) {
            Assert.isFalse(this.exists(new LambdaQueryWrapper<Menu>()
                    .eq(Menu::getRouteName, entity.getRouteName())
                    .ne(menuForm.getId() != null, Menu::getId, menuForm.getId())
            ), "路由名称已存在");
        } else {
            // 其他类型时 给路由名称赋值为空
            entity.setRouteName(null);
        }

        boolean result = this.saveOrUpdate(entity);
        if (result) {
            // 编辑刷新角色权限缓存
            if (menuForm.getId() != null) {
                roleMenuService.refreshRolePermsCache();
            }
        }
        // 修改菜单如果有子菜单，则更新子菜单的树路径
        updateChildrenTreePath(entity.getId(), treePath);
        return result;
    }

    /**
     * 更新子菜单树路径
     *
     * @param id       当前菜单ID
     * @param treePath 当前菜单树路径
     */
    private void updateChildrenTreePath(Long id, String treePath) {
        List<Menu> children = this.list(new LambdaQueryWrapper<Menu>().eq(Menu::getParentId, id));
        if (CollectionUtil.isNotEmpty(children)) {
            // 子菜单的树路径等于父菜单的树路径加上父菜单ID
            String childTreePath = treePath + "," + id;
            this.update(new LambdaUpdateWrapper<Menu>()
                    .eq(Menu::getParentId, id)
                    .set(Menu::getTreePath, childTreePath)
            );
            for (Menu child : children) {
                // 递归更新子菜单
                updateChildrenTreePath(child.getId(), childTreePath);
            }
        }
    }

    /**
     * 部门路径生成
     *
     * @param parentId 父ID
     * @return 父节点路径以英文逗号(, )分割，eg: 1,2,3
     */
    private String generateMenuTreePath(Long parentId) {
        if (SystemConstants.ROOT_NODE_ID.equals(parentId)) {
            return String.valueOf(parentId);
        } else {
            Menu parent = this.getById(parentId);
            return parent != null ? parent.getTreePath() + "," + parent.getId() : null;
        }
    }


    /**
     * 修改菜单显示状态
     *
     * @param menuId  菜单ID
     * @param visible 是否显示(1->显示；2->隐藏)
     * @return 是否修改成功
     */
    @Override
    @CacheEvict(cacheNames = "menu", key = "'routes'")
    public boolean updateMenuVisible(Long menuId, Integer visible) {
        return this.update(new LambdaUpdateWrapper<Menu>()
                .eq(Menu::getId, menuId)
                .set(Menu::getVisible, visible)
        );
    }

    /**
     * 获取菜单表单数据
     *
     * @param id 菜单ID
     * @return 菜单表单数据
     */
    @Override
    public MenuForm getMenuForm(Long id) {
        Menu entity = this.getById(id);
        Assert.isTrue(entity != null, "菜单不存在");
        MenuForm formData = menuConverter.toForm(entity);
        // 路由参数字符串 {"id":"1","name":"张三"} 转换为 [{key:"id", value:"1"}, {key:"name", value:"张三"}]
        String params = entity.getParams();
        if (StrUtil.isNotBlank(params)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 解析 JSON 字符串为 Map<String, String>
                Map<String, String> paramMap = objectMapper.readValue(params, new TypeReference<>() {
                });

                // 转换为 List<KeyValue> 格式 [{key:"id", value:"1"}, {key:"name", value:"张三"}]
                List<KeyValue> transformedList = paramMap.entrySet().stream()
                        .map(entry -> new KeyValue(entry.getKey(), entry.getValue()))
                        .toList();

                // 将转换后的列表存入 MenuForm
                formData.setParams(transformedList);
            } catch (Exception e) {
                throw new RuntimeException("解析参数失败", e);
            }
        }

        return formData;
    }

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return 是否删除成功
     */
    @Override
    @CacheEvict(cacheNames = "menu", key = "'routes'")
    public boolean deleteMenu(Long id) {
        boolean result = this.remove(new LambdaQueryWrapper<Menu>()
                .eq(Menu::getId, id)
                .or()
                .apply("CONCAT (',',tree_path,',') LIKE CONCAT('%,',{0},',%')", id));


        // 刷新角色权限缓存
        if (result) {
            roleMenuService.refreshRolePermsCache();
        }
        return result;

    }

    /**
     * 代码生成时添加菜单
     *
     * @param parentMenuId 父菜单ID
     * @param genConfig    实体名称
     */
    @Override
    public void addMenuForCodegen(Long parentMenuId, GenConfig genConfig) {
        Menu parentMenu = this.getById(parentMenuId);
        Assert.notNull(parentMenu, "上级菜单不存在");

        String entityName = genConfig.getEntityName();

        long count = this.count(new LambdaQueryWrapper<Menu>().eq(Menu::getRouteName, entityName));
        if (count > 0) {
            return;
        }

        // 获取父级菜单子菜单最带的排序
        Menu maxSortMenu = this.getOne(new LambdaQueryWrapper<Menu>().eq(Menu::getParentId, parentMenuId)
                .orderByDesc(Menu::getSort)
                .last("limit 1")
        );
        int sort = 1;
        if (maxSortMenu != null) {
            sort = maxSortMenu.getSort() + 1;
        }

        Menu menu = new Menu();
        menu.setParentId(parentMenuId);
        menu.setName(genConfig.getBusinessName());

        menu.setRouteName(entityName);
        menu.setRoutePath(StrUtil.toSymbolCase(entityName, '-'));
        menu.setComponent(genConfig.getModuleName() + "/" + StrUtil.toSymbolCase(entityName, '-') + "/index");
        menu.setType(MenuTypeEnum.MENU.getValue());
        menu.setSort(sort);
        menu.setVisible(1);
        boolean result = this.save(menu);

        if (result) {
            // 生成treePath
            String treePath = generateMenuTreePath(parentMenuId);
            menu.setTreePath(treePath);
            this.updateById(menu);

            // 生成CURD按钮权限
            String permPrefix = genConfig.getModuleName() + ":" + StrUtil.lowerFirst(entityName) + ":";
            String[] actions = {"查询", "新增", "编辑", "删除"};
            String[] perms = {"query", "add", "edit", "delete"};

            for (int i = 0; i < actions.length; i++) {
                Menu button = new Menu();
                button.setParentId(menu.getId());
                button.setType(MenuTypeEnum.BUTTON.getValue());
                button.setName(actions[i]);
                button.setPerm(permPrefix + perms[i]);
                button.setSort(i + 1);
                this.save(button);

                // 生成treePath
                button.setTreePath(treePath + "," + button.getId());
                this.updateById(button);
            }
        }
    }

}
