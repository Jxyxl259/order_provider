package com.yaic.app.epolicy.dto.domain;

import java.util.Map;

import javax.persistence.Transient;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EpolicyDynamicListDto {
	
	/** 序号 */
	@XStreamAlias("SERIALNO")
	private String serialNo;
	
	/** 动态标的清单对应信息 */
	@Transient
	private Map<String, String> dynamicListMap;

	/** 序号 */
	public String getSerialNo() {
		return serialNo;
	}

	/** 序号 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	/** 动态标的清单对应信息 */
	public Map<String, String> getDynamicListMap() {
		return dynamicListMap;
	}

	/** 动态标的清单对应信息 */
	public void setDynamicListMap(Map<String, String> dynamicListMap) {
		this.dynamicListMap = dynamicListMap;
	}
}
