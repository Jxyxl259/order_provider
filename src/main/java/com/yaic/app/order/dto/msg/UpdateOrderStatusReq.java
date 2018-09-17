package com.yaic.app.order.dto.msg;

public class UpdateOrderStatusReq {
    
    /** 订单号 **/
    private String orderCode;
    /** 订单的状态;0-未确认,1-已确认,2-已完成,3-失败,4-取消 */
    private String orderStatus;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
