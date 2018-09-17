package com.yaic.app.order.dto.msg;

import java.util.Date;

public class UpdateOrderPayStatusReq {
    /** 订单号 **/
    private String orderCode;
    /** 支付状态：0-未支付，1-支付成功，2-支付失败 **/
    private String payStatus;
    /** 支付时间 **/
    private Date payDate;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

}
