package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyMinorKindRoot {

	/** 附加险信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyItemkindDto> minorKindRownum;

	/** 附加险信息 */
	public List<EpolicyItemkindDto> getMinorKindRownum() {
		return minorKindRownum;
	}

	/** 附加险信息 */
	public void setMinorKindRownum(List<EpolicyItemkindDto> minorKindRownum) {
		this.minorKindRownum = minorKindRownum;
	}
	
}
