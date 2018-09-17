package com.yaic.app.epolicy.dto.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EpolicyClauseDto {

	/** 条款代码 */	
	@XStreamAlias("ClauseID")
	private String clauseID;

	/** 条款代码 */
	public String getClauseID() {
		return clauseID;
	}

	/** 条款代码 */
	public void setClauseID(String clauseID) {
		this.clauseID = clauseID;
	}
	
}
