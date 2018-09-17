package com.yaic.app.order.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.msg.common.CallBackOrderInfoDto;

public class OrderToProposalResp {
    /**订单状态 0-未确认,1-已确认(全部转投保成功),2-已完成 **/
    private String OrderStatus;
    
    /**返回订单信息列表 **/
    private List<CallBackOrderInfoDto> callBackOrderInfoList;

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public List<CallBackOrderInfoDto> getCallBackOrderInfoList() {
        return callBackOrderInfoList;
    }

    public void setCallBackOrderInfoList(List<CallBackOrderInfoDto> callBackOrderInfoList) {
        this.callBackOrderInfoList = callBackOrderInfoList;
    }
    
}
