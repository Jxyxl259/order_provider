package com.yaic.app.order.dto.msg;

/**
 * 华道征信系统请求报文
 * <p>Date: 2016-4-25
 * <p>Version: 1.0
 */
public class NcmGetTrandNoReq {
	
	 /** 订单号  */ 
    private java.lang.String orderCode;
    
    
    /**
     * 订单号
     */ 
    public void setOrderCode(java.lang.String orderCode) {
        this.orderCode = orderCode;
    }
    
    /**
     * 订单号
     */ 
    public java.lang.String getOrderCode() {
        return this.orderCode;
    }


	
}
