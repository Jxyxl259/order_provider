package com.yaic.app.order.dto.msg;

import com.yaic.app.order.dto.domain.ShopOrderPayinfoDto;

public class OrderToPolicyUpdateDataReq {
    
	/** 订单号 **/
    private String orderCode;
    
    /** 订单支付信息 **/
    private ShopOrderPayinfoDto shopOrderPayinfoDto;

    /** 订单号 **/
    public String getOrderCode() {
        return orderCode;
    }

    /** 订单号 **/
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /** 订单支付信息 **/
	public ShopOrderPayinfoDto getShopOrderPayinfoDto() {
		return shopOrderPayinfoDto;
	}

	/** 订单支付信息 **/
	public void setShopOrderPayinfoDto(ShopOrderPayinfoDto shopOrderPayinfoDto) {
		this.shopOrderPayinfoDto = shopOrderPayinfoDto;
	}
    
    
}
