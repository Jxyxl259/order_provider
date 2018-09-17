/*
 * Created By lujicong (2018-01-10 14:02:54)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2018
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_coinsurance")
public class OrderCoinsuranceDto implements Serializable {
    
    private static final long serialVersionUID = OrderCoinsuranceDto.class.getName().hashCode();
    
    /** 自增主键ID */ 
    @Id
    private java.lang.Integer coinsuranceId;
    
    /** 订单主表id */ 
    private java.math.BigInteger orderMainId;
    
    /** 订单编号 */ 
    private java.math.BigInteger orderCode;
    
    /** 共保保单号 */ 
    private java.lang.String coinsPolicyNo;
    
    /** 共保人代码 基础数据对应表：select * from pub_coins */ 
    private java.lang.String coinsCode;
    
    /** 共保人名称 基础数据对应表：select * from pub_coins */ 
    private java.lang.String coinsName;
    
    /** 1：我方；2：系统内他方；3：系统外他方；代码对应数据表PUB_CODE.CodeCode（CodeType=CoinsType） */ 
    private java.lang.String coinsType;
    
    /** 共保份额 */ 
    private java.math.BigDecimal coinsRate;
    
    /** 1 主方/2 从方；代码对应数据表PUB_CODE.CodeCode（CodeType=PrincipalInd） */ 
    private java.lang.String principalInd;
    
    /** 0 否/1 是；代码对应数据表PUB_CODE.CodeCode（CodeType=LeaderInd） */ 
    private java.lang.String leaderInd;
    
    /** 0 否/1 是；代码对应数据表PUB_CODE.CodeCode（CodeType=ChiefAdjusterInd） */ 
    private java.lang.String chiefAdjusterInd;
    
    /** 需要和保单主表中的币别一致； */ 
    private java.lang.String currency;
    
    /** 共保保额 */ 
    private java.math.BigDecimal coinsInsured;
    
    /** 共保保费 */ 
    private java.math.BigDecimal coinsPremium;
    
    /** 共保手续费比例 */ 
    private java.math.BigDecimal coinsHandlingRate;
    
    /** 共保手续费 */ 
    private java.math.BigDecimal coinsHandlingFee;
    
    /** 共保代理佣金比例 */ 
    private java.math.BigDecimal coinsAgencyRate;
    
    /** 共保代理佣金 */ 
    private java.math.BigDecimal coinsAgencyCommission;
    
    /** 共保出单费比例 */ 
    private java.math.BigDecimal coinsIssueRate;
    
    /** 共保出单费 */ 
    private java.math.BigDecimal coinsIssueExpense;
    
    /** 备注 */ 
    private java.lang.String remark;
    
    /** 标志字段 */ 
    private java.lang.String flag;
    
    /** 1 从客户处收取/2 从主方处收取； */ 
    private java.lang.String coinsPremiumAcceptInd;
    
    /** 共保保费组成,： 第一位 净手续费； 第二位 净代理佣金； 第三位 净出单费； 第四位 净政府徴费； 第五位 净賠償儲備金； 第六位 净其他费用； 其中，0 否/1 是；' */ 
    private java.lang.String coinsPremiumCompose;
    
    /** 0 付给代理/1 -付给主方 */ 
    private java.lang.String coinsAgencyPayInd;
    
    /** 0 由主方征收/1 从方自己征收 */ 
    private java.lang.String coinsLevyAcceptInd;
    
    /** 共保其它费用比例 */ 
    private java.math.BigDecimal coinsOthFeeRate;
    
    /** 共保其它费用 */ 
    private java.math.BigDecimal coinsOthFee;
    
    /** 0 从客户处收取/1 从主户处收取 */ 
    private java.lang.String coinsOthfeeAcceptInd;
    
    /** 共保赔偿储备金比例 */ 
    private java.math.BigDecimal coinsCompReserveRate;
    
    /** 共保赔偿储备金 */ 
    private java.math.BigDecimal coinsCompReserve;
    
    /** 0 由主方征收/1 从方自己征收 */ 
    private java.lang.String coinsCompResAcceptInd;
    
    /** 帐单接受人 */ 
    private java.lang.String debitAccepter;
    
    /** 0：我方代支付；1：按比例支付 */ 
    private java.lang.String coinsClaimInd;
    
    /** 是否有效:0正常,1作废值 */ 
    private java.lang.Integer invalidFlag;
    
    /** 创建人 */ 
    private java.lang.String createdUser;
    
    /** 创建时间 */ 
    private java.util.Date createdDate;
    
    /** 更新人 */ 
    private java.lang.String updatedUser;
    
    /** 更新时间 */ 
    private java.util.Date updatedDate;
    
    
    /**
     * 设置属性自增主键ID的值
     */ 
    public void setCoinsuranceId(java.lang.Integer coinsuranceId) {
        this.coinsuranceId = coinsuranceId;
    }
    
    /**
     * 获取属性自增主键ID的值
     */ 
    public java.lang.Integer getCoinsuranceId() {
        return this.coinsuranceId;
    }
    
    /**
     * 设置属性订单主表id的值
     */ 
    public void setOrderMainId(java.math.BigInteger orderMainId) {
        this.orderMainId = orderMainId;
    }
    
    /**
     * 获取属性订单主表id的值
     */ 
    public java.math.BigInteger getOrderMainId() {
        return this.orderMainId;
    }
    
    /**
     * 设置属性订单编号的值
     */ 
    public void setOrderCode(java.math.BigInteger orderCode) {
        this.orderCode = orderCode;
    }
    
    /**
     * 获取属性订单编号的值
     */ 
    public java.math.BigInteger getOrderCode() {
        return this.orderCode;
    }
    
    /**
     * 设置属性共保保单号的值
     */ 
    public void setCoinsPolicyNo(java.lang.String coinsPolicyNo) {
        this.coinsPolicyNo = coinsPolicyNo;
    }
    
    /**
     * 获取属性共保保单号的值
     */ 
    public java.lang.String getCoinsPolicyNo() {
        return this.coinsPolicyNo;
    }
    
    /**
     * 设置属性共保人代码的值
     */ 
    public void setCoinsCode(java.lang.String coinsCode) {
        this.coinsCode = coinsCode;
    }
    
    /**
     * 获取属性共保人代码的值
     */ 
    public java.lang.String getCoinsCode() {
        return this.coinsCode;
    }
    
    /**
     * 设置属性共保人名称的值
     */ 
    public void setCoinsName(java.lang.String coinsName) {
        this.coinsName = coinsName;
    }
    
    /**
     * 获取属性共保人名称的值
     */ 
    public java.lang.String getCoinsName() {
        return this.coinsName;
    }
    
    /**
     * 设置属性1：我方；2：系统内他方；3：系统外他方；代码对应数据表PUB_CODE.CodeCode（CodeType=CoinsType）的值
     */ 
    public void setCoinsType(java.lang.String coinsType) {
        this.coinsType = coinsType;
    }
    
    /**
     * 获取属性1：我方；2：系统内他方；3：系统外他方；代码对应数据表PUB_CODE.CodeCode（CodeType=CoinsType）的值
     */ 
    public java.lang.String getCoinsType() {
        return this.coinsType;
    }
    
    /**
     * 设置属性共保份额的值
     */ 
    public void setCoinsRate(java.math.BigDecimal coinsRate) {
        this.coinsRate = coinsRate;
    }
    
    /**
     * 获取属性共保份额的值
     */ 
    public java.math.BigDecimal getCoinsRate() {
        return this.coinsRate;
    }
    
    /**
     * 设置属性1 主方/2 从方；代码对应数据表PUB_CODE.CodeCode（CodeType=PrincipalInd）的值
     */ 
    public void setPrincipalInd(java.lang.String principalInd) {
        this.principalInd = principalInd;
    }
    
    /**
     * 获取属性1 主方/2 从方；代码对应数据表PUB_CODE.CodeCode（CodeType=PrincipalInd）的值
     */ 
    public java.lang.String getPrincipalInd() {
        return this.principalInd;
    }
    
    /**
     * 设置属性0 否/1 是；代码对应数据表PUB_CODE.CodeCode（CodeType=LeaderInd）的值
     */ 
    public void setLeaderInd(java.lang.String leaderInd) {
        this.leaderInd = leaderInd;
    }
    
    /**
     * 获取属性0 否/1 是；代码对应数据表PUB_CODE.CodeCode（CodeType=LeaderInd）的值
     */ 
    public java.lang.String getLeaderInd() {
        return this.leaderInd;
    }
    
    /**
     * 设置属性0 否/1 是；代码对应数据表PUB_CODE.CodeCode（CodeType=ChiefAdjusterInd）的值
     */ 
    public void setChiefAdjusterInd(java.lang.String chiefAdjusterInd) {
        this.chiefAdjusterInd = chiefAdjusterInd;
    }
    
    /**
     * 获取属性0 否/1 是；代码对应数据表PUB_CODE.CodeCode（CodeType=ChiefAdjusterInd）的值
     */ 
    public java.lang.String getChiefAdjusterInd() {
        return this.chiefAdjusterInd;
    }
    
    /**
     * 设置属性需要和保单主表中的币别一致；的值
     */ 
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }
    
    /**
     * 获取属性需要和保单主表中的币别一致；的值
     */ 
    public java.lang.String getCurrency() {
        return this.currency;
    }
    
    /**
     * 设置属性共保保额的值
     */ 
    public void setCoinsInsured(java.math.BigDecimal coinsInsured) {
        this.coinsInsured = coinsInsured;
    }
    
    /**
     * 获取属性共保保额的值
     */ 
    public java.math.BigDecimal getCoinsInsured() {
        return this.coinsInsured;
    }
    
    /**
     * 设置属性共保保费的值
     */ 
    public void setCoinsPremium(java.math.BigDecimal coinsPremium) {
        this.coinsPremium = coinsPremium;
    }
    
    /**
     * 获取属性共保保费的值
     */ 
    public java.math.BigDecimal getCoinsPremium() {
        return this.coinsPremium;
    }
    
    /**
     * 设置属性共保手续费比例的值
     */ 
    public void setCoinsHandlingRate(java.math.BigDecimal coinsHandlingRate) {
        this.coinsHandlingRate = coinsHandlingRate;
    }
    
    /**
     * 获取属性共保手续费比例的值
     */ 
    public java.math.BigDecimal getCoinsHandlingRate() {
        return this.coinsHandlingRate;
    }
    
    /**
     * 设置属性共保手续费的值
     */ 
    public void setCoinsHandlingFee(java.math.BigDecimal coinsHandlingFee) {
        this.coinsHandlingFee = coinsHandlingFee;
    }
    
    /**
     * 获取属性共保手续费的值
     */ 
    public java.math.BigDecimal getCoinsHandlingFee() {
        return this.coinsHandlingFee;
    }
    
    /**
     * 设置属性共保代理佣金比例的值
     */ 
    public void setCoinsAgencyRate(java.math.BigDecimal coinsAgencyRate) {
        this.coinsAgencyRate = coinsAgencyRate;
    }
    
    /**
     * 获取属性共保代理佣金比例的值
     */ 
    public java.math.BigDecimal getCoinsAgencyRate() {
        return this.coinsAgencyRate;
    }
    
    /**
     * 设置属性共保代理佣金的值
     */ 
    public void setCoinsAgencyCommission(java.math.BigDecimal coinsAgencyCommission) {
        this.coinsAgencyCommission = coinsAgencyCommission;
    }
    
    /**
     * 获取属性共保代理佣金的值
     */ 
    public java.math.BigDecimal getCoinsAgencyCommission() {
        return this.coinsAgencyCommission;
    }
    
    /**
     * 设置属性共保出单费比例的值
     */ 
    public void setCoinsIssueRate(java.math.BigDecimal coinsIssueRate) {
        this.coinsIssueRate = coinsIssueRate;
    }
    
    /**
     * 获取属性共保出单费比例的值
     */ 
    public java.math.BigDecimal getCoinsIssueRate() {
        return this.coinsIssueRate;
    }
    
    /**
     * 设置属性共保出单费的值
     */ 
    public void setCoinsIssueExpense(java.math.BigDecimal coinsIssueExpense) {
        this.coinsIssueExpense = coinsIssueExpense;
    }
    
    /**
     * 获取属性共保出单费的值
     */ 
    public java.math.BigDecimal getCoinsIssueExpense() {
        return this.coinsIssueExpense;
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
     * 设置属性标志字段的值
     */ 
    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }
    
    /**
     * 获取属性标志字段的值
     */ 
    public java.lang.String getFlag() {
        return this.flag;
    }
    
    /**
     * 设置属性1 从客户处收取/2 从主方处收取；的值
     */ 
    public void setCoinsPremiumAcceptInd(java.lang.String coinsPremiumAcceptInd) {
        this.coinsPremiumAcceptInd = coinsPremiumAcceptInd;
    }
    
    /**
     * 获取属性1 从客户处收取/2 从主方处收取；的值
     */ 
    public java.lang.String getCoinsPremiumAcceptInd() {
        return this.coinsPremiumAcceptInd;
    }
    
    /**
     * 设置属性共保保费组成,： 第一位 净手续费； 第二位 净代理佣金； 第三位 净出单费； 第四位 净政府徴费； 第五位 净賠償儲備金； 第六位 净其他费用； 其中，0 否/1 是；'的值
     */ 
    public void setCoinsPremiumCompose(java.lang.String coinsPremiumCompose) {
        this.coinsPremiumCompose = coinsPremiumCompose;
    }
    
    /**
     * 获取属性共保保费组成,： 第一位 净手续费； 第二位 净代理佣金； 第三位 净出单费； 第四位 净政府徴费； 第五位 净賠償儲備金； 第六位 净其他费用； 其中，0 否/1 是；'的值
     */ 
    public java.lang.String getCoinsPremiumCompose() {
        return this.coinsPremiumCompose;
    }
    
    /**
     * 设置属性0 付给代理/1 -付给主方的值
     */ 
    public void setCoinsAgencyPayInd(java.lang.String coinsAgencyPayInd) {
        this.coinsAgencyPayInd = coinsAgencyPayInd;
    }
    
    /**
     * 获取属性0 付给代理/1 -付给主方的值
     */ 
    public java.lang.String getCoinsAgencyPayInd() {
        return this.coinsAgencyPayInd;
    }
    
    /**
     * 设置属性0 由主方征收/1 从方自己征收的值
     */ 
    public void setCoinsLevyAcceptInd(java.lang.String coinsLevyAcceptInd) {
        this.coinsLevyAcceptInd = coinsLevyAcceptInd;
    }
    
    /**
     * 获取属性0 由主方征收/1 从方自己征收的值
     */ 
    public java.lang.String getCoinsLevyAcceptInd() {
        return this.coinsLevyAcceptInd;
    }
    
    /**
     * 设置属性共保其它费用比例的值
     */ 
    public void setCoinsOthFeeRate(java.math.BigDecimal coinsOthFeeRate) {
        this.coinsOthFeeRate = coinsOthFeeRate;
    }
    
    /**
     * 获取属性共保其它费用比例的值
     */ 
    public java.math.BigDecimal getCoinsOthFeeRate() {
        return this.coinsOthFeeRate;
    }
    
    /**
     * 设置属性共保其它费用的值
     */ 
    public void setCoinsOthFee(java.math.BigDecimal coinsOthFee) {
        this.coinsOthFee = coinsOthFee;
    }
    
    /**
     * 获取属性共保其它费用的值
     */ 
    public java.math.BigDecimal getCoinsOthFee() {
        return this.coinsOthFee;
    }
    
    /**
     * 设置属性0 从客户处收取/1 从主户处收取的值
     */ 
    public void setCoinsOthfeeAcceptInd(java.lang.String coinsOthfeeAcceptInd) {
        this.coinsOthfeeAcceptInd = coinsOthfeeAcceptInd;
    }
    
    /**
     * 获取属性0 从客户处收取/1 从主户处收取的值
     */ 
    public java.lang.String getCoinsOthfeeAcceptInd() {
        return this.coinsOthfeeAcceptInd;
    }
    
    /**
     * 设置属性共保赔偿储备金比例的值
     */ 
    public void setCoinsCompReserveRate(java.math.BigDecimal coinsCompReserveRate) {
        this.coinsCompReserveRate = coinsCompReserveRate;
    }
    
    /**
     * 获取属性共保赔偿储备金比例的值
     */ 
    public java.math.BigDecimal getCoinsCompReserveRate() {
        return this.coinsCompReserveRate;
    }
    
    /**
     * 设置属性共保赔偿储备金的值
     */ 
    public void setCoinsCompReserve(java.math.BigDecimal coinsCompReserve) {
        this.coinsCompReserve = coinsCompReserve;
    }
    
    /**
     * 获取属性共保赔偿储备金的值
     */ 
    public java.math.BigDecimal getCoinsCompReserve() {
        return this.coinsCompReserve;
    }
    
    /**
     * 设置属性0 由主方征收/1 从方自己征收的值
     */ 
    public void setCoinsCompResAcceptInd(java.lang.String coinsCompResAcceptInd) {
        this.coinsCompResAcceptInd = coinsCompResAcceptInd;
    }
    
    /**
     * 获取属性0 由主方征收/1 从方自己征收的值
     */ 
    public java.lang.String getCoinsCompResAcceptInd() {
        return this.coinsCompResAcceptInd;
    }
    
    /**
     * 设置属性帐单接受人的值
     */ 
    public void setDebitAccepter(java.lang.String debitAccepter) {
        this.debitAccepter = debitAccepter;
    }
    
    /**
     * 获取属性帐单接受人的值
     */ 
    public java.lang.String getDebitAccepter() {
        return this.debitAccepter;
    }
    
    /**
     * 设置属性0：我方代支付；1：按比例支付的值
     */ 
    public void setCoinsClaimInd(java.lang.String coinsClaimInd) {
        this.coinsClaimInd = coinsClaimInd;
    }
    
    /**
     * 获取属性0：我方代支付；1：按比例支付的值
     */ 
    public java.lang.String getCoinsClaimInd() {
        return this.coinsClaimInd;
    }
    
    /**
     * 设置属性是否有效:0正常,1作废值的值
     */ 
    public void setInvalidFlag(java.lang.Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性是否有效:0正常,1作废值的值
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