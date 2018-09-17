package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyItemCargoRoot {

	/** 货运险标的详细信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyItemCargoDto> itemCargoRownum;

	/** 货运险标的详细信息 */
	public List<EpolicyItemCargoDto> getItemCargoRownum() {
		return itemCargoRownum;
	}

	/** 货运险标的详细信息 */
	public void setItemCargoRownum(List<EpolicyItemCargoDto> itemCargoRownum) {
		this.itemCargoRownum = itemCargoRownum;
	}
	
}
