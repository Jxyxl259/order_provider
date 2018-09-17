/*
 * Created By lujicong (2016-08-05 13:56:42)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2016
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_commission")
public class OrderCommissionDto implements Serializable {
    
    private static final long serialVersionUID = OrderCommissionDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 主键ID */ 
    @Id
    private java.lang.Integer commissionId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 0000表示没有计划 */ 
    private java.lang.String planCode;
    
    /** 险种代码 */ 
    private java.lang.String riskCode;
    
    /** 代理佣金，出单手续费，etc */ 
    private java.lang.String commissionType;
    
    /** 佣金分配者类型 */ 
    private java.lang.String sharerType;
    
    /** 佣金分配者编码 */ 
    private java.lang.String sharerCode;
    
    /** 币别 */ 
    private java.lang.String currency;
    
    /** 佣金折扣比例 */ 
    private java.math.BigDecimal commissionPercent;
    
    /** 佣金折扣毛费比例 */ 
    private java.math.BigDecimal commissionGrossPercent;
    
    /** 佣金折扣净费比例 */ 
    private java.math.BigDecimal commissionNetPercent;
    
    /** 原始佣金/折扣金额 */ 
    private java.math.BigDecimal orgCommissionAmount;
    
    /** 佣金/折扣金额 */ 
    private java.math.BigDecimal commissionAmount;
    
    /** 0:否;1:是 */ 
    private java.lang.String mainSubAccountInd;
    
    /** 0:否;1:是 */ 
    private java.lang.String middleCostInd;
    
    /** 备注 */ 
    private java.lang.String remark;
    
    /** 允许修改佣金0:否;1:是 */ 
    private java.lang.String modifyInd;
    
    /** 序号 */ 
    private java.lang.Integer serialNo;
    
    /** 标的序号 */ 
    private java.lang.Integer itemNo;
    
    /** 最大佣金折扣比例 */ 
    private java.math.BigDecimal maxCommissionPercent;
    
    /** 规则ID */ 
    private java.lang.String ruleId;
    
    /** 销售费用状态 */ 
    private java.lang.String salesState;
    
    /** 分公司佣金折扣比例 */ 
    private java.math.BigDecimal branchCommissionRate;
    
    /** 中心支公司佣金折扣比例 */ 
    private java.math.BigDecimal centerCommissionRate;
    
    /** 手续费上限 */ 
    private java.math.BigDecimal topCommission;
    
    /** 失效标志:0正常,1作废值 */ 
    private java.lang.Integer invalidFlag;
    
    /** 创建人 */ 
    private java.lang.String createdUser;
    
    /** 创建时间 */ 
    private java.util.Date createdDate;
    
    /** 更新人 */ 
    private java.lang.String updatedUser;
    
    /** 更新时间 */ 
    private java.util.Date updatedDate;
    
    /** 用户id */ 
    public BigInteger getUserId() {
        return userId;
    }

    /** 用户id */ 
    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
    
    /**
     * 设置属性主键ID的值
     */ 
    public java.lang.Integer getCommissionId() {
        return commissionId;
    }
    
    /**
     * 获取属性主键ID的值
     */ 
    public void setCommissionId(java.lang.Integer commissionId) {
        this.commissionId = commissionId;
    }
    
    /**
     * 设置属性订单主表id的值
     */ 
    public void setOrderMainId(BigInteger orderMainId) {
        this.orderMainId = orderMainId;
    }
    
    /**
     * 获取属性订单主表id的值
     */ 
    public BigInteger getOrderMainId() {
        return orderMainId;
    }

    
    /**
     * 设置属性订单编号的值
     */ 
    public BigInteger getOrderCode() {
        return orderCode;
    }
    
    /**
     * 获取属性订单编号的值
     */ 
    public void setOrderCode(BigInteger orderCode) {
        this.orderCode = orderCode;
    }
    
    /**
     * 设置属性0000表示没有计划的值
     */ 
    public void setPlanCode(java.lang.String planCode) {
        this.planCode = planCode;
    }
    
    /**
     * 获取属性0000表示没有计划的值
     */ 
    public java.lang.String getPlanCode() {
        return this.planCode;
    }
    
    /**
     * 设置属性险种代码的值
     */ 
    public void setRiskCode(java.lang.String riskCode) {
        this.riskCode = riskCode;
    }
    
    /**
     * 获取属性险种代码的值
     */ 
    public java.lang.String getRiskCode() {
        return this.riskCode;
    }
    
    /**
     * 设置属性代理佣金，出单手续费，etc的值
     */ 
    public void setCommissionType(java.lang.String commissionType) {
        this.commissionType = commissionType;
    }
    
    /**
     * 获取属性代理佣金，出单手续费，etc的值
     */ 
    public java.lang.String getCommissionType() {
        return this.commissionType;
    }
    
    /**
     * 设置属性佣金分配者类型的值
     */ 
    public void setSharerType(java.lang.String sharerType) {
        this.sharerType = sharerType;
    }
    
    /**
     * 获取属性佣金分配者类型的值
     */ 
    public java.lang.String getSharerType() {
        return this.sharerType;
    }
    
    /**
     * 设置属性佣金分配者编码的值
     */ 
    public void setSharerCode(java.lang.String sharerCode) {
        this.sharerCode = sharerCode;
    }
    
    /**
     * 获取属性佣金分配者编码的值
     */ 
    public java.lang.String getSharerCode() {
        return this.sharerCode;
    }
    
    /**
     * 设置属性币别的值
     */ 
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }
    
    /**
     * 获取属性币别的值
     */ 
    public java.lang.String getCurrency() {
        return this.currency;
    }
    
    /**
     * 设置属性佣金折扣比例的值
     */ 
    public void setCommissionPercent(java.math.BigDecimal commissionPercent) {
        this.commissionPercent = commissionPercent;
    }
    
    /**
     * 获取属性佣金折扣比例的值
     */ 
    public java.math.BigDecimal getCommissionPercent() {
        return this.commissionPercent;
    }
    
    /**
     * 设置属性佣金折扣毛费比例的值
     */ 
    public void setCommissionGrossPercent(java.math.BigDecimal commissionGrossPercent) {
        this.commissionGrossPercent = commissionGrossPercent;
    }
    
    /**
     * 获取属性佣金折扣毛费比例的值
     */ 
    public java.math.BigDecimal getCommissionGrossPercent() {
        return this.commissionGrossPercent;
    }
    
    /**
     * 设置属性佣金折扣净费比例的值
     */ 
    public void setCommissionNetPercent(java.math.BigDecimal commissionNetPercent) {
        this.commissionNetPercent = commissionNetPercent;
    }
    
    /**
     * 获取属性佣金折扣净费比例的值
     */ 
    public java.math.BigDecimal getCommissionNetPercent() {
        return this.commissionNetPercent;
    }
    
    /**
     * 设置属性原始佣金/折扣金额的值
     */ 
    public void setOrgCommissionAmount(java.math.BigDecimal orgCommissionAmount) {
        this.orgCommissionAmount = orgCommissionAmount;
    }
    
    /**
     * 获取属性原始佣金/折扣金额的值
     */ 
    public java.math.BigDecimal getOrgCommissionAmount() {
        return this.orgCommissionAmount;
    }
    
    /**
     * 设置属性佣金/折扣金额的值
     */ 
    public void setCommissionAmount(java.math.BigDecimal commissionAmount) {
        this.commissionAmount = commissionAmount;
    }
    
    /**
     * 获取属性佣金/折扣金额的值
     */ 
    public java.math.BigDecimal getCommissionAmount() {
        return this.commissionAmount;
    }
    
    /**
     * 设置属性0:否;1:是的值
     */ 
    public void setMainSubAccountInd(java.lang.String mainSubAccountInd) {
        this.mainSubAccountInd = mainSubAccountInd;
    }
    
    /**
     * 获取属性0:否;1:是的值
     */ 
    public java.lang.String getMainSubAccountInd() {
        return this.mainSubAccountInd;
    }
    
    /**
     * 设置属性0:否;1:是的值
     */ 
    public void setMiddleCostInd(java.lang.String middleCostInd) {
        this.middleCostInd = middleCostInd;
    }
    
    /**
     * 获取属性0:否;1:是的值
     */ 
    public java.lang.String getMiddleCostInd() {
        return this.middleCostInd;
    }
    
    /**
     * 设置属性备注的值
     */ 
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }
    
    /**
     * 获取属性备注的值
     */ 
    public java.lang.String getRemark() {
        return this.remark;
    }
    
    /**
     * 设置属性允许修改佣金0:否;1:是的值
     */ 
    public void setModifyInd(java.lang.String modifyInd) {
        this.modifyInd = modifyInd;
    }
    
    /**
     * 获取属性允许修改佣金0:否;1:是的值
     */ 
    public java.lang.String getModifyInd() {
        return this.modifyInd;
    }
    
    /**
     * 设置属性序号的值
     */ 
    public void setSerialNo(java.lang.Integer serialNo) {
        this.serialNo = serialNo;
    }
    
    /**
     * 获取属性序号的值
     */ 
    public java.lang.Integer getSerialNo() {
        return this.serialNo;
    }
    
    /**
     * 设置属性标的序号的值
     */ 
    public void setItemNo(java.lang.Integer itemNo) {
        this.itemNo = itemNo;
    }
    
    /**
     * 获取属性标的序号的值
     */ 
    public java.lang.Integer getItemNo() {
        return this.itemNo;
    }
    
    /**
     * 设置属性最大佣金折扣比例的值
     */ 
    public void setMaxCommissionPercent(java.math.BigDecimal maxCommissionPercent) {
        this.maxCommissionPercent = maxCommissionPercent;
    }
    
    /**
     * 获取属性最大佣金折扣比例的值
     */ 
    public java.math.BigDecimal getMaxCommissionPercent() {
        return this.maxCommissionPercent;
    }
    
    /**
     * 设置属性规则ID的值
     */ 
    public void setRuleId(java.lang.String ruleId) {
        this.ruleId = ruleId;
    }
    
    /**
     * 获取属性规则ID的值
     */ 
    public java.lang.String getRuleId() {
        return this.ruleId;
    }
    
    /**
     * 设置属性销售费用状态的值
     */ 
    public void setSalesState(java.lang.String salesState) {
        this.salesState = salesState;
    }
    
    /**
     * 获取属性销售费用状态的值
     */ 
    public java.lang.String getSalesState() {
        return this.salesState;
    }
    
    /**
     * 设置属性分公司佣金折扣比例的值
     */ 
    public void setBranchCommissionRate(java.math.BigDecimal branchCommissionRate) {
        this.branchCommissionRate = branchCommissionRate;
    }
    
    /**
     * 获取属性分公司佣金折扣比例的值
     */ 
    public java.math.BigDecimal getBranchCommissionRate() {
        return this.branchCommissionRate;
    }
    
    /**
     * 设置属性中心支公司佣金折扣比例的值
     */ 
    public void setCenterCommissionRate(java.math.BigDecimal centerCommissionRate) {
        this.centerCommissionRate = centerCommissionRate;
    }
    
    /**
     * 获取属性中心支公司佣金折扣比例的值
     */ 
    public java.math.BigDecimal getCenterCommissionRate() {
        return this.centerCommissionRate;
    }
    
    /**
     * 设置属性手续费上限的值
     */ 
    public void setTopCommission(java.math.BigDecimal topCommission) {
        this.topCommission = topCommission;
    }
    
    /**
     * 获取属性手续费上限的值
     */ 
    public java.math.BigDecimal getTopCommission() {
        return this.topCommission;
    }
    
    /**
     * 设置属性失效标志:0正常,1作废值的值
     */ 
    public void setInvalidFlag(java.lang.Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性失效标志:0正常,1作废值的值
     */ 
    public java.lang.Integer getInvalidFlag() {
        return this.invalidFlag;
    }
    
    /**
     * 设置属性创建人的值
     */ 
    public void setCreatedUser(java.lang.String createdUser) {
        this.createdUser = createdUser;
    }
    
    /**
     * 获取属性创建人的值
     */ 
    public java.lang.String getCreatedUser() {
        return this.createdUser;
    }
    
    /**
     * 设置属性创建时间的值
     */ 
    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }
    
    /**
     * 获取属性创建时间的值
     */ 
    public java.util.Date getCreatedDate() {
        return this.createdDate;
    }
    
    /**
     * 设置属性更新人的值
     */ 
    public void setUpdatedUser(java.lang.String updatedUser) {
        this.updatedUser = updatedUser;
    }
    
    /**
     * 获取属性更新人的值
     */ 
    public java.lang.String getUpdatedUser() {
        return this.updatedUser;
    }
    
    /**
     * 设置属性更新时间的值
     */ 
    public void setUpdatedDate(java.util.Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    /**
     * 获取属性更新时间的值
     */ 
    public java.util.Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    
}