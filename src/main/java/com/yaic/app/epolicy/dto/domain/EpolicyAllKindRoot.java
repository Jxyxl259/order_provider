package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyAllKindRoot {

	/** 所有险信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyItemkindDto> allKindRownum;

	/** 所有险信息 */
	public List<EpolicyItemkindDto> getAllKindRownum() {
		return allKindRownum;
	}

	/** 所有险信息 */
	public void setAllKindRownum(List<EpolicyItemkindDto> allKindRownum) {
		this.allKindRownum = allKindRownum;
	}
	
}
