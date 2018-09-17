package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyDynamicItemRoot {

	/** 标的信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyDynamicItemDto> dynamicItemRownum;

	/** 标的信息 */
	public List<EpolicyDynamicItemDto> getDynamicItemRownum() {
		return dynamicItemRownum;
	}

	/** 标的信息 */
	public void setDynamicItemRownum(List<EpolicyDynamicItemDto> dynamicItemRownum) {
		this.dynamicItemRownum = dynamicItemRownum;
	}
	
}
