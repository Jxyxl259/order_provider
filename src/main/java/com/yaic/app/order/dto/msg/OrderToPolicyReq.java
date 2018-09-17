package com.yaic.app.order.dto.msg;

public class OrderToPolicyReq {
    
	/** 订单号 **/
    private String orderCode;
    
    /** 处理方式  JK-激活卡处理方式 **/
    private String disposeType;
    
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /** 处理方式 **/
	public String getDisposeType() {
		return disposeType;
	}

	/** 处理方式 **/
	public void setDisposeType(String disposeType) {
		this.disposeType = disposeType;
	}
    
}
