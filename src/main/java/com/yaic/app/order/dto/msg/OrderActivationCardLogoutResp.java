package com.yaic.app.order.dto.msg;

public class OrderActivationCardLogoutResp {
    
    /** 激活/核销状态   0入参检验失败，系统异常，激活卡不可用,1激活卡激活成功 */
    private String logoutStatus;

    /** 激活/核销状态   0入参检验失败，系统异常，激活卡不可用,1激活卡激活成功 */
	public String getLogoutStatus() {
		return logoutStatus;
	}

	/** 激活/核销状态   0入参检验失败，系统异常，激活卡不可用,1激活卡激活成功 */
	public void setLogoutStatus(String logoutStatus) {
		this.logoutStatus = logoutStatus;
	}
    
}