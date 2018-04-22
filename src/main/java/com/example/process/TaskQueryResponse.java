package com.example.process;

import java.util.List;

/**
 * @Author: wangdingfeng
 * @Description:
 * @Date: 2018/4/22 21:29
 */
public class TaskQueryResponse {
    private List<Object> data;//任务数据详细内容
    private Long total;//总数
    private Integer start;//开始计数位置
    private String sort;//排序字段
    private String order;//排序方式
    private Integer size;//每页数据数量
    private String message;//错误代码
    private String exception;//错误详情
    public TaskQueryResponse(){


    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
