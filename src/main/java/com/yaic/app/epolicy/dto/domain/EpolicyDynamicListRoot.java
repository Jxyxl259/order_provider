package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyDynamicListRoot {

	/** 动态标的清单信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyDynamicListDto> dynamicListRownum;

	/** 动态标的清单信息 */
	public List<EpolicyDynamicListDto> getDynamicListRownum() {
		return dynamicListRownum;
	}

	/** 动态标的清单信息 */
	public void setDynamicListRownum(List<EpolicyDynamicListDto> dynamicListRownum) {
		this.dynamicListRownum = dynamicListRownum;
	}
	
}
