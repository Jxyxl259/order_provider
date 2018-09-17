package com.yaic.app.trans.dto.msg;

import com.yaic.app.order.dto.msg.common.ShopOrderDto;

public class TransProposalToPolicyReq {

    /** 订单信息 **/
    private ShopOrderDto shopOrderDto;

    public ShopOrderDto getShopOrderDto() {
        return shopOrderDto;
    }

    public void setShopOrderDto(ShopOrderDto shopOrderDto) {
        this.shopOrderDto = shopOrderDto;
    }

}
