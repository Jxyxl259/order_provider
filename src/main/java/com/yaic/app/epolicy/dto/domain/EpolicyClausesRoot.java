package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyClausesRoot {

	/** 条款信息 */
	@XStreamImplicit(itemFieldName="Clause")
	private List<EpolicyClauseDto> clauseRownum;

	/** 条款信息 */
	public List<EpolicyClauseDto> getClauseRownum() {
		return clauseRownum;
	}

	/** 条款信息 */
	public void setClauseRownum(List<EpolicyClauseDto> clauseRownum) {
		this.clauseRownum = clauseRownum;
	}
	
}
