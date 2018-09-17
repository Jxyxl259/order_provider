package com.yaic.app.order.dto.msg;

public class LiabilitySwitchResp {

    /** 是否通过标示 **/
    private String passFlag;
    
    /** 责任切换返回信息 **/
    private String message;

    public String getPassFlag() {
        return passFlag;
    }

    public void setPassFlag(String passFlag) {
        this.passFlag = passFlag;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
