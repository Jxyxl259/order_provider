package com.yaic.app.trans.dto.msg.common;

import java.util.Date;

/**
 * @ClassName: RequestMessage
 * @Description: (接口请求消息)
 */
public class TransRequestMessage {

    /** -----------公共消息头---------- */
    /** 接口标识 */
    private String interfaceCode;
    /** 时间戳 */
    private Date requestTime;
    /** 设备序列号 */
    private String uuid;
    /** 用户ID */
    private String userId;
    /**是否分单 Y-是 N-否*/
    private String isSubPolicy;
    
    /** ------------实体部分---------- */
    private TransReqBodyData data = new TransReqBodyData();

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

    public String getIsSubPolicy() {
		return isSubPolicy;
	}

	public void setIsSubPolicy(String isSubPolicy) {
		this.isSubPolicy = isSubPolicy;
	}

	public TransReqBodyData getData() {
        return data;
    }

    public void setData(TransReqBodyData data) {
        this.data = data;
    }
}
