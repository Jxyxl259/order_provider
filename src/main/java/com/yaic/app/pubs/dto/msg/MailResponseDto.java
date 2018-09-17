package com.yaic.app.pubs.dto.msg;

public class MailResponseDto {
    
    /**返回代码  0000:成功 其他:失败*/
    private String code;
    
    /**返回信息*/
    private String message;
    
    /** 状态标识码 */
    private String statusCode;

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

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
