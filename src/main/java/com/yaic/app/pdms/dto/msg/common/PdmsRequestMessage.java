package com.yaic.app.pdms.dto.msg.common;

import java.util.Date;

public class PdmsRequestMessage {
	

	/** -----------公共消息头---------- */
	/** 接口标识 */
	private String interfaceCode;
	/** 时间戳 */
	private Date requestTime;
	/** 设备序列号 */
	private String uuid;
	/** 用户ID */
	private String userId;
	
	/** ------------实体部分---------- */
	private PdmsReqBodyData data = new PdmsReqBodyData();
	
	public PdmsReqBodyData getData() {
		return data;
	}
	
	public void setData(PdmsReqBodyData data) {
		this.data = data;
	}
	
	public String getInterfaceCode() {
		return interfaceCode;
	}
	
	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}
	
	public Date getRequestTime() {
		return requestTime;
	}
	
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
