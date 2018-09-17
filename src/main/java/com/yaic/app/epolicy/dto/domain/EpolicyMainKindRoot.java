package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyMainKindRoot {

	/** 主险信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyItemkindDto> mainKindRownum;

	/** 主险信息 */
	public List<EpolicyItemkindDto> getMainKindRownum() {
		return mainKindRownum;
	}

	/** 主险信息 */
	public void setMainKindRownum(List<EpolicyItemkindDto> mainKindRownum) {
		this.mainKindRownum = mainKindRownum;
	}
	
}
