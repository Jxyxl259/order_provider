package com.yaic.app.order.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.msg.common.OrderDto;

public class QueryPolicyDetailInfoResp {
    
    /**保单详情信息**/
    private OrderDto policyInfo;
    
    /**保单详情信息列表**/
    private List<OrderDto> policyInfoList;

    public OrderDto getPolicyInfo() {
        return policyInfo;
    }

    public void setPolicyInfo(OrderDto policyInfo) {
        this.policyInfo = policyInfo;
    }

	public List<OrderDto> getPolicyInfoList() {
		return policyInfoList;
	}

	public void setPolicyInfoList(List<OrderDto> policyInfoList) {
		this.policyInfoList = policyInfoList;
	}
    
}
