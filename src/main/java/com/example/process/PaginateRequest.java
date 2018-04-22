package com.example.process;

/**
 * @Author: wangdingfeng
 * @Description: 流程相关查询分页条件
 * @Date: 2018/4/22 21:39
 */
public class PaginateRequest {
    protected Integer start;
    protected Integer size;
    protected String sort;
    protected String order;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

}
