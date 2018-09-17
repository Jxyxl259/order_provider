package com.yaic.app.epolicy.dto.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EpolicyItemkindDto {

	/** 险别名称 */
	@XStreamAlias("KINDNAME")
	private String kindName;
	
	/** 保险责任(即限额名称) */
	@XStreamAlias("KINDTYPE")
	private String kindType;
	
	/** 保费 */
	@XStreamAlias("GROSSPREMIUM")
	private String grossPremium;
	
	/** 保额 */
	@XStreamAlias("SUMINSURED")
	private String sumInsured;
	
	/** 每人保额 */
	@XStreamAlias("UNITINSURED")
	private String unitInsured;
	
	/** 限额 */
	@XStreamAlias("LIMIT")
	private String limit;
	
	/** 赔偿说明(限额说明) */
	@XStreamAlias("LIMITDESC")
	private String limitDesc;
	
	/** 限额代码 */
	@XStreamAlias("LIMITCODE")
	private String limitCode;
	
	/** 单位 */
	@XStreamAlias("LIMITTYPE")
	private String limitType;
	
	/** 限额类型 */
	@XStreamAlias("LIMITCLASS")
	private String limitClass;

	/** 备注 */
	@XStreamAlias("REMARK")
	private String remark;
	
	/** 责任日额保险金 */
	@XStreamAlias("UNITLIMIT")
	private String unitLimit;
	
	/** 险别名称 */
	public String getKindName() {
		return kindName;
	}

	/** 险别名称 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	/** 保险责任(即限额名称) */
	public String getKindType() {
		return kindType;
	}

	/** 保险责任(即限额名称) */
	public void setKindType(String kindType) {
		this.kindType = kindType;
	}

	/** 保费 */
	public String getGrossPremium() {
		return grossPremium;
	}

	/** 保费 */
	public void setGrossPremium(String grossPremium) {
		this.grossPremium = grossPremium;
	}

	/** 保额 */
	public String getSumInsured() {
		return sumInsured;
	}

	/** 保额 */
	public void setSumInsured(String sumInsured) {
		this.sumInsured = sumInsured;
	}

	/** 每人保额 */
	public String getUnitInsured() {
		return unitInsured;
	}

	/** 每人保额 */
	public void setUnitInsured(String unitInsured) {
		this.unitInsured = unitInsured;
	}

	/** 限额 */
	public String getLimit() {
		return limit;
	}

	/** 限额 */
	public void setLimit(String limit) {
		this.limit = limit;
	}

	/** 赔偿说明(限额说明) */
	public String getLimitDesc() {
		return limitDesc;
	}

	/** 赔偿说明(限额说明) */
	public void setLimitDesc(String limitDesc) {
		this.limitDesc = limitDesc;
	}

	/** 限额代码 */
	public String getLimitCode() {
		return limitCode;
	}

	/** 限额代码 */
	public void setLimitCode(String limitCode) {
		this.limitCode = limitCode;
	}

	/** 单位 */
	public String getLimitType() {
		return limitType;
	}

	/** 单位 */
	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}
	
	/** 限额类型 */
	public String getLimitClass() {
		return limitClass;
	}
	
	/** 限额类型 */
	public void setLimitClass(String limitClass) {
		this.limitClass = limitClass;
	}

	/** 备注 */
	public String getRemark() {
		return remark;
	}

	/** 备注 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/** 责任日额保险金 */
	public String getUnitLimit() {
		return unitLimit;
	}

	/** 责任日额保险金 */
	public void setUnitLimit(String unitLimit) {
		this.unitLimit = unitLimit;
	}

}
