package com.yaic.app.trans.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.msg.common.ShopOrderDto;

public class TransOrderToBusinessNoReq {
    
    /** 订单信息  **/
    private List<ShopOrderDto> shopOrderList;

    /** 订单信息  **/
	public List<ShopOrderDto> getShopOrderList() {
		return shopOrderList;
	}

	/** 订单信息  **/
	public void setShopOrderList(List<ShopOrderDto> shopOrderList) {
		this.shopOrderList = shopOrderList;
	}

}
