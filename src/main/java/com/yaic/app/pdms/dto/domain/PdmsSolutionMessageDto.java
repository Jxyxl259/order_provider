package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import com.yaic.fa.dto.BaseDto;
/**
 * 方案通知信息（短信or邮件）表
 * <p>User: Administrator
 * <p>Date: 2017年8月31日
 * <p>Version: 1.0
 */
@Table(name = "t_pdms_solution_message")
public class PdmsSolutionMessageDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsSolutionMessageDto.class.getName().hashCode();
    
	/** 主键ID */ 
	@Id
	private java.lang.Integer msgId;

	/** 方案主键ID */ 
	private java.lang.Integer solutionId;

	/** 消息分类：对应t_pub_code 的 code_type=MsgKind： 1-短信；2-邮件 */ 
	private java.lang.String msgKind;

	/** 业务类型：对应t_pub_code 的 code_type=BusinessType： 1-投保；2-退保；3-续保 */ 
	private java.lang.String businessType;

	/** 消息类型：对应t_pub_code 的 code_type=MsgType： 13-投保短信；16-退保短信 */ 
	private java.lang.String msgType;

	/** 发送对象：对应t_pub_code 的 code_type=TargetType： 01-投保人；11-被保险人 */ 
	private java.lang.String targetType;

	/** 消息模版ID */ 
	private java.lang.String msgTmplId;

	/** 消息名称 */ 
	private java.lang.String msgName;

	/** 消息描述 */ 
	private java.lang.String msgDesc;

	/** 消息内容 */ 
	private java.lang.String msgContent;

	/** 失效标志：0-有效，1-失效 */ 
	private java.lang.Integer invalidFlag;

	/** 创建人 */ 
	private java.lang.String createdUser;

	/** 创建时间 */ 
	private java.util.Date createdDate;

	/** 更新人 */ 
	private java.lang.String updatedUser;

	/** 更新时间 */ 
	private java.util.Date updatedDate;

	/** 余额提醒收件人*/
    private String rdRecipientEmail;
    
    /** 余额提醒抄送人*/
    private String rdCcpeopleEmail;
    
	/**
	 * 设置属性主键ID的值
	 */ 
	public void setMsgId(java.lang.Integer msgId) {
		this.msgId = msgId;
	}

	/**
	 * 获取属性主键ID的值
	 */ 
	public java.lang.Integer getMsgId() {
		return this.msgId;
	}

	/**
	 * 设置属性方案主键ID的值
	 */ 
	public void setSolutionId(java.lang.Integer solutionId) {
		this.solutionId = solutionId;
	}

	/**
	 * 获取属性方案主键ID的值
	 */ 
	public java.lang.Integer getSolutionId() {
		return this.solutionId;
	}

	/**
	 * 设置属性消息分类：对应t_pub_code 的 code_type=MsgKind： 1-短信；2-邮件的值
	 */ 
	public void setMsgKind(java.lang.String msgKind) {
		this.msgKind = msgKind;
	}

	/**
	 * 获取属性消息分类：对应t_pub_code 的 code_type=MsgKind： 1-短信；2-邮件的值
	 */ 
	public java.lang.String getMsgKind() {
		return this.msgKind;
	}

	/**
	 * 设置属性业务类型：对应t_pub_code 的 code_type=BusinessType： 1-投保；2-退保；3-续保的值
	 */ 
	public void setBusinessType(java.lang.String businessType) {
		this.businessType = businessType;
	}

	/**
	 * 获取属性业务类型：对应t_pub_code 的 code_type=BusinessType： 1-投保；2-退保；3-续保的值
	 */ 
	public java.lang.String getBusinessType() {
		return this.businessType;
	}

	/**
	 * 设置属性消息类型：对应t_pub_code 的 code_type=MsgType： 13-投保短信；16-退保短信的值
	 */ 
	public void setMsgType(java.lang.String msgType) {
		this.msgType = msgType;
	}

	/**
	 * 获取属性消息类型：对应t_pub_code 的 code_type=MsgType： 13-投保短信；16-退保短信的值
	 */ 
	public java.lang.String getMsgType() {
		return this.msgType;
	}

	/**
	 * 设置属性发送对象：对应t_pub_code 的 code_type=TargetType： 01-投保人；11-被保险人的值
	 */ 
	public void setTargetType(java.lang.String targetType) {
		this.targetType = targetType;
	}

	/**
	 * 获取属性发送对象：对应t_pub_code 的 code_type=TargetType： 01-投保人；11-被保险人的值
	 */ 
	public java.lang.String getTargetType() {
		return this.targetType;
	}

	/**
	 * 设置属性消息模版ID的值
	 */ 
	public void setMsgTmplId(java.lang.String msgTmplId) {
		this.msgTmplId = msgTmplId;
	}

	/**
	 * 获取属性消息模版ID的值
	 */ 
	public java.lang.String getMsgTmplId() {
		return this.msgTmplId;
	}

	/**
	 * 设置属性消息名称的值
	 */ 
	public void setMsgName(java.lang.String msgName) {
		this.msgName = msgName;
	}

	/**
	 * 获取属性消息名称的值
	 */ 
	public java.lang.String getMsgName() {
		return this.msgName;
	}

	/**
	 * 设置属性消息描述的值
	 */ 
	public void setMsgDesc(java.lang.String msgDesc) {
		this.msgDesc = msgDesc;
	}

	/**
	 * 获取属性消息描述的值
	 */ 
	public java.lang.String getMsgDesc() {
		return this.msgDesc;
	}

	/**
	 * 设置属性消息内容的值
	 */ 
	public void setMsgContent(java.lang.String msgContent) {
		this.msgContent = msgContent;
	}

	/**
	 * 获取属性消息内容的值
	 */ 
	public java.lang.String getMsgContent() {
		return this.msgContent;
	}

	/**
	 * 设置属性失效标志：0-有效，1-失效的值
	 */ 
	public void setInvalidFlag(java.lang.Integer invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	/**
	 * 获取属性失效标志：0-有效，1-失效的值
	 */ 
	public java.lang.Integer getInvalidFlag() {
		return this.invalidFlag;
	}

	/**
	 * 设置属性创建人的值
	 */ 
	public void setCreatedUser(java.lang.String createdUser) {
		this.createdUser = createdUser;
	}

	/**
	 * 获取属性创建人的值
	 */ 
	public java.lang.String getCreatedUser() {
		return this.createdUser;
	}

	/**
	 * 设置属性创建时间的值
	 */ 
	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 获取属性创建时间的值
	 */ 
	public java.util.Date getCreatedDate() {
		return this.createdDate;
	}

	/**
	 * 设置属性更新人的值
	 */ 
	public void setUpdatedUser(java.lang.String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * 获取属性更新人的值
	 */ 
	public java.lang.String getUpdatedUser() {
		return this.updatedUser;
	}

	/**
	 * 设置属性更新时间的值
	 */ 
	public void setUpdatedDate(java.util.Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * 获取属性更新时间的值
	 */ 
	public java.util.Date getUpdatedDate() {
		return this.updatedDate;
	}

	/** 余额提醒收件人*/
	public String getRdRecipientEmail() {
		return rdRecipientEmail;
	}
	
	/** 余额提醒收件人*/
	public void setRdRecipientEmail(String rdRecipientEmail) {
		this.rdRecipientEmail = rdRecipientEmail;
	}

	/** 余额提醒抄送人*/
	public String getRdCcpeopleEmail() {
		return rdCcpeopleEmail;
	}

	/** 余额提醒抄送人*/
	public void setRdCcpeopleEmail(String rdCcpeopleEmail) {
		this.rdCcpeopleEmail = rdCcpeopleEmail;
	}
	

}
