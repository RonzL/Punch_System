package com.ronz.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: Ronz ronz_liu@163.com
 * @Date: Created in 10:14 2020/7/26
 */

public class Page<T> implements Serializable {
    private int pageSize;       // 表示页面一次显示多少条记录
    private int currentPage;    // 表示当前是第几页
    private int totalPage;      // 表示总共有多少页
    private int totalCount;     // 表示总共有多少条记录
    private List<T> list;          // 用于存放查询到的记录

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
