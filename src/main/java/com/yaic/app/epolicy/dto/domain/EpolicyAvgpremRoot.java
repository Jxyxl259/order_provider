package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyAvgpremRoot {
	
	/** 份数信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyAvgpremDto> avgpremRownum;

	/** 份数信息 */
	public List<EpolicyAvgpremDto> getAvgpremRownum() {
		return avgpremRownum;
	}

	/** 份数信息 */
	public void setAvgpremRownum(List<EpolicyAvgpremDto> avgpremRownum) {
		this.avgpremRownum = avgpremRownum;
	}
	
}
