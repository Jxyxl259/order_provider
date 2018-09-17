/*
 * Created By lujicong (2016-05-31 09:59:10)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2016
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "v_order_dynamic")
public class VorderDynamicDto implements Serializable {
    
    private static final long serialVersionUID = VorderDynamicDto.class.getName().hashCode();
    
    /** dynamicItemId */ 
    private java.lang.Integer dynamicItemId;
    
    /** orderId */ 
    private BigInteger orderMainId;
    
    /** riskCode */ 
    private java.lang.String riskCode;
    
    /** rationType */ 
    private java.lang.String rationType;
    
    /** fieldAa */ 
    private java.lang.String fieldAa;
    
    /** fieldAb */ 
    private java.lang.String fieldAb;
    
    /** fieldAc */ 
    private java.lang.String fieldAc;
    
    /** fieldAd */ 
    private java.lang.String fieldAd;
    
    /** fieldAe */ 
    private java.lang.String fieldAe;
    
    /** fieldAf */ 
    private java.lang.String fieldAf;
    
    /** fieldAg */ 
    private java.lang.String fieldAg;
    
    /** fieldAh */ 
    private java.lang.String fieldAh;
    
    /** fieldAi */ 
    private java.lang.String fieldAi;
    
    /** fieldAj */ 
    private java.lang.String fieldAj;
    
    /** fieldAk */ 
    private java.lang.String fieldAk;
    
    /** fieldAl */ 
    private java.lang.String fieldAl;
    
    /** fieldAm */ 
    private java.lang.String fieldAm;
    
    /** fieldAn */ 
    private java.lang.String fieldAn;
    
    /** fieldAo */ 
    private java.lang.String fieldAo;
    
    /** fieldAp */ 
    private java.lang.String fieldAp;
    
    /** fieldAq */ 
    private java.lang.String fieldAq;
    
    /** fieldAr */ 
    private java.lang.String fieldAr;
    
    /** fieldAs */ 
    private java.lang.String fieldAs;
    
    /** fieldAt */ 
    private java.lang.String fieldAt;
    
    /** fieldAu */ 
    private java.lang.String fieldAu;
    
    /** fieldAv */ 
    private java.lang.String fieldAv;
    
    /** fieldAw */ 
    private java.lang.String fieldAw;
    
    /** fieldAx */ 
    private java.lang.String fieldAx;
    
    /** fieldAy */ 
    private java.lang.String fieldAy;
    
    /** fieldAz */ 
    private java.lang.String fieldAz;
    
    /** torderMain00 */ 
    private java.lang.String torderMain00;
    
    /** invalidFlag */ 
    private java.lang.Integer invalidFlag;
    
    /** createdUser */ 
    private java.lang.String createdUser;
    
    /** createdDate */ 
    private java.util.Date createdDate;
    
    /** updatedUser */ 
    private java.lang.String updatedUser;
    
    /** updatedDate */ 
    private java.util.Date updatedDate;
    
    /** 保单号 */ 
    private java.lang.String policyNo;
    
    /** 订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中 ，8-批改失败*/ 
    private java.lang.String status;
    
    /**
     * 设置属性dynamicItemId的值
     */ 
    public void setDynamicItemId(java.lang.Integer dynamicItemId) {
        this.dynamicItemId = dynamicItemId;
    }
    
    /**
     * 获取属性dynamicItemId的值
     */ 
    public java.lang.Integer getDynamicItemId() {
        return this.dynamicItemId;
    }
    
    
    public BigInteger getOrderMainId() {
        return orderMainId;
    }

    public void setOrderMainId(BigInteger orderMainId) {
        this.orderMainId = orderMainId;
    }

    /**
     * 设置属性riskCode的值
     */ 
    public void setRiskCode(java.lang.String riskCode) {
        this.riskCode = riskCode;
    }
    
    /**
     * 获取属性riskCode的值
     */ 
    public java.lang.String getRiskCode() {
        return this.riskCode;
    }
    
    /**
     * 设置属性rationType的值
     */ 
    public void setRationType(java.lang.String rationType) {
        this.rationType = rationType;
    }
    
    /**
     * 获取属性rationType的值
     */ 
    public java.lang.String getRationType() {
        return this.rationType;
    }
    
    /**
     * 设置属性fieldAa的值
     */ 
    public void setFieldAa(java.lang.String fieldAa) {
        this.fieldAa = fieldAa;
    }
    
    /**
     * 获取属性fieldAa的值
     */ 
    public java.lang.String getFieldAa() {
        return this.fieldAa;
    }
    
    /**
     * 设置属性fieldAb的值
     */ 
    public void setFieldAb(java.lang.String fieldAb) {
        this.fieldAb = fieldAb;
    }
    
    /**
     * 获取属性fieldAb的值
     */ 
    public java.lang.String getFieldAb() {
        return this.fieldAb;
    }
    
    /**
     * 设置属性fieldAc的值
     */ 
    public void setFieldAc(java.lang.String fieldAc) {
        this.fieldAc = fieldAc;
    }
    
    /**
     * 获取属性fieldAc的值
     */ 
    public java.lang.String getFieldAc() {
        return this.fieldAc;
    }
    
    /**
     * 设置属性fieldAd的值
     */ 
    public void setFieldAd(java.lang.String fieldAd) {
        this.fieldAd = fieldAd;
    }
    
    /**
     * 获取属性fieldAd的值
     */ 
    public java.lang.String getFieldAd() {
        return this.fieldAd;
    }
    
    /**
     * 设置属性fieldAe的值
     */ 
    public void setFieldAe(java.lang.String fieldAe) {
        this.fieldAe = fieldAe;
    }
    
    /**
     * 获取属性fieldAe的值
     */ 
    public java.lang.String getFieldAe() {
        return this.fieldAe;
    }
    
    /**
     * 设置属性fieldAf的值
     */ 
    public void setFieldAf(java.lang.String fieldAf) {
        this.fieldAf = fieldAf;
    }
    
    /**
     * 获取属性fieldAf的值
     */ 
    public java.lang.String getFieldAf() {
        return this.fieldAf;
    }
    
    /**
     * 设置属性fieldAg的值
     */ 
    public void setFieldAg(java.lang.String fieldAg) {
        this.fieldAg = fieldAg;
    }
    
    /**
     * 获取属性fieldAg的值
     */ 
    public java.lang.String getFieldAg() {
        return this.fieldAg;
    }
    
    /**
     * 设置属性fieldAh的值
     */ 
    public void setFieldAh(java.lang.String fieldAh) {
        this.fieldAh = fieldAh;
    }
    
    /**
     * 获取属性fieldAh的值
     */ 
    public java.lang.String getFieldAh() {
        return this.fieldAh;
    }
    
    /**
     * 设置属性fieldAi的值
     */ 
    public void setFieldAi(java.lang.String fieldAi) {
        this.fieldAi = fieldAi;
    }
    
    /**
     * 获取属性fieldAi的值
     */ 
    public java.lang.String getFieldAi() {
        return this.fieldAi;
    }
    
    /**
     * 设置属性fieldAj的值
     */ 
    public void setFieldAj(java.lang.String fieldAj) {
        this.fieldAj = fieldAj;
    }
    
    /**
     * 获取属性fieldAj的值
     */ 
    public java.lang.String getFieldAj() {
        return this.fieldAj;
    }
    
    /**
     * 设置属性fieldAk的值
     */ 
    public void setFieldAk(java.lang.String fieldAk) {
        this.fieldAk = fieldAk;
    }
    
    /**
     * 获取属性fieldAk的值
     */ 
    public java.lang.String getFieldAk() {
        return this.fieldAk;
    }
    
    /**
     * 设置属性fieldAl的值
     */ 
    public void setFieldAl(java.lang.String fieldAl) {
        this.fieldAl = fieldAl;
    }
    
    /**
     * 获取属性fieldAl的值
     */ 
    public java.lang.String getFieldAl() {
        return this.fieldAl;
    }
    
    /**
     * 设置属性fieldAm的值
     */ 
    public void setFieldAm(java.lang.String fieldAm) {
        this.fieldAm = fieldAm;
    }
    
    /**
     * 获取属性fieldAm的值
     */ 
    public java.lang.String getFieldAm() {
        return this.fieldAm;
    }
    
    /**
     * 设置属性fieldAn的值
     */ 
    public void setFieldAn(java.lang.String fieldAn) {
        this.fieldAn = fieldAn;
    }
    
    /**
     * 获取属性fieldAn的值
     */ 
    public java.lang.String getFieldAn() {
        return this.fieldAn;
    }
    
    /**
     * 设置属性fieldAo的值
     */ 
    public void setFieldAo(java.lang.String fieldAo) {
        this.fieldAo = fieldAo;
    }
    
    /**
     * 获取属性fieldAo的值
     */ 
    public java.lang.String getFieldAo() {
        return this.fieldAo;
    }
    
    /**
     * 设置属性fieldAp的值
     */ 
    public void setFieldAp(java.lang.String fieldAp) {
        this.fieldAp = fieldAp;
    }
    
    /**
     * 获取属性fieldAp的值
     */ 
    public java.lang.String getFieldAp() {
        return this.fieldAp;
    }
    
    /**
     * 设置属性fieldAq的值
     */ 
    public void setFieldAq(java.lang.String fieldAq) {
        this.fieldAq = fieldAq;
    }
    
    /**
     * 获取属性fieldAq的值
     */ 
    public java.lang.String getFieldAq() {
        return this.fieldAq;
    }
    
    /**
     * 设置属性fieldAr的值
     */ 
    public void setFieldAr(java.lang.String fieldAr) {
        this.fieldAr = fieldAr;
    }
    
    /**
     * 获取属性fieldAr的值
     */ 
    public java.lang.String getFieldAr() {
        return this.fieldAr;
    }
    
    /**
     * 设置属性fieldAs的值
     */ 
    public void setFieldAs(java.lang.String fieldAs) {
        this.fieldAs = fieldAs;
    }
    
    /**
     * 获取属性fieldAs的值
     */ 
    public java.lang.String getFieldAs() {
        return this.fieldAs;
    }
    
    /**
     * 设置属性fieldAt的值
     */ 
    public void setFieldAt(java.lang.String fieldAt) {
        this.fieldAt = fieldAt;
    }
    
    /**
     * 获取属性fieldAt的值
     */ 
    public java.lang.String getFieldAt() {
        return this.fieldAt;
    }
    
    /**
     * 设置属性fieldAu的值
     */ 
    public void setFieldAu(java.lang.String fieldAu) {
        this.fieldAu = fieldAu;
    }
    
    /**
     * 获取属性fieldAu的值
     */ 
    public java.lang.String getFieldAu() {
        return this.fieldAu;
    }
    
    /**
     * 设置属性fieldAv的值
     */ 
    public void setFieldAv(java.lang.String fieldAv) {
        this.fieldAv = fieldAv;
    }
    
    /**
     * 获取属性fieldAv的值
     */ 
    public java.lang.String getFieldAv() {
        return this.fieldAv;
    }
    
    /**
     * 设置属性fieldAw的值
     */ 
    public void setFieldAw(java.lang.String fieldAw) {
        this.fieldAw = fieldAw;
    }
    
    /**
     * 获取属性fieldAw的值
     */ 
    public java.lang.String getFieldAw() {
        return this.fieldAw;
    }
    
    /**
     * 设置属性fieldAx的值
     */ 
    public void setFieldAx(java.lang.String fieldAx) {
        this.fieldAx = fieldAx;
    }
    
    /**
     * 获取属性fieldAx的值
     */ 
    public java.lang.String getFieldAx() {
        return this.fieldAx;
    }
    
    /**
     * 设置属性fieldAy的值
     */ 
    public void setFieldAy(java.lang.String fieldAy) {
        this.fieldAy = fieldAy;
    }
    
    /**
     * 获取属性fieldAy的值
     */ 
    public java.lang.String getFieldAy() {
        return this.fieldAy;
    }
    
    /**
     * 设置属性fieldAz的值
     */ 
    public void setFieldAz(java.lang.String fieldAz) {
        this.fieldAz = fieldAz;
    }
    
    /**
     * 获取属性fieldAz的值
     */ 
    public java.lang.String getFieldAz() {
        return this.fieldAz;
    }
    
    /**
     * 设置属性torderMain00的值
     */ 
    public void setTorderMain00(java.lang.String torderMain00) {
        this.torderMain00 = torderMain00;
    }
    
    /**
     * 获取属性torderMain00的值
     */ 
    public java.lang.String getTorderMain00() {
        return this.torderMain00;
    }
    
    /**
     * 设置属性invalidFlag的值
     */ 
    public void setInvalidFlag(java.lang.Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性invalidFlag的值
     */ 
    public java.lang.Integer getInvalidFlag() {
        return this.invalidFlag;
    }
    
    /**
     * 设置属性createdUser的值
     */ 
    public void setCreatedUser(java.lang.String createdUser) {
        this.createdUser = createdUser;
    }
    
    /**
     * 获取属性createdUser的值
     */ 
    public java.lang.String getCreatedUser() {
        return this.createdUser;
    }
    
    /**
     * 设置属性createdDate的值
     */ 
    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }
    
    /**
     * 获取属性createdDate的值
     */ 
    public java.util.Date getCreatedDate() {
        return this.createdDate;
    }
    
    /**
     * 设置属性updatedUser的值
     */ 
    public void setUpdatedUser(java.lang.String updatedUser) {
        this.updatedUser = updatedUser;
    }
    
    /**
     * 获取属性updatedUser的值
     */ 
    public java.lang.String getUpdatedUser() {
        return this.updatedUser;
    }
    
    /**
     * 设置属性updatedDate的值
     */ 
    public void setUpdatedDate(java.util.Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    /**
     * 获取属性updatedDate的值
     */ 
    public java.util.Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    /**
     * 设置属性保单号的值
     */ 
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }
    
    /**
     * 获取属性保单号的值
     */ 
    public java.lang.String getPolicyNo() {
        return this.policyNo;
    }
    
    /**
     * 设置属性订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败的值
     */ 
    public void setStatus(java.lang.String status) {
        this.status = status;
    }
    
    /**
     * 获取属性订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败的值
     */ 
    public java.lang.String getStatus() {
        return this.status;
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