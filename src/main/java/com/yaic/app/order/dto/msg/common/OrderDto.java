package com.yaic.app.order.dto.msg.common;

import java.util.List;

import com.yaic.app.order.dto.domain.OrderCargoDtlDto;
import com.yaic.app.order.dto.domain.OrderCargoDto;
import com.yaic.app.order.dto.domain.OrderClaimDto;
import com.yaic.app.order.dto.domain.OrderClausesDto;
import com.yaic.app.order.dto.domain.OrderCoinsLiabDto;
import com.yaic.app.order.dto.domain.OrderCoinsuranceDto;
import com.yaic.app.order.dto.domain.OrderCommissionDto;
import com.yaic.app.order.dto.domain.OrderCustomerDto;
import com.yaic.app.order.dto.domain.OrderDeductibleDto;
import com.yaic.app.order.dto.domain.OrderDynamicItemDto;
import com.yaic.app.order.dto.domain.OrderDynamicListDto;
import com.yaic.app.order.dto.domain.OrderItemAcciDto;
import com.yaic.app.order.dto.domain.OrderItemAcciLstDto;
import com.yaic.app.order.dto.domain.OrderItemkindDto;
import com.yaic.app.order.dto.domain.OrderLimitDto;
import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.app.order.dto.domain.OrderPartnerDto;
import com.yaic.app.order.dto.domain.OrderPayinfoDto;
import com.yaic.app.order.dto.domain.OrderPaymentPlanDto;
import com.yaic.app.order.dto.domain.OrderPaymentPlanReinsDto;
import com.yaic.app.order.dto.domain.OrderPropertyDto;
import com.yaic.app.order.dto.domain.OrderRescueDto;
import com.yaic.app.order.dto.domain.OrderRiskDynamicDto;
import com.yaic.app.order.dto.domain.OrderSalesmanDto;
import com.yaic.app.order.dto.domain.OrderSpecialClausesDto;
import com.yaic.app.order.dto.domain.ShopOrderGoodsDto;
import com.yaic.app.order.dto.domain.ShopOrderInfoDto;

public class OrderDto {
	
	// 订单详情信息
	private ShopOrderInfoDto shopOrderInfo;
	// 订单信息
	private OrderMainDto orderMain;
	// 订单商品关联信息
	private ShopOrderGoodsDto orderGoods;
	// 险别信息列表
	private List<OrderItemkindDto> itemkindList;
	// 条款信息列表
	private List<OrderClausesDto> clausesList;
	// 特别约定信息列表
	private List<OrderSpecialClausesDto> specialClausesList;
	// 限额信息列表
	private List<OrderLimitDto> limitList;
	// 免赔信息列表
	private List<OrderDeductibleDto> deductibleList;
	// 赔付信息列表
	private List<OrderClaimDto> orderClaimList;
	// 佣金信息列表
	private List<OrderCommissionDto> commissionList;
	// 支付信息
	private OrderPayinfoDto payinfo;
	// 客户信息列表
	private List<OrderCustomerDto> customerList;
	// 意健险人员清单表
	private List<OrderItemAcciLstDto> acciLstList;
	// 合作方信息表
	private List<OrderPartnerDto> partnerList;
	// 业务员信息表
	private List<OrderSalesmanDto> salesmanList;
	/** 共保信息列表 */
	private List<OrderCoinsuranceDto> coinsuranceList;
	/** 共保责任列表 */
	private List<OrderCoinsLiabDto> coinsLiabList;
	// 救援信息表
	private List<OrderRescueDto> rescueList;
	/**-----------------标的部分 每个险种不同 START----------------**/
	// 家财标的信息
	private OrderPropertyDto property;
	// 动态标的信息
	private List<OrderDynamicItemDto> dynamicItemList;
	// 动态清单信息
	private List<OrderDynamicListDto> dynamicListList;
	// 货运险标的信息
	private OrderCargoDto cargo;
	// 货运险标的物信息
	private List<OrderCargoDtlDto> cargoDtlList;
	// 货运险缴费计划信息
	private List<OrderPaymentPlanDto> paymentPlan;
	// 再保分期信息
	private List<OrderPaymentPlanReinsDto> paymentPlanReins;
	// 意健险标的信息
	private List<OrderItemAcciDto> itemAcciList;
	// 意健险险种动态信息
	private List<OrderRiskDynamicDto> riskDynamicList;
	/**-----------------标的部分 每个险种不同   END ----------------**/
	
	public ShopOrderInfoDto getShopOrderInfo() {
	    return shopOrderInfo;
	}
	
	public void setShopOrderInfo(ShopOrderInfoDto shopOrderInfo) {
	    this.shopOrderInfo = shopOrderInfo;
	}
	
	public OrderMainDto getOrderMain() {
	    return orderMain;
	}
	
	public void setOrderMain(OrderMainDto orderMain) {
	    this.orderMain = orderMain;
	}
	
	public ShopOrderGoodsDto getOrderGoods() {
	    return orderGoods;
	}
	
	public void setOrderGoods(ShopOrderGoodsDto orderGoods) {
	    this.orderGoods = orderGoods;
	}
	
	public List<OrderItemkindDto> getItemkindList() {
	    return itemkindList;
	}
	
	public void setItemkindList(List<OrderItemkindDto> itemkindList) {
	    this.itemkindList = itemkindList;
	}
	
	public List<OrderClausesDto> getClausesList() {
	    return clausesList;
	}
	
	public void setClausesList(List<OrderClausesDto> clausesList) {
	    this.clausesList = clausesList;
	}
	
	public List<OrderSpecialClausesDto> getSpecialClausesList() {
	    return specialClausesList;
	}
	
	public void setSpecialClausesList(List<OrderSpecialClausesDto> specialClausesList) {
	    this.specialClausesList = specialClausesList;
	}
	
	public List<OrderLimitDto> getLimitList() {
	    return limitList;
	}
	
	public void setLimitList(List<OrderLimitDto> limitList) {
	    this.limitList = limitList;
	}
	
	public List<OrderDeductibleDto> getDeductibleList() {
		return deductibleList;
	}
	
	public void setDeductibleList(List<OrderDeductibleDto> deductibleList) {
		this.deductibleList = deductibleList;
	}
	
	
	public List<OrderClaimDto> getOrderClaimList() {
		return orderClaimList;
	}
	
	public void setOrderClaimList(List<OrderClaimDto> orderClaimList) {
		this.orderClaimList = orderClaimList;
	}
	
	public List<OrderCommissionDto> getCommissionList() {
		return commissionList;
	}
	
	public void setCommissionList(List<OrderCommissionDto> commissionList) {
		this.commissionList = commissionList;
	}
	
	public OrderPayinfoDto getPayinfo() {
	    return payinfo;
	}
	
	public void setPayinfo(OrderPayinfoDto payinfo) {
	    this.payinfo = payinfo;
	}
	
	public List<OrderCustomerDto> getCustomerList() {
	    return customerList;
	}
	
	public void setCustomerList(List<OrderCustomerDto> customerList) {
	    this.customerList = customerList;
	}
	
	public List<OrderItemAcciLstDto> getAcciLstList() {
	    return acciLstList;
	}
	
	public void setAcciLstList(List<OrderItemAcciLstDto> acciLstList) {
	    this.acciLstList = acciLstList;
	}
	
	/** 合作方信息表 */
	public List<OrderPartnerDto> getPartnerList() {
		return partnerList;
	}
	
	/** 合作方信息列表 */
	public void setPartnerList(List<OrderPartnerDto> partnerList) {
		this.partnerList = partnerList;
	}
	
	/** 业务员信息列表 */
	public List<OrderSalesmanDto> getSalesmanList() {
		return salesmanList;
	}
	
	/** 业务员信息表 */
	public void setSalesmanList(List<OrderSalesmanDto> salesmanList) {
		this.salesmanList = salesmanList;
	}
	
	/** 共保信息列表 */
	public List<OrderCoinsuranceDto> getCoinsuranceList() {
		return coinsuranceList;
	}
	
	/** 共保信息列表 */
	public void setCoinsuranceList(List<OrderCoinsuranceDto> coinsuranceList) {
		this.coinsuranceList = coinsuranceList;
	}

	/** 共保责任列表 */
	public List<OrderCoinsLiabDto> getCoinsLiabList() {
		return coinsLiabList;
	}

	/** 共保责任列表 */
	public void setCoinsLiabList(List<OrderCoinsLiabDto> coinsLiabList) {
		this.coinsLiabList = coinsLiabList;
	}
	
	/** 救援信息表 */
	public List<OrderRescueDto> getRescueList() {
		return rescueList;
	}

	/** 救援信息表 */
	public void setRescueList(List<OrderRescueDto> rescueList) {
		this.rescueList = rescueList;
	}

	public OrderPropertyDto getProperty() {
	    return property;
	}
	
	public void setProperty(OrderPropertyDto property) {
	    this.property = property;
	}
	
	public List<OrderDynamicItemDto> getDynamicItemList() {
	    return dynamicItemList;
	}
	
	public void setDynamicItemList(List<OrderDynamicItemDto> dynamicItemList) {
	    this.dynamicItemList = dynamicItemList;
	}
	
	public List<OrderDynamicListDto> getDynamicListList() {
	    return dynamicListList;
	}
	
	public void setDynamicListList(List<OrderDynamicListDto> dynamicListList) {
	    this.dynamicListList = dynamicListList;
	}
	
	public OrderCargoDto getCargo() {
	    return cargo;
	}
	
	public void setCargo(OrderCargoDto cargo) {
	    this.cargo = cargo;
	}
	
	public List<OrderCargoDtlDto> getCargoDtlList() {
	    return cargoDtlList;
	}
	
	public void setCargoDtlList(List<OrderCargoDtlDto> cargoDtlList) {
	    this.cargoDtlList = cargoDtlList;
	}
	
	public List<OrderPaymentPlanDto> getPaymentPlan() {
	    return paymentPlan;
	}
	
	public void setPaymentPlan(List<OrderPaymentPlanDto> paymentPlan) {
	    this.paymentPlan = paymentPlan;
	}
	
	public List<OrderPaymentPlanReinsDto> getPaymentPlanReins() {
		return paymentPlanReins;
	}

	public void setPaymentPlanReins(List<OrderPaymentPlanReinsDto> paymentPlanReins) {
		this.paymentPlanReins = paymentPlanReins;
	}

	public List<OrderItemAcciDto> getItemAcciList() {
	    return itemAcciList;
	}
	
	public void setItemAcciList(List<OrderItemAcciDto> itemAcciList) {
	    this.itemAcciList = itemAcciList;
	}
	
	public List<OrderRiskDynamicDto> getRiskDynamicList() {
	    return riskDynamicList;
	}
	
	public void setRiskDynamicList(List<OrderRiskDynamicDto> riskDynamicList) {
	    this.riskDynamicList = riskDynamicList;
	}
	
}
