package com.yaic.app.trans.dto.msg;

import com.yaic.app.order.dto.msg.common.ShopOrderDto;
import com.yaic.app.syn.dto.custom.SynPolicyInfo;

public class TransSynPolicyReq {
    
    private ShopOrderDto shopOrderDto;
    
    private SynPolicyInfo synPolicyInfo;

    public ShopOrderDto getShopOrderDto() {
        return shopOrderDto;
    }

    public void setShopOrderDto(ShopOrderDto shopOrderDto) {
        this.shopOrderDto = shopOrderDto;
    }

    public SynPolicyInfo getSynPolicyInfo() {
        return synPolicyInfo;
    }

    public void setSynPolicyInfo(SynPolicyInfo synPolicyInfo) {
        this.synPolicyInfo = synPolicyInfo;
    }
    
}
