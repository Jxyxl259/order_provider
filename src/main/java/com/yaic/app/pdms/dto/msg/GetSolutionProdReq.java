package com.yaic.app.pdms.dto.msg;

public class GetSolutionProdReq {
	
	/** 销售方案代码 */
	private String agrtCode;
	
	/** 产品代码 */
	private String prodCode;
	
	/** 险种代码 */
	private String riskCode;

	/**
	 * 获取销售方案代码
	 */
	public String getAgrtCode() {
		return agrtCode;
	}

	/**
	 * 设置销售方案代码
	 */
	public void setAgrtCode(String agrtCode) {
		this.agrtCode = agrtCode;
	}

	/** 产品代码 */
	public String getProdCode() {
		return prodCode;
	}

	/** 产品代码 */
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	/** 险种代码 */
	public String getRiskCode() {
		return riskCode;
	}

	/** 险种代码 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	
}
