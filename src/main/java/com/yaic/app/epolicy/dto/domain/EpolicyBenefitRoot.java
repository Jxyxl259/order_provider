package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyBenefitRoot {

	/** 受益人信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyBenefitDto> benefitRownum;

	/** 受益人信息 */
	public List<EpolicyBenefitDto> getBenefitRownum() {
		return benefitRownum;
	}

	/** 受益人信息 */
	public void setBenefitRownum(List<EpolicyBenefitDto> benefitRownum) {
		this.benefitRownum = benefitRownum;
	}
	
}
