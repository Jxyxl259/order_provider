package com.yaic.app.order.dto.msg;

public class LiabilitySwitchReq {
    /** 保单号 **/
    private String policyNo;
    /** 当前保障责任 **/
    private String currentLiability;
    /** 当前责任起期 **/
    private String currentLiabilityStartTime;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

	public String getCurrentLiability() {
		return currentLiability;
	}

	public void setCurrentLiability(String currentLiability) {
		this.currentLiability = currentLiability;
	}

	public String getCurrentLiabilityStartTime() {
		return currentLiabilityStartTime;
	}

	public void setCurrentLiabilityStartTime(String currentLiabilityStartTime) {
		this.currentLiabilityStartTime = currentLiabilityStartTime;
	}

}
