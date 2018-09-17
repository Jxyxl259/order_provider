package com.yaic.app.order.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.custom.endorNoInfoDto;


public class QueryPolicyEndorInfoResp {

    /** 大保单号 **/
    private String associatedNo;
    
    /** 小保单号 **/
    private String policyNo;
    
    /** 批单列表 **/
    private List<endorNoInfoDto> endorNoList;
    
    
    /** 大保单号 **/
	public String getAssociatedNo() {
		return associatedNo;
	}
	
	/** 大保单号 **/
	public void setAssociatedNo(String associatedNo) {
		this.associatedNo = associatedNo;
	}
	
	/** 小保单号 **/
	public String getPolicyNo() {
		return policyNo;
	}
	
	/** 小保单号 **/
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	/** 批单列表 **/
	public List<endorNoInfoDto> getEndorNoList() {
		return endorNoList;
	}
	
	/** 批单列表 **/
	public void setEndorNoList(List<endorNoInfoDto> endorNoList) {
		this.endorNoList = endorNoList;
	}

}
