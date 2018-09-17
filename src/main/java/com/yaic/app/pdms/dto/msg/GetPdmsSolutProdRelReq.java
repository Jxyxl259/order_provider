package com.yaic.app.pdms.dto.msg;

public class GetPdmsSolutProdRelReq {
	
	/** 销售方案代码  */
	private String agrtCode;
	
	/** 产品代码 */
	private String prodCode;
	
	public String getAgrtCode() {
		return agrtCode;
	}
	
	public void setAgrtCode(String agrtCode) {
		this.agrtCode = agrtCode;
	}
	
	public String getProdCode() {
		return prodCode;
	}
	
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
}
