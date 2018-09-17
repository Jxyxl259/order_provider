package com.yaic.app.fin.dto.msg;

public class FinReqBizData {
	/**暂收款编号*/
	private String poaSerialNo;
	 /** 数据来源 */
    private String dataSource;
	
	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getPoaSerialNo() {
		return poaSerialNo;
	}

	public void setPoaSerialNo(String poaSerialNo) {
		this.poaSerialNo = poaSerialNo;
	}

}
