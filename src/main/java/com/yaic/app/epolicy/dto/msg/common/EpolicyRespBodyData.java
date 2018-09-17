package com.yaic.app.epolicy.dto.msg.common;

import com.yaic.app.epolicy.dto.msg.PrintEpolicyResp;

public class EpolicyRespBodyData {
	
	/** 电子保单文件流 */
	private PrintEpolicyResp printEpolicyResp;

	public PrintEpolicyResp getPrintEpolicyResp() {
		return printEpolicyResp;
	}

	public void setPrintEpolicyResp(PrintEpolicyResp printEpolicyResp) {
		this.printEpolicyResp = printEpolicyResp;
	}
	
}
