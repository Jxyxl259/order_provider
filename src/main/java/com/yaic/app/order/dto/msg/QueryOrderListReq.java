package com.yaic.app.order.dto.msg;

import java.util.Date;

public class QueryOrderListReq {
    /** 订单创建时间起 **/
    private Date orderStartDate;
    /** 订单创建时间止 **/
    private Date orderEndDate;
    /** 开始位置 **/
    private Integer startIndex;
    /** 每页数量 **/
    private Integer pageSize;
    /** 订单状态**/
    private String orderStatus;
    /** 支付状态 **/
    private String payStatus;
    /** 自定义条件 **/
    private String objectCondition;

    public Date getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(Date orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public Date getOrderEndDate() {
        return orderEndDate;
    }

    public void setOrderEndDate(Date orderEndDate) {
        this.orderEndDate = orderEndDate;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getObjectCondition() {
        return objectCondition;
    }

    public void setObjectCondition(String objectCondition) {
        this.objectCondition = objectCondition;
    }

}
