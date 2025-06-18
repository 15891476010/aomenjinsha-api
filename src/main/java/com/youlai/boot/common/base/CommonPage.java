package com.youlai.boot.common.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommonPage<T> {
    private int page = 1;
    private int limit = 20;
    private int totalPage = 0;
    private Long total = 0L ;
    private List<T> list = new ArrayList<>();


    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        Page<T> pageInfo = new Page<T>();
        result.setTotalPage((int) pageInfo.getCurrent());
        result.setPage((int) pageInfo.getPages());
        result.setLimit((int) pageInfo.getSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getRecords());
        return result;
    }

    /**
     * 将SpringData分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(Page<T> pageInfo) {
        CommonPage<T> result = new CommonPage<T>();
        result.setTotalPage((int) pageInfo.getCurrent());
        result.setPage((int) pageInfo.getPages());
        result.setLimit((int) pageInfo.getSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getRecords());
        return result;
    }

    /**
     * 对象A复制对象B的分页信息 // 多次数据查询导致分页数据异常解决办法
     */
    public static <T> Page<T> copyPageInfo(Page<?> originPageInfo, List<T> list) {
        Page<T> pageInfo = new Page<>();
        pageInfo.setPages(originPageInfo.getPages());
        pageInfo.setCurrent(originPageInfo.getCurrent());
        pageInfo.setSize(originPageInfo.getSize());
        pageInfo.setTotal(originPageInfo.getTotal());
        pageInfo.setRecords(list);
        return pageInfo;
    }
}