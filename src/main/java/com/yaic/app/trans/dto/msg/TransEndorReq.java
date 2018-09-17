package com.yaic.app.trans.dto.msg;

import java.util.Date;
import java.util.List;

import com.yaic.app.order.dto.domain.OrderCustomerDto;
import com.yaic.app.order.dto.domain.OrderDynamicItemDto;
import com.yaic.app.order.dto.domain.OrderDynamicListDto;
import com.yaic.app.order.dto.domain.OrderItemAcciBenDto;
import com.yaic.app.order.dto.domain.OrderItemAcciDto;
import com.yaic.app.order.dto.domain.OrderItemAcciLstDto;
import com.yaic.app.order.dto.domain.OrderItemkindDto;
import com.yaic.app.order.dto.domain.OrderRiskDynamicDto;

public class TransEndorReq {
	
	/** 生效日期 **/
	private Date validDate;
	
	/** 保单号 **/
	private String policyNo;
	
	/** 账户银行 **/
	private String accountBank;
	
	/** 账户名 **/
	private String accountName;
	
	/** 账户卡号 **/
	private String accountNumber;
	
	/** 批改类型: 01-批改关系人；02-批改保单条款；08-批改承保风险；15-保单注销；16-全单退保；19-变更保险止期；23-变更承保区域/范围；24-变更司法管辖；33-变更付款人；34-变更特别约定/备注；90-批改追溯/发现期 **/
	private String endorType;
	
	/** 入园时间 **/
	private String effectTime;
	
	/** 出园时间 **/
	private String expiryTime;
	
	/** 动态标的 **/
	private OrderDynamicItemDto dynamicItem;
	
	
	/** 批改单号*/
	private String endorNo;
	
	/** 投保人信息*/
	private List<OrderCustomerDto> customerList;
	
	/** 意健险标的信息 */
	private List<OrderItemAcciDto> itemAcciList;
	
	/** 被保险人清单信息*/
	private List<OrderItemAcciLstDto> itemAcciLstList;
	
	/** 受益人清单信息*/
	private List<OrderItemAcciBenDto> itemAcciBenList;
	
	/** 动态标的清单 **/
	private List<OrderDynamicListDto> orderDynamicListList;
	
	/** 险别信息 **/
	private List<OrderItemkindDto> itemkindList;
	
	
	/** 终保日期 **/
	private Date endDate;
	
	/** 动态标的信息（家财责任） **/
	private List<OrderDynamicItemDto> dynamicItemList;
	
	/** 动态标的信息（意健险） **/
	private List<OrderRiskDynamicDto> riskDynamicItemList;
	
	/**当前缴费金额**/
	private Double planFee;
	
	public String getEndorNo() {
		return endorNo;
	}
	
	public void setEndorNo(String endorNo) {
		this.endorNo = endorNo;
	}
	
	public List<OrderCustomerDto> getCustomerList() {
		return customerList;
	}
	
	public void setCustomerList(List<OrderCustomerDto> customerList) {
		this.customerList = customerList;
	}
	
	/** 意健险标的信息 */
	public List<OrderItemAcciDto> getItemAcciList() {
		return itemAcciList;
	}
	
	/** 意健险标的信息 */
	public void setItemAcciList(List<OrderItemAcciDto> itemAcciList) {
		this.itemAcciList = itemAcciList;
	}
	
	public List<OrderItemAcciLstDto> getItemAcciLstList() {
		return itemAcciLstList;
	}
	
	public void setItemAcciLstList(List<OrderItemAcciLstDto> itemAcciLstList) {
		this.itemAcciLstList = itemAcciLstList;
	}
	
	public List<OrderItemAcciBenDto> getItemAcciBenList() {
		return itemAcciBenList;
	}
	
	public void setItemAcciBenList(List<OrderItemAcciBenDto> itemAcciBenList) {
		this.itemAcciBenList = itemAcciBenList;
	}
	
	public Date getValidDate() {
	    return validDate;
	}
	
	public void setValidDate(Date validDate) {
	    this.validDate = validDate;
	}
	
	public String getPolicyNo() {
	    return policyNo;
	}
	
	public void setPolicyNo(String policyNo) {
	    this.policyNo = policyNo;
	}
	
	public String getAccountBank() {
	    return accountBank;
	}
	
	public void setAccountBank(String accountBank) {
	    this.accountBank = accountBank;
	}
	
	public String getAccountName() {
	    return accountName;
	}
	
	public void setAccountName(String accountName) {
	    this.accountName = accountName;
	}
	
	public String getAccountNumber() {
	    return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
	    this.accountNumber = accountNumber;
	}
	
	public String getEndorType() {
		return endorType;
	}
	
	public void setEndorType(String endorType) {
		this.endorType = endorType;
	}
	
	public String getEffectTime() {
		return effectTime;
	}
	
	public void setEffectTime(String effectTime) {
		this.effectTime = effectTime;
	}
	
	public String getExpiryTime() {
		return expiryTime;
	}
	
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}
	
	public OrderDynamicItemDto getDynamicItem() {
		return dynamicItem;
	}
	
	public void setDynamicItem(OrderDynamicItemDto dynamicItem) {
		this.dynamicItem = dynamicItem;
	}
	
	/** 动态标的清单 **/
	public List<OrderDynamicListDto> getOrderDynamicListList() {
		return orderDynamicListList;
	}
	
	/** 动态标的清单 **/
	public void setOrderDynamicListList(List<OrderDynamicListDto> orderDynamicListList) {
		this.orderDynamicListList = orderDynamicListList;
	}
	
	/** 险别信息 **/
	public List<OrderItemkindDto> getItemkindList() {
		return itemkindList;
	}
	
	/** 险别信息 **/
	public void setItemkindList(List<OrderItemkindDto> itemkindList) {
		this.itemkindList = itemkindList;
	}
	
	/** 终保日期 **/
	public Date getEndDate() {
		return endDate;
	}
	
	/** 终保日期 **/
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/** 动态标的信息（家财责任） **/
	public List<OrderDynamicItemDto> getDynamicItemList() {
		return dynamicItemList;
	}
	
	/** 动态标的信息（家财责任） **/
	public void setDynamicItemList(List<OrderDynamicItemDto> dynamicItemList) {
		this.dynamicItemList = dynamicItemList;
	}
	
	/** 动态标的信息（意健险） **/
	public List<OrderRiskDynamicDto> getRiskDynamicItemList() {
		return riskDynamicItemList;
	}
	
	/** 动态标的信息（意健险） **/
	public void setRiskDynamicItemList(List<OrderRiskDynamicDto> riskDynamicItemList) {
		this.riskDynamicItemList = riskDynamicItemList;
	}
	
	/**当前缴费金额**/
	public Double getPlanFee() {
		return planFee;
	}
	
	/**当前缴费金额**/
	public void setPlanFee(Double planFee) {
		this.planFee = planFee;
	}
}
