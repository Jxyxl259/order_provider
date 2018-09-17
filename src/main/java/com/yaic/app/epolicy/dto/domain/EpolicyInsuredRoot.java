package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyInsuredRoot {

	/** 被保人信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyInsuredDto> insuredRownum;

	/** 被保人信息 */
	public List<EpolicyInsuredDto> getInsuredRownum() {
		return insuredRownum;
	}

	/** 被保人信息 */
	public void setInsuredRownum(List<EpolicyInsuredDto> insuredRownum) {
		this.insuredRownum = insuredRownum;
	}
	
}
