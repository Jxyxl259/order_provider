package com.yaic.app.order.dto.msg.common;

/**
 * @ClassName: ResponseMessage
 * @Description: (接口响应消息)
 */
public class ResponseMessage {
    
    /** -----------公共消息头---------- */
    /** 应答码*/
    private String code;
    /** 应答信息 */
    private String message;
    /** 返回状态 :1成功;0失败 */
    private String state;
    /** 异常栈轨迹*/
    private String stackTrace;
    /** 状态标识码 */
    private String statusCode;
    
    /** ------------实体部分---------- */
    private RespBodyData data = new RespBodyData();

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

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public RespBodyData getData() {
        return data;
    }

    public void setData(RespBodyData data) {
        this.data = data;
    }

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
