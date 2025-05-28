package com.youlai.boot.index.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.common.base.CommonPage;
import com.youlai.boot.common.constant.SysGroupConstants;
import com.youlai.boot.common.exception.UsdtException;
import com.youlai.boot.common.util.IPUtils;
import com.youlai.boot.core.security.model.AuthenticationToken;
import com.youlai.boot.core.security.token.TokenManager;
import com.youlai.boot.core.security.util.SecurityUtils;
import com.youlai.boot.game.service.GameService;
import com.youlai.boot.index.model.form.EbUserLoginRequest;
import com.youlai.boot.index.model.vo.EbUserBalanceVO;
import com.youlai.boot.index.model.vo.EbUserFrontVO;
import com.youlai.boot.system.service.ConfigService;
import com.youlai.boot.system.service.SysGroupDataService;
import com.youlai.boot.system.service.UserRoleService;
import com.youlai.boot.utils.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.boot.index.mapper.EbUserMapper;
import com.youlai.boot.index.service.EbUserService;
import com.youlai.boot.index.model.entity.EbUser;
import com.youlai.boot.index.model.form.EbUserForm;
import com.youlai.boot.index.model.query.EbUserQuery;
import com.youlai.boot.index.model.vo.EbUserVO;
import com.youlai.boot.index.converter.EbUserConverter;
import com.youlai.boot.core.security.model.EbUserDetails;

import java.math.BigDecimal;
import java.util.*;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 前端用户服务实现类
 *
 * @author MrZhang
 * @since 2025-05-24 14:47
 */
@Service
@RequiredArgsConstructor
public class EbUserServiceImpl extends ServiceImpl<EbUserMapper, EbUser> implements EbUserService {

    private final EbUserConverter ebUserConverter;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private SysGroupDataService sysGroupDataService;

    @Autowired
    private GameService gameApiService;

    private final TokenManager tokenManager;

    private final UserRoleService userRoleService;

    @Autowired
    private CaptchaUtil captchaUtil;

    /**
     * 获取前端用户分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<EbUserVO>} 前端用户分页列表
     */
    @Override
    public Page<EbUserVO> getEbUserPage(EbUserQuery queryParams) {
        Page<EbUser> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<EbUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(EbUser::getId);
        Page<EbUser> pageVO = baseMapper.selectPage(page, wrapper);
        return CommonPage.copyPageInfo(pageVO, ebUserConverter.toVOList(pageVO.getRecords()));
    }

    /**
     * 获取前端用户表单数据
     *
     * @param id 前端用户ID
     * @return 前端用户表单数据
     */
    @Override
    public EbUserForm getEbUserFormData(Long id) {
        EbUser entity = this.getById(id);
        return ebUserConverter.toForm(entity);
    }

    /**
     * 新增前端用户
     *
     * @param formData 前端用户表单对象
     * @return 是否新增成功
     */
    @Override
    public boolean saveEbUser(HttpServletRequest request, EbUserForm formData) {
        String username = formData.getUsername();
        Assert.isTrue(StrUtil.isNotBlank(username), "用户名不能为空");
        Assert.isTrue(!this.exists(new LambdaQueryWrapper<EbUser>().eq(EbUser::getUsername, username)), "用户名已存在");
        Assert.isTrue(!this.exists(new LambdaQueryWrapper<EbUser>().eq(EbUser::getPhone, formData.getPhone())), "手机号已存在");
        Assert.isTrue(!this.exists(new LambdaQueryWrapper<EbUser>().eq(EbUser::getRealName, formData.getRealName())), "当前姓名已存在");
        Assert.isTrue(StrUtil.isNotBlank(formData.getPassword()), "密码不能为空");

        Assert.isTrue(StrUtil.isNotBlank(formData.getRealName()), "真实姓名不能为空");
        Assert.isTrue(StrUtil.isNotBlank(formData.getPhone()), "手机号不能为空");
        EbUser entity = ebUserConverter.toEntity(formData);

        if (StrUtil.isNotBlank(formData.getCaptchaCode())) {
            Boolean b = captchaUtil.checkCaptcha(formData.getCaptchaCode(), formData.getCaptchaKey());
        }

        if (StrUtil.isBlank(entity.getNickName())) {
            entity.setNickName(entity.getUsername());
        }

        String encode = passwordEncoder.encode(formData.getPassword());
        entity.setPassword(encode);
        String remoteHost = request.getRemoteHost();
        entity.setIp(remoteHost);

        // 根据ip获取国家
        entity.setCounty(MrZhangUtil.getLocationByIp(remoteHost));

        List<HashMap<String, Object>> listMapByGid = sysGroupDataService.getListMapByGid(SysGroupConstants.GROUP_ID_INDEX_AVATAR);
        int size = listMapByGid.size();
        // 根据长度获取一个随机数
        int randomIndex = (int) (Math.random() * size);
        // 取出随机数对应的图片
        entity.setAvatar(listMapByGid.get(randomIndex).get("avatar").toString());
        boolean save = this.save(entity);
        List<Long> objects = new ArrayList<>();
        objects.add(3L);
        Long player_id = entity.getId();
        if (save) {
            // 保存用户角色
             userRoleService.saveUserRoles(player_id, objects);
             gameApiService.memberRegister(player_id, entity.getUsername());
        }
        return save;
    }

    /**
     * 更新前端用户
     *
     * @param id   前端用户ID
     * @param formData 前端用户表单对象
     * @return 是否修改成功
     */
    @Override
    public boolean updateEbUser(Long id,EbUserForm formData) {
        EbUser entity = ebUserConverter.toEntity(formData);
        return this.updateById(entity);
    }

    /**
     * 删除前端用户
     *
     * @param ids 前端用户ID，多个以英文逗号(,)分割
     * @return 是否删除成功
     */
    @Override
    public boolean deleteEbUsers(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的前端用户数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

    @Override
    public boolean register(EbUserForm formData) {
        return false;
    }

    @Override
    public AuthenticationToken login(HttpServletRequest request, EbUserLoginRequest loginRequest) {
        Boolean b = captchaUtil.checkCaptcha(loginRequest.getCaptchaCode(), loginRequest.getCaptchaKey());
        LambdaQueryWrapper<EbUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EbUser::getUsername, loginRequest.getUsername());
        EbUser one = this.getOne(wrapper);
        if (one == null) {
            throw new UsdtException("用户不存在");
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), one.getPassword())) {
            throw new UsdtException("密码错误");
        }
        if (!one.getRealName().equals(loginRequest.getRealName())) {
            throw new UsdtException("真实姓名有误");
        }
        EbUserDetails ebUserDetails = new EbUserDetails(
                one.getId(),
                one.getUsername(),
                one.getPassword(),
                one.getNickName(),
                one.getAvatar(),
                one.getRealName(),
                one.getPhone(),
                one.getStatus(),
                one.getBalance()
        );
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(ebUserDetails, null, ebUserDetails.getAuthorities());
        // 2. 执行认证（认证中）
        // Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 3. 认证成功后生成 JWT 令牌，并存入 Security 上下文，供登录日志 AOP 使用（已认证）
        AuthenticationToken authenticationTokenResponse =
                tokenManager.generateToken(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        one.setIp(IPUtils.getIpAddr(request));
        one.setCounty(MrZhangUtil.getLocationByIp(one.getIp()));
        baseMapper.updateById(one);
        return authenticationTokenResponse;
    }

    @Override
    public EbUserFrontVO getCurrentUserInfo() {
        Long frontUserId = SecurityUtils.getFrontUserId();
        EbUser byId = this.getById(frontUserId);
        return ebUserConverter.toFrontVO(byId);
    }

    @Override
    public EbUserBalanceVO getUserBalance() {
        Long frontUserId = SecurityUtils.getFrontUserId();
        EbUser byId = baseMapper.selectById(frontUserId);
        return ebUserConverter.toBalanceVO(byId);
    }

    @Override
    public boolean transfer() {
        Long frontUserId = SecurityUtils.getFrontUserId();
        EbUser byId = baseMapper.selectById(frontUserId);
        byId.setBalance(BigDecimal.valueOf(0));
        return updateById(byId);
    }
}
