package com.yaic.app.order.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.domain.ShopOrderExtendInfoDto;
import com.yaic.app.order.dto.domain.ShopOrderInfoDto;
import com.yaic.app.order.dto.domain.ShopOrderPayinfoDto;
import com.yaic.app.order.dto.domain.ShopOrderShippingDto;
import com.yaic.app.order.dto.msg.common.OrderDto;

/**
 * 创建订单
 */
public class CreateOrderReq {
    
    /**订单详情信息**/
    private ShopOrderInfoDto shopOrderInfo;
    /**订单支付信息**/
    private ShopOrderPayinfoDto shopOrderPayinfo;
    /**订单配送信息**/
    private ShopOrderShippingDto shopOrderShipping;
    /**订单扩展信息**/
    private ShopOrderExtendInfoDto shopOrderExtendInfo;
    
    /**订单信息列表**/
    private List<OrderDto> orderList;

    
    public ShopOrderInfoDto getShopOrderInfo() {
        return shopOrderInfo;
    }

    public void setShopOrderInfo(ShopOrderInfoDto shopOrderInfo) {
        this.shopOrderInfo = shopOrderInfo;
    }

    public ShopOrderPayinfoDto getShopOrderPayinfo() {
        return shopOrderPayinfo;
    }

    public void setShopOrderPayinfo(ShopOrderPayinfoDto shopOrderPayinfo) {
        this.shopOrderPayinfo = shopOrderPayinfo;
    }

    public ShopOrderShippingDto getShopOrderShipping() {
        return shopOrderShipping;
    }

    public void setShopOrderShipping(ShopOrderShippingDto shopOrderShipping) {
        this.shopOrderShipping = shopOrderShipping;
    }
    
    public ShopOrderExtendInfoDto getShopOrderExtendInfo() {
		return shopOrderExtendInfo;
	}

	public void setShopOrderExtendInfo(ShopOrderExtendInfoDto shopOrderExtendInfo) {
		this.shopOrderExtendInfo = shopOrderExtendInfo;
	}
	
    public List<OrderDto> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDto> orderList) {
        this.orderList = orderList;
    }

}
