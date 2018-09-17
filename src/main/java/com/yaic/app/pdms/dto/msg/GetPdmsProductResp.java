package com.yaic.app.pdms.dto.msg;

import com.yaic.app.pdms.dto.custom.PdmsProdInfoDto;

public class GetPdmsProductResp {
	
	/** 产品详细信息 */
	private PdmsProdInfoDto pdmsProdInfo;
	
	/**
	 * 获取产品详细信息 
	 */
	public PdmsProdInfoDto getPdmsProdInfo() {
		return pdmsProdInfo;
	}
	
	/**
	 * 设置产品详细信息
	 */
	public void setPdmsProdInfo(PdmsProdInfoDto pdmsProdInfo) {
		this.pdmsProdInfo = pdmsProdInfo;
	} 
}
