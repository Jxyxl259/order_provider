package com.yaic.app.pdms.dto.msg;

import com.yaic.app.pdms.dto.custom.PdmsSolutionInfoDto;

public class GetPdmsSolutionResp {
	
	/**获取销售方案详细信息*/
	private PdmsSolutionInfoDto pdmsSolutionInfoDto;
	
	/**
	 * 获取销售方案详细信息
	 */
	public PdmsSolutionInfoDto getPdmsSolutionInfoDto() {
		return pdmsSolutionInfoDto;
	}
	/**
	 * 设置销售方案详细信息
	 */
	public void setPdmsSolutionInfoDto(PdmsSolutionInfoDto pdmsSolutionInfoDto) {
		this.pdmsSolutionInfoDto = pdmsSolutionInfoDto;
	}
	
	
}
