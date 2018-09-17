package com.yaic.app.epolicy.dto.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EpolicyItemCargoDto {

	/** 序号 */
	@XStreamAlias("SERIALNO")
	private String serialNo;
	
	/** 标的物类别 */
	@XStreamAlias("ITEMDETAILNAME")
	private String itemDetailName;
	
	/** 标的物明细名称 */
	@XStreamAlias("ITEMDETAILLIST")
	private String itemDetailList;
	
	/** 包装 */
	@XStreamAlias("PACKING")
	private String packing;
	
	/** 数量 */
	@XStreamAlias("QUANTITY")
	private String quantity;
	
	/** 保险金额 */
	@XStreamAlias("SUMINSURED")
	private String sumInsured;

	/** 序号 */
	public String getSerialNo() {
		return serialNo;
	}

	/** 序号 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	/** 标的物类别 */
	public String getItemDetailName() {
		return itemDetailName;
	}

	/** 标的物类别 */
	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	}

	/** 标的物明细名称 */
	public String getItemDetailList() {
		return itemDetailList;
	}

	/** 标的物明细名称 */
	public void setItemDetailList(String itemDetailList) {
		this.itemDetailList = itemDetailList;
	}

	/** 包装 */
	public String getPacking() {
		return packing;
	}

	/** 包装 */
	public void setPacking(String packing) {
		this.packing = packing;
	}

	/** 数量 */
	public String getQuantity() {
		return quantity;
	}

	/** 数量 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/** 保险金额 */
	public String getSumInsured() {
		return sumInsured;
	}

	/** 保险金额 */
	public void setSumInsured(String sumInsured) {
		this.sumInsured = sumInsured;
	}
	
}
