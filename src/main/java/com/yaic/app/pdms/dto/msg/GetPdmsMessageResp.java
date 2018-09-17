package com.yaic.app.pdms.dto.msg;


public class GetPdmsMessageResp {
	
    /** 方案主键Id*/
    private Integer solutionId;
    
    /** 消息分类：1 短信 2 邮件 */
    private String msgKind;
    
    /** 业务类型: 1:投保 2：退保 3:续保 */
    private String businessType;
    
    /** 消息类型：13：投保短信 16：退保短信 */
    private String msgType;
    
    /** 发送对象:01:投保人 11 被保人 */
    private String targetType;
    
    /** 消息模板Id */
    private String msgTmplId;
    
    /** 消息名称 */
    private String msgName;
    
    /** 消息描述 */
    private String msgDesc;
    
    /** 消息内容 */
    private String msgContent;

    /** 方案主键Id*/
	public Integer getSolutionId() {
		return solutionId;
	}

	/** 方案主键Id*/
	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}

	/** 消息分类：1 短信 2 邮件 */
	public String getMsgKind() {
		return msgKind;
	}

	/** 消息分类：1 短信 2 邮件 */
	public void setMsgKind(String msgKind) {
		this.msgKind = msgKind;
	}

	/** 业务类型: 1:投保 2：退保 3:续保 */
	public String getBusinessType() {
		return businessType;
	}

	/** 业务类型: 1:投保 2：退保 3:续保 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/** 消息类型：13：投保短信 16：退保短信 */
	public String getMsgType() {
		return msgType;
	}

	/** 消息类型：13：投保短信 16：退保短信 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/** 发送对象:01:投保人 11 被保人 */
	public String getTargetType() {
		return targetType;
	}

	/** 发送对象:01:投保人 11 被保人 */
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	/** 消息模板Id */
	public String getMsgTmplId() {
		return msgTmplId;
	}

	/** 消息模板Id */
	public void setMsgTmplId(String msgTmplId) {
		this.msgTmplId = msgTmplId;
	}

	/** 消息名称 */
	public String getMsgName() {
		return msgName;
	}

	/** 消息名称 */
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

	/** 消息描述 */
	public String getMsgDesc() {
		return msgDesc;
	}

	/** 消息描述 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}

	/** 消息内容 */
	public String getMsgContent() {
		return msgContent;
	}

	/** 消息内容 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}


}
