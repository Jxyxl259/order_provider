/*
 * Created By lujicong (2016-05-24 22:08:06)
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

@Table(name = "t_order_risk_dynamic")
public class OrderRiskDynamicDto implements Serializable {
    
    private static final long serialVersionUID = OrderRiskDynamicDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	
    /** 主键ID */ 
    @Id
    private java.lang.Integer riskDynamicId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 团队保额 */ 
    private java.math.BigDecimal aoka;
    
    /** 个人保额 */ 
    private java.math.BigDecimal aop;
    
    /** 记名标志 0:不记名；1：记名 */ 
    private java.lang.String nominativeInd;
    
    /** 0:不导入;1:导入 */ 
    private java.lang.String uploadInd;
    
    /** 0:未导入;1:已导入 */ 
    private java.lang.String uploadStatusInd;
    
    /** 0:不分类;1:分类 */ 
    private java.lang.String sortInd;
    
    /** 保费计算方法 */ 
    private java.lang.String calculateType;
    
    /** 工程名称 */ 
    private java.lang.String contractTitle;
    
    /** 工程合约地点 */ 
    private java.lang.String contractAddress;
    
    /** 工程类别 */ 
    private java.lang.String contractType;
    
    /** 工程合约价值 */ 
    private java.math.BigDecimal contractValue;
    
    /** 工程建筑面积 */ 
    private java.math.BigDecimal contractArea;
    
    /** 备注 */ 
    private java.lang.String remark;
    
    /** 标识 */ 
    private java.lang.String flag;
    
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
    
	/** 险种代码 */
	private String riskCode;
    
    /**
     * 设置属性主键ID的值
     */ 
    public void setRiskDynamicId(java.lang.Integer riskDynamicId) {
        this.riskDynamicId = riskDynamicId;
    }
    
    /**
     * 获取属性主键ID的值
     */ 
    public java.lang.Integer getRiskDynamicId() {
        return this.riskDynamicId;
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
     * 设置属性团队保额的值
     */ 
    public void setAoka(java.math.BigDecimal aoka) {
        this.aoka = aoka;
    }
    
    /**
     * 获取属性团队保额的值
     */ 
    public java.math.BigDecimal getAoka() {
        return this.aoka;
    }
    
    /**
     * 设置属性个人保额的值
     */ 
    public void setAop(java.math.BigDecimal aop) {
        this.aop = aop;
    }
    
    /**
     * 获取属性个人保额的值
     */ 
    public java.math.BigDecimal getAop() {
        return this.aop;
    }
    
    /**
     * 设置属性记名标志 0:不记名；1：记名的值
     */ 
    public void setNominativeInd(java.lang.String nominativeInd) {
        this.nominativeInd = nominativeInd;
    }
    
    /**
     * 获取属性记名标志 0:不记名；1：记名的值
     */ 
    public java.lang.String getNominativeInd() {
        return this.nominativeInd;
    }
    
    /**
     * 设置属性0:不导入;1:导入的值
     */ 
    public void setUploadInd(java.lang.String uploadInd) {
        this.uploadInd = uploadInd;
    }
    
    /**
     * 获取属性0:不导入;1:导入的值
     */ 
    public java.lang.String getUploadInd() {
        return this.uploadInd;
    }
    
    /**
     * 设置属性0:未导入;1:已导入的值
     */ 
    public void setUploadStatusInd(java.lang.String uploadStatusInd) {
        this.uploadStatusInd = uploadStatusInd;
    }
    
    /**
     * 获取属性0:未导入;1:已导入的值
     */ 
    public java.lang.String getUploadStatusInd() {
        return this.uploadStatusInd;
    }
    
    /**
     * 设置属性0:不分类;1:分类的值
     */ 
    public void setSortInd(java.lang.String sortInd) {
        this.sortInd = sortInd;
    }
    
    /**
     * 获取属性0:不分类;1:分类的值
     */ 
    public java.lang.String getSortInd() {
        return this.sortInd;
    }
    
    /**
     * 设置属性保费计算方法的值
     */ 
    public void setCalculateType(java.lang.String calculateType) {
        this.calculateType = calculateType;
    }
    
    /**
     * 获取属性保费计算方法的值
     */ 
    public java.lang.String getCalculateType() {
        return this.calculateType;
    }
    
    /**
     * 设置属性工程名称的值
     */ 
    public void setContractTitle(java.lang.String contractTitle) {
        this.contractTitle = contractTitle;
    }
    
    /**
     * 获取属性工程名称的值
     */ 
    public java.lang.String getContractTitle() {
        return this.contractTitle;
    }
    
    /**
     * 设置属性工程合约地点的值
     */ 
    public void setContractAddress(java.lang.String contractAddress) {
        this.contractAddress = contractAddress;
    }
    
    /**
     * 获取属性工程合约地点的值
     */ 
    public java.lang.String getContractAddress() {
        return this.contractAddress;
    }
    
    /**
     * 设置属性工程类别的值
     */ 
    public void setContractType(java.lang.String contractType) {
        this.contractType = contractType;
    }
    
    /**
     * 获取属性工程类别的值
     */ 
    public java.lang.String getContractType() {
        return this.contractType;
    }
    
    /**
     * 设置属性工程合约价值的值
     */ 
    public void setContractValue(java.math.BigDecimal contractValue) {
        this.contractValue = contractValue;
    }
    
    /**
     * 获取属性工程合约价值的值
     */ 
    public java.math.BigDecimal getContractValue() {
        return this.contractValue;
    }
    
    /**
     * 设置属性工程建筑面积的值
     */ 
    public void setContractArea(java.math.BigDecimal contractArea) {
        this.contractArea = contractArea;
    }
    
    /**
     * 获取属性工程建筑面积的值
     */ 
    public java.math.BigDecimal getContractArea() {
        return this.contractArea;
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
     * 设置属性标识的值
     */ 
    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }
    
    /**
     * 获取属性标识的值
     */ 
    public java.lang.String getFlag() {
        return this.flag;
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
    
    /**
     * 获取属性险种代码的值
     */ 
    public String getRiskCode() {
		return riskCode;
	}

    /**
     * 设置属性险种代码的值
     */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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