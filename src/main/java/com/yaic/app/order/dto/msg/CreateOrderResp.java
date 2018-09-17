package com.yaic.app.order.dto.msg;

public class CreateOrderResp {
    /** 订单号 **/
    private String orderCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
