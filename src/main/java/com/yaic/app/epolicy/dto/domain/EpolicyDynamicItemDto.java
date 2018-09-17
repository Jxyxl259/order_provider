package com.yaic.app.epolicy.dto.domain;

import java.util.Map;

import javax.persistence.Transient;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EpolicyDynamicItemDto {

	/** 家财标的地址 */
	@XStreamAlias("SITUATION")
	private String situation;
	
	/** 货物运单号 */
	@XStreamAlias("BLNO")
	private String blno;
	
	/** 载运输工具 */
	@XStreamAlias("CONVEYANCENAME")
	private String conveyanceName;
	
	/** 运输方式 */
	@XStreamAlias("CONVEYANCETYPE")
	private String conveyanceType;
	
	/** 起运日期 */
	@XStreamAlias("STARTDATE")
	private String startDate;
	
	/** 起始地 */
	@XStreamAlias("STARTSITENAME")
	private String startsiteName;
	
	/** 中转站 */
	@XStreamAlias("VIASITENAME")
	private String viasiteName;
	
	/** 目的地 */
	@XStreamAlias("TARGETSITENAME")
	private String targetsiteName;
	
	/** 职业类别 */
	@XStreamAlias("OCCUPATIONLEVEL")
	private String occupationLevel;
	
	/** 职业名称 */
	@XStreamAlias("OCCUPATION")
	private String occupation;
	
	/** 动态标的对应信息 */
	@Transient
	private Map<String, String> dynamicItemMap;

	/** 家财标的地址 */
	public String getSituation() {
		return situation;
	}

	/** 家财标的地址 */
	public void setSituation(String situation) {
		this.situation = situation;
	}

	/** 货物运单号 */
	public String getBlno() {
		return blno;
	}

	/** 货物运单号 */
	public void setBlno(String blno) {
		this.blno = blno;
	}

	/** 载运输工具 */
	public String getConveyanceName() {
		return conveyanceName;
	}

	/** 载运输工具 */
	public void setConveyanceName(String conveyanceName) {
		this.conveyanceName = conveyanceName;
	}

	/** 运输方式 */
	public String getConveyanceType() {
		return conveyanceType;
	}

	/** 运输方式 */
	public void setConveyanceType(String conveyanceType) {
		this.conveyanceType = conveyanceType;
	}

	/** 起运日期 */
	public String getStartDate() {
		return startDate;
	}

	/** 起运日期 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/** 起始地 */
	public String getStartsiteName() {
		return startsiteName;
	}

	/** 起始地 */
	public void setStartsiteName(String startsiteName) {
		this.startsiteName = startsiteName;
	}

	/** 中转站 */
	public String getViasiteName() {
		return viasiteName;
	}

	/** 中转站 */
	public void setViasiteName(String viasiteName) {
		this.viasiteName = viasiteName;
	}

	/** 目的地 */
	public String getTargetsiteName() {
		return targetsiteName;
	}

	/** 目的地 */
	public void setTargetsiteName(String targetsiteName) {
		this.targetsiteName = targetsiteName;
	}

	/** 职业类别 */
	public String getOccupationLevel() {
		return occupationLevel;
	}

	/** 职业类别 */
	public void setOccupationLevel(String occupationLevel) {
		this.occupationLevel = occupationLevel;
	}

	/** 职业名称 */
	public String getOccupation() {
		return occupation;
	}

	/** 职业名称 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/** 动态标的对应信息 */
	public Map<String, String> getDynamicItemMap() {
		return dynamicItemMap;
	}

	/** 动态标的对应信息 */
	public void setDynamicItemMap(Map<String, String> dynamicItemMap) {
		this.dynamicItemMap = dynamicItemMap;
	}

}
