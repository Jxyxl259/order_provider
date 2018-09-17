package com.yaic.app.order.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.msg.common.CallBackOrderInfoDto;

public class CallBackOrderInfoReq {
    /**订单号 **/
    private String orderCode;
    /**订单状态 0-未确认,1-已确认,2-已完成 **/
    private String OrderStatus;
    /**操作类型 0：订单转投保成功回写订单信息 1：转保单成功回写订单信息**/
    private String actionType;
    
    /**回写订单信息列表 **/
    private List<CallBackOrderInfoDto> callBackOrderInfoList;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public List<CallBackOrderInfoDto> getCallBackOrderInfoList() {
        return callBackOrderInfoList;
    }

    public void setCallBackOrderInfoList(List<CallBackOrderInfoDto> callBackOrderInfoList) {
        this.callBackOrderInfoList = callBackOrderInfoList;
    }
    
    
}
