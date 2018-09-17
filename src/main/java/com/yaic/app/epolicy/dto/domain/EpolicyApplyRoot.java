package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyApplyRoot {

	/** 投保人信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyApplyDto> applyRownum;

	/** 投保人信息 */
	public List<EpolicyApplyDto> getApplyRownum() {
		return applyRownum;
	}

	/** 投保人信息 */
	public void setApplyRownum(List<EpolicyApplyDto> applyRownum) {
		this.applyRownum = applyRownum;
	}

}
