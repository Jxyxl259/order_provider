package com.yaic.app.order.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.msg.common.CallBackOrderInfoDto;

/**
 * 华道征信系统请求报文
 * <p>Date: 2016-4-25
 * <p>Version: 1.0
 */
public class TransTrandNoToPayResp {
	
	 /**订单状态 0-未确认,1-已确认,2-已完成 **/
    private String OrderStatus;
    
    /**回写订单信息列表 **/
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
