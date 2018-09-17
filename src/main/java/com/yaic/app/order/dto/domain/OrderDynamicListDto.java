/*
 * Created By lujicong (2016-05-20 10:39:02)
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

@Table(name = "t_order_dynamic_list")
public class OrderDynamicListDto implements Serializable {
    
    private static final long serialVersionUID = OrderDynamicListDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** dynamicListId */ 
    @Id
    private java.lang.Integer dynamicListId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 动态标的类型（用于翻译） */ 
    private java.lang.String dynamicType;
    
    /** 计划代码 */ 
    private java.lang.String planCode;
    
    /** 险种代码 */ 
    private java.lang.String riskCode;
    
    /** 定额类型 */ 
    private java.lang.String rationType;
    
    /** 清单类型 */ 
    private java.lang.String dynamicListType;
    
    @Transient
    /**0标的,1标的物**/
    private java.lang.String flag;
    
    /** 标的代码 */ 
    private java.lang.String itemCode;
    
    /** 标的序号 */ 
    private java.lang.Integer itemNo;
    
    /** 清单序号 */ 
    private java.lang.Integer listSeqNo;
    
    /** fieldAa */ 
    private java.lang.String fieldAA;
    
    /** fieldAb */ 
    private java.lang.String fieldAB;
    
    /** fieldAc */ 
    private java.lang.String fieldAC;
    
    /** fieldAd */ 
    private java.lang.String fieldAD;
    
    /** fieldAe */ 
    private java.lang.String fieldAE;
    
    /** fieldAf */ 
    private java.lang.String fieldAF;
    
    /** fieldAg */ 
    private java.lang.String fieldAG;
    
    /** fieldAh */ 
    private java.lang.String fieldAH;
    
    /** fieldAi */ 
    private java.lang.String fieldAI;
    
    /** fieldAj */ 
    private java.lang.String fieldAJ;
    
    /** fieldAk */ 
    private java.lang.String fieldAK;
    
    /** fieldAl */ 
    private java.lang.String fieldAL;
    
    /** fieldAm */ 
    private java.lang.String fieldAM;
    
    /** fieldAn */ 
    private java.lang.String fieldAN;
    
    /** fieldAo */ 
    private java.lang.String fieldAO;
    
    /** fieldAp */ 
    private java.lang.String fieldAP;
    
    /** fieldAq */ 
    private java.lang.String fieldAQ;
    
    /** fieldAr */ 
    private java.lang.String fieldAR;
    
    /** fieldAs */ 
    private java.lang.String fieldAS;
    
    /** fieldAt */ 
    private java.lang.String fieldAT;
    
    /** fieldAu */ 
    private java.lang.String fieldAU;
    
    /** fieldAv */ 
    private java.lang.String fieldAV;
    
    /** fieldAw */ 
    private java.lang.String fieldAW;
    
    /** fieldAx */ 
    private java.lang.String fieldAX;
    
    /** fieldAy */ 
    private java.lang.String fieldAY;
    
    /** fieldAz */ 
    private java.lang.String fieldAZ;
    
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
    
    
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    /**
     * 设置属性dynamicListId的值
     */ 
    public void setDynamicListId(java.lang.Integer dynamicListId) {
        this.dynamicListId = dynamicListId;
    }
    
    /**
     * 获取属性dynamicListId的值
     */ 
    public java.lang.Integer getDynamicListId() {
        return this.dynamicListId;
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
     * 设置属性动态标的类型（用于翻译）的值
     */ 
    public void setDynamicType(java.lang.String dynamicType) {
        this.dynamicType = dynamicType;
    }

    /**
     * 获取属性动态标的类型（用于翻译）的值
     */ 
    public java.lang.String getDynamicType() {
        return dynamicType;
    }
    
    /**
     * 设置属性计划代码的值
     */ 
    public void setPlanCode(java.lang.String planCode) {
        this.planCode = planCode;
    }
    
    /**
     * 获取属性计划代码的值
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
     * 设置属性定额类型的值
     */ 
    public void setRationType(java.lang.String rationType) {
        this.rationType = rationType;
    }
    
    /**
     * 获取属性定额类型的值
     */ 
    public java.lang.String getRationType() {
        return this.rationType;
    }
    
    /**
     * 设置属性清单类型的值
     */ 
    public void setDynamicListType(java.lang.String dynamicListType) {
        this.dynamicListType = dynamicListType;
    }
    
    /**
     * 获取属性清单类型的值
     */ 
    public java.lang.String getDynamicListType() {
        return this.dynamicListType;
    }
    
    /**
     * 设置属性标的代码的值
     */ 
    public void setItemCode(java.lang.String itemCode) {
        this.itemCode = itemCode;
    }
    
    /**
     * 获取属性标的代码的值
     */ 
    public java.lang.String getItemCode() {
        return this.itemCode;
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
     * 设置属性清单序号的值
     */ 
    public void setListSeqNo(java.lang.Integer listSeqNo) {
        this.listSeqNo = listSeqNo;
    }
    
    /**
     * 获取属性清单序号的值
     */ 
    public java.lang.Integer getListSeqNo() {
        return this.listSeqNo;
    }
    
    public java.lang.String getFieldAA() {
        return fieldAA;
    }

    public void setFieldAA(java.lang.String fieldAA) {
        this.fieldAA = fieldAA;
    }

    public java.lang.String getFieldAB() {
        return fieldAB;
    }

    public void setFieldAB(java.lang.String fieldAB) {
        this.fieldAB = fieldAB;
    }

    public java.lang.String getFieldAC() {
        return fieldAC;
    }

    public void setFieldAC(java.lang.String fieldAC) {
        this.fieldAC = fieldAC;
    }

    public java.lang.String getFieldAD() {
        return fieldAD;
    }

    public void setFieldAD(java.lang.String fieldAD) {
        this.fieldAD = fieldAD;
    }

    public java.lang.String getFieldAE() {
        return fieldAE;
    }

    public void setFieldAE(java.lang.String fieldAE) {
        this.fieldAE = fieldAE;
    }

    public java.lang.String getFieldAF() {
        return fieldAF;
    }

    public void setFieldAF(java.lang.String fieldAF) {
        this.fieldAF = fieldAF;
    }

    public java.lang.String getFieldAG() {
        return fieldAG;
    }

    public void setFieldAG(java.lang.String fieldAG) {
        this.fieldAG = fieldAG;
    }

    public java.lang.String getFieldAH() {
        return fieldAH;
    }

    public void setFieldAH(java.lang.String fieldAH) {
        this.fieldAH = fieldAH;
    }

    public java.lang.String getFieldAI() {
        return fieldAI;
    }

    public void setFieldAI(java.lang.String fieldAI) {
        this.fieldAI = fieldAI;
    }

    public java.lang.String getFieldAJ() {
        return fieldAJ;
    }

    public void setFieldAJ(java.lang.String fieldAJ) {
        this.fieldAJ = fieldAJ;
    }

    public java.lang.String getFieldAK() {
        return fieldAK;
    }

    public void setFieldAK(java.lang.String fieldAK) {
        this.fieldAK = fieldAK;
    }

    public java.lang.String getFieldAL() {
        return fieldAL;
    }

    public void setFieldAL(java.lang.String fieldAL) {
        this.fieldAL = fieldAL;
    }

    public java.lang.String getFieldAM() {
        return fieldAM;
    }

    public void setFieldAM(java.lang.String fieldAM) {
        this.fieldAM = fieldAM;
    }

    public java.lang.String getFieldAN() {
        return fieldAN;
    }

    public void setFieldAN(java.lang.String fieldAN) {
        this.fieldAN = fieldAN;
    }

    public java.lang.String getFieldAO() {
        return fieldAO;
    }

    public void setFieldAO(java.lang.String fieldAO) {
        this.fieldAO = fieldAO;
    }

    public java.lang.String getFieldAP() {
        return fieldAP;
    }

    public void setFieldAP(java.lang.String fieldAP) {
        this.fieldAP = fieldAP;
    }

    public java.lang.String getFieldAQ() {
        return fieldAQ;
    }

    public void setFieldAQ(java.lang.String fieldAQ) {
        this.fieldAQ = fieldAQ;
    }

    public java.lang.String getFieldAR() {
        return fieldAR;
    }

    public void setFieldAR(java.lang.String fieldAR) {
        this.fieldAR = fieldAR;
    }

    public java.lang.String getFieldAS() {
        return fieldAS;
    }

    public void setFieldAS(java.lang.String fieldAS) {
        this.fieldAS = fieldAS;
    }

    public java.lang.String getFieldAT() {
        return fieldAT;
    }

    public void setFieldAT(java.lang.String fieldAT) {
        this.fieldAT = fieldAT;
    }

    public java.lang.String getFieldAU() {
        return fieldAU;
    }

    public void setFieldAU(java.lang.String fieldAU) {
        this.fieldAU = fieldAU;
    }

    public java.lang.String getFieldAV() {
        return fieldAV;
    }

    public void setFieldAV(java.lang.String fieldAV) {
        this.fieldAV = fieldAV;
    }

    public java.lang.String getFieldAW() {
        return fieldAW;
    }

    public void setFieldAW(java.lang.String fieldAW) {
        this.fieldAW = fieldAW;
    }

    public java.lang.String getFieldAX() {
        return fieldAX;
    }

    public void setFieldAX(java.lang.String fieldAX) {
        this.fieldAX = fieldAX;
    }

    public java.lang.String getFieldAY() {
        return fieldAY;
    }

    public void setFieldAY(java.lang.String fieldAY) {
        this.fieldAY = fieldAY;
    }

    public java.lang.String getFieldAZ() {
        return fieldAZ;
    }

    public void setFieldAZ(java.lang.String fieldAZ) {
        this.fieldAZ = fieldAZ;
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
    
    /**0标的,1标的物**/
	public java.lang.String getFlag() {
		return flag;
	}
	
	 /**0标的,1标的物**/
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
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