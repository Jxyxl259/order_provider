package com.yaic.app.order.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.msg.common.ShopOrderDto;

public class QueryOrderListResp {

    /** 订单信息列表 **/
    List<ShopOrderDto> shopOrderList = null;

    /** 订单总数 **/
    private Integer total = null;

    public List<ShopOrderDto> getShopOrderList() {
        return shopOrderList;
    }

    public void setShopOrderList(List<ShopOrderDto> shopOrderList) {
        this.shopOrderList = shopOrderList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
