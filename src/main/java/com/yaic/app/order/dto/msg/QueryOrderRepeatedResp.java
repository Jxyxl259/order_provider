package com.yaic.app.order.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.msg.common.OrderDto;

public class QueryOrderRepeatedResp {
	
	/** 重复性：00-是,01-否 */ 
    private java.lang.String repeatedStatus;
    
    /**  重复投保数 */ 
    private java.lang.Integer total;
    
    /**  保单号 */ 
    private java.lang.String policyNo;
    
    /**  订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中 ，8-批改失败 */ 
    private java.lang.String status;
    
    /** 保单详情信息 **/
    private List<OrderDto> policyList;

    /**
     * 设置属性重复性：00-是,01-否的值
     */ 
    public void setRepeatedStatus(java.lang.String repeatedStatus) {
        this.repeatedStatus = repeatedStatus;
    }
    
    /**
     * 获取属性重复性：00-是,01-否的值
     */ 
    public java.lang.String getRepeatedStatus() {
        return this.repeatedStatus;
    }

    /**  重复投保数 */ 
	public java.lang.Integer getTotal() {
		return total;
	}

	/**  重复投保数 */ 
	public void setTotal(java.lang.Integer total) {
		this.total = total;
	}

	/**  保单号 */ 
	public java.lang.String getPolicyNo() {
		return policyNo;
	}

	/**  保单号 */ 
	public void setPolicyNo(java.lang.String policyNo) {
		this.policyNo = policyNo;
	}

	/**  订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中 ，8-批改失败 */ 
	public java.lang.String getStatus() {
		return status;
	}

	/**  订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中 ，8-批改失败 */ 
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
     * 获取属性保单详情信息
     */ 
    public List<OrderDto> getPolicyList() {
        return policyList;
    }

    /**
     * 设置属性保单详情信息
     */ 
    public void setPolicyList(List<OrderDto> policyList) {
        this.policyList = policyList;
    }
}
