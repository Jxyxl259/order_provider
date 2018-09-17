package com.yaic.app.order.dto.msg;

public class QueryActivationCardInfoReq{
    
    /** 激活卡卡号 */ 
    private java.lang.String activationCardNo;
    
    /** 激活卡密码 */ 
    private java.lang.String activationPassword;
    
    /** 激活卡类型 （后期维护完善此类型） */ 
    private java.lang.String activationType;
    
    /** 请求的来源： K-客服 */ 
    private java.lang.String referer;
    
    /**
     * 获取属性激活卡账号的值
     */ 
	public java.lang.String getActivationCardNo() {
		return activationCardNo;
	}

	/**
     * 设置属性激活卡账号的值
     */ 
	public void setActivationCardNo(java.lang.String activationCardNo) {
		this.activationCardNo = activationCardNo;
	}

	/**
     * 获取属性激活卡密码的值
     */ 
	public java.lang.String getActivationPassword() {
		return activationPassword;
	}

	/**
     * 设置属性激活卡密码的值
     */ 
	public void setActivationPassword(java.lang.String activationPassword) {
		this.activationPassword = activationPassword;
	}

	/**
     * 获取属性激活卡类型的值
     */ 
	public java.lang.String getActivationType() {
		return activationType;
	}

	/**
     * 设置属性激活卡类型的值
     */ 
	public void setActivationType(java.lang.String activationType) {
		this.activationType = activationType;
	}
    
	/**
     * 获取属性请求的来源： K-客服的值
     */ 
	public java.lang.String getReferer() {
		return referer;
	}

	/**
     * 设置属性请求的来源： K-客服的值
     */ 
	public void setReferer(java.lang.String referer) {
		this.referer = referer;
	}
	
}