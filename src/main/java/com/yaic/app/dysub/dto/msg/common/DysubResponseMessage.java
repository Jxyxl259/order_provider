package com.yaic.app.dysub.dto.msg.common;

public class DysubResponseMessage {

    /** -----------公共消息头---------- */
    /** 接口标识 */
    private String interfaceCode;
    /** 应答码*/
    private String code;
    /** 应答信息 */
    private String message;
    /** 返回状态 :1成功;0失败 */
    private String state;
    
    private DysubRespBodyData data = new DysubRespBodyData();

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

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

	public DysubRespBodyData getData() {
		return data;
	}

	public void setData(DysubRespBodyData data) {
		this.data = data;
	}
}
