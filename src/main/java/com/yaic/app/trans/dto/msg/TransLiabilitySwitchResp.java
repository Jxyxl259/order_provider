package com.yaic.app.trans.dto.msg;

public class TransLiabilitySwitchResp {

    /** 是否通过标示 **/
    private String passFlag;
    /** 责任切换返回信息 **/
    private String meassage;

    public String getPassFlag() {
        return passFlag;
    }

    public void setPassFlag(String passFlag) {
        this.passFlag = passFlag;
    }

    public String getMeassage() {
        return meassage;
    }

    public void setMeassage(String meassage) {
        this.meassage = meassage;
    }
    
}
