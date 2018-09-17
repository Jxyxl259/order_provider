package com.yaic.app.pdms.dto.msg;

public class GetPdmsMessageReq {

	/** 销售方案代码 */
	private String agrtCode;
	
	/** 消息类型：1-短信，2-邮件 */
	private String msgKind;
	
	/** 业务类型:1-投保，2-退保，3-续保 */
	private String businessType;

	/** 获取销售方案代码 */
	public String getAgrtCode() {
		return agrtCode;
	}

	/** 设置销售方案代码 */
	public void setAgrtCode(String agrtCode) {
		this.agrtCode = agrtCode;
	}

	/** 获取消息类型：1-短信，2-邮件 */
	public String getMsgKind() {
		return msgKind;
	}

	/** 设置消息类型：1-短信，2-邮件 */
	public void setMsgKind(String msgKind) {
		this.msgKind = msgKind;
	}

	/** 获取业务类型:1-投保，2-退保，3-续保 */
	public String getBusinessType() {
		return businessType;
	}

	/** 设置业务类型:1-投保，2-退保，3-续保 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
}
