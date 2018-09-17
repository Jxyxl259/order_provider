package com.yaic.app.pdms.dto.msg;

public class GetPdmsProductReq {
	
	/** 产品代码 */
	private String prodCode;
	
	/** 险种代码 */
	private String riskCode;
	
	/**
	 * 获取产品代码
	 */
	public String getProdCode() {
		return prodCode;
	}
	
	/**
	 * 设置产品代码
	 */
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	
	/**
	 * 获取险种代码
	 */
	public String getRiskCode() {
		return riskCode;
	}
	
	/**
	 * 设置险种代码
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	
}
