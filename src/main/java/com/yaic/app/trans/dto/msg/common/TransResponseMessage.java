package com.yaic.app.trans.dto.msg.common;

/**
 * @ClassName: ResponseMessage
 * @Description: (接口响应消息)
 */
public class TransResponseMessage {
    
    /** -----------公共消息头---------- */
    /** 应答码*/
    private String code;
    /** 应答信息 */
    private String message;
    /** 返回状态 :1成功;0失败 */
    private String state;
    /** 状态标识码 */
    private String statusCode;
    
    /** ------------实体部分---------- */
    private TransRespBodyData data = new TransRespBodyData();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TransRespBodyData getData() {
        return data;
    }

    public void setData(TransRespBodyData data) {
        this.data = data;
    }

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
