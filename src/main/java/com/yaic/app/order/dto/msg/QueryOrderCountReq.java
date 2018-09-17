package com.yaic.app.order.dto.msg;

import java.util.Date;

public class QueryOrderCountReq {
    /** 订单创建时间起 **/
    private Date orderStartDate;
    /** 订单创建时间止 **/
    private Date orderEndDate;
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
