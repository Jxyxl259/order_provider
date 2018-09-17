/*
 * Created By lujicong (2017-08-17 10:37:25)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.yaic.fa.dto.BaseDto;

/**
 * 业务常规校验表
 */
@Table(name = "t_pdms_check_biz")
public class PdmsCheckBizDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsCheckBizDto.class.getName().hashCode();

    /** 主键ID */
    @Id
    private Integer chkId;

    /** 规则描述 */
    private String chkDesc;
    
    /** 日期校验标志：对应t_pub_code 的 code_type=ChkDateFlag：0-不校验；1-起终保日期不为空；2-起保日期校验； */
    private String chkDateFlag;

    /** 是否即时生效：Y-是；N-否。 */
    private String dateImdFlag;

    /** 起保时间下限单位：对应t_pub_code 的 code_type=DateUnit：MIN-分钟minutes；H-小时hours；D-天数days；M-月数months；Y-年数years；T-无穷小或无穷大 （日期校验标识为1,2 此项必填） */
    private String lowerUnit;

    /** 起保时间下限(T+D T=投保日期，D=限制时间) （起保时间下限单位为MIN,H,D,M,Y此项必填） */
    private Integer lower;

    /** 起保时间上限单位：对应t_pub_code 的 code_type=DateUnit：MIN-分钟minutes；H-小时hours；D-天数days；M-月数months；Y-年数years；T-无穷小或无穷大 （日期校验标识为1,2 此项必填） */
    private String upperUnit;

    /** 起保时间上限(T+D T=投保日期，D=限制时间) （起保时间上限单位为MIN,H,D,M,Y此项必填） */
    private Integer upper;

    /** 指定起保日期差标识：对应t_pub_code 的 code_type=DateUnit：H-小时hours；D-天数days；M-月数months；Y-年数years (当日期校验标识为0，如果须指定起保日期为何时，则此字段为必填；如果此字段不配置则默认起保日期为次日凌晨) */
    private String customUnit;

    /** 指定起保日期差单位[T+D T=当前时间，D=时间差] */
    private Integer customDate;

    /** 起终保日期差标识：对应t_pub_code 的 code_type=DateUnit：H-小时hours；D-天数days；M-月数months；Y-年数years (当日期校验标识为2时，此字段为必填; 当日期校验标识为1,并且即时生效校验标识Y时，此字段作为起终保日期差校验值；当日期校验标识0时，如果指定起终保日期时间差则配置值，为空则默认终保日期为一年期) */
    private String dateUnit;

    /** 起终保日期差单位[T+D T=起保日期，D=时间差] */
    private Integer dateValue;

    /** 保费校验标识：对应t_pub_code 的 code_type=PremiumFlag：0-不校验；1-不为空校验(公共方法校验)；2-不为空校验(意健险校验) */
    private String premiumFlag;

    /** 短期费率表查询标识：对应t_pub_code 的 code_type=ProRateFlag：0-不查询；1-被保人统一费率查询；2-被保人不统一费率查询 */
    private String proRateFlag;

    /** 保费校验值:（保费校验标识为1,2，并且短期费率表查询标识为0，此字段必填） */
    private java.math.BigDecimal premium;

    /** 投保人类型否：对应t_pub_code 的 code_type=InsuredType： 1-个人或2-企业（可多选） */
    private String appliType;

    /** 投保人证件类型：对应t_pub_code的 code_type=InsuredIdentity (可多选) */
    private String appliDocType;
    
    /** 企业证件类型 */
    private String enterpriseDocType;
    
    /** 投保人年龄校验标识：对应t_pub_code 的 code_type=AgeFlag：0-不校验；1-校验天数到年份；2-校验年份到年份；3-天数到无穷大；4-年份到无穷大 */
    private String appliAgeFlag;

    /** 投保人年龄下限 （投保人年龄校验标识1,2,3,4此字段必填） */
    private Integer appliAgeLower;

    /** 投保人年龄上限(最大年龄+1) （投保人年龄校验标识1,2此字段必填） */
    private Integer appliAgeUpper;

    /** 被保险人类型:：对应t_pub_code 的 code_type=InsuredType： 1-个人或2-企业（可多选） */
    private String insuredType;

    /** 被保险人证件类型：对应t_pub_code的 code_type=InsuredIdentity (可多选) */
    private String insuredDocType;

    /** 被保人年龄校验标识：对应t_pub_code 的 code_type=AgeFlag：0-不校验；1-校验天数到年份；2-校验年份到年份；3-天数到无穷大；4-年份到无穷大 */
    private String insuredAgeFlag;

    /** 被保人年龄下限 （被保人年龄校验标识1,2,3,4此字段必填） */
    private Integer insuredAgeLower;

    /** 被保人年龄上限(最大年龄+1) （被保人年龄校验标识1,2此字段必填） */
    private Integer insuredAgeUpper;

    /** 被保人人数校验标识：对应t_pub_code 的 code_type=QuantityFlag：0-不校验；1-校验少到多；2-校验到最少；3-校验到最多；4-固定人数 （意健险产品必填） */
    private String quantityFlag;

    /** 最少被保人人数（被保人人数校验标识1,2,4必填） */
    private Integer quantityMin;

    /** 最多被保人人数 （被保人人数校验标识1,3必填） */
    private Integer quantityMax;

    /** 被保险人关系限制编码(多选用英文”,”隔开 对应t_pub_code的 code_type=InsuredIdentity */
    private String applirelation;

    /** 职业代码(多选用英文”,”隔开)参考职业类别信息 */
    private String occupationCode;

    /** 职业等级(多选用英文”,”隔开参考职业类别信息 */
    private String occupationLevel;

    /** 是否允许生效退保标志：Y-是；N-否 */
    private String cancelFlag;

    /** 退保日期差标识：对应t_pub_code 的 code_type=DateUnit：H-小时hours；D-天数days；M-月数months；Y-年数years (当退保生效标识为Y时，此字段为null则不作退保时间控制) */
    private String cancelDateUnit;

    /** 退保日期差单位[T+D T=起保日期，D+1=时间差] */
    private Integer cancelDate;

    /** 失效标志：0-有效，1-失效 */
    private Integer invalidFlag;

    /** 创建人 */
    private String createdUser;

    /** 创建时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdDate;

    /** 更新人 */
    private String updatedUser;

    /** 更新时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedDate;
    
    /** 起保日期格式 */
    private String dateFormat;

    /** 终保日期格式 */
    private String finalDateFormat;
    

    /**
     * 获取属性主键ID的值
     */
    public Integer getChkId() {
        return this.chkId;
    }

    /**
     * 设置属性主键ID的值
     */
    public void setChkId(Integer chkId) {
        this.chkId = chkId;
    }
    
	public String getChkDesc() {
		return chkDesc;
	}

	public void setChkDesc(String chkDesc) {
		this.chkDesc = chkDesc;
	}

	/**
     * 获取属性日期校验标志：对应t_pub_code 的 code_type=ChkDateFlag：0-不校验；1-起终保日期不为空；2-起保日期校验；的值
     */
    public String getChkDateFlag() {
        return this.chkDateFlag;
    }

    /**
     * 设置属性日期校验标志：对应t_pub_code 的 code_type=ChkDateFlag：0-不校验；1-起终保日期不为空；2-起保日期校验；的值
     */
    public void setChkDateFlag(String chkDateFlag) {
        this.chkDateFlag = chkDateFlag;
    }

    /**
     * 获取属性是否即时生效：Y-是；N-否。的值
     */
    public String getDateImdFlag() {
        return this.dateImdFlag;
    }

    /**
     * 设置属性是否即时生效：Y-是；N-否。的值
     */
    public void setDateImdFlag(String dateImdFlag) {
        this.dateImdFlag = dateImdFlag;
    }

    /**
     * 获取属性起保时间下限单位：对应t_pub_code 的 code_type=DateUnit：MIN-分钟minutes；H-小时hours；D-天数days；M-月数months；Y-年数years；T-无穷小或无穷大 （日期校验标识为1,2 此项必填）的值
     */
    public String getLowerUnit() {
        return this.lowerUnit;
    }

    /**
     * 设置属性起保时间下限单位：对应t_pub_code 的 code_type=DateUnit：MIN-分钟minutes；H-小时hours；D-天数days；M-月数months；Y-年数years；T-无穷小或无穷大 （日期校验标识为1,2 此项必填）的值
     */
    public void setLowerUnit(String lowerUnit) {
        this.lowerUnit = lowerUnit;
    }

    /**
     * 获取属性起保时间下限(T+D T=投保日期，D=限制时间) （起保时间下限单位为MIN,H,D,M,Y此项必填）的值
     */
    public Integer getLower() {
        return this.lower;
    }

    /**
     * 设置属性起保时间下限(T+D T=投保日期，D=限制时间) （起保时间下限单位为MIN,H,D,M,Y此项必填）的值
     */
    public void setLower(Integer lower) {
        this.lower = lower;
    }

    /**
     * 获取属性起保时间上限单位：对应t_pub_code 的 code_type=DateUnit：MIN-分钟minutes；H-小时hours；D-天数days；M-月数months；Y-年数years；T-无穷小或无穷大 （日期校验标识为1,2 此项必填）的值
     */
    public String getUpperUnit() {
        return this.upperUnit;
    }

    /**
     * 设置属性起保时间上限单位：对应t_pub_code 的 code_type=DateUnit：MIN-分钟minutes；H-小时hours；D-天数days；M-月数months；Y-年数years；T-无穷小或无穷大 （日期校验标识为1,2 此项必填）的值
     */
    public void setUpperUnit(String upperUnit) {
        this.upperUnit = upperUnit;
    }

    /**
     * 获取属性起保时间上限(T+D T=投保日期，D=限制时间) （起保时间上限单位为MIN,H,D,M,Y此项必填）的值
     */
    public Integer getUpper() {
        return this.upper;
    }

    /**
     * 设置属性起保时间上限(T+D T=投保日期，D=限制时间) （起保时间上限单位为MIN,H,D,M,Y此项必填）的值
     */
    public void setUpper(Integer upper) {
        this.upper = upper;
    }

    /**
     * 获取属性指定起保日期差标识：对应t_pub_code 的 code_type=DateUnit：H-小时hours；D-天数days；M-月数months；Y-年数years (当日期校验标识为0，如果须指定起保日期为何时，则此字段为必填；如果此字段不配置则默认起保日期为次日凌晨)的值
     */
    public String getCustomUnit() {
        return this.customUnit;
    }

    /**
     * 设置属性指定起保日期差标识：对应t_pub_code 的 code_type=DateUnit：H-小时hours；D-天数days；M-月数months；Y-年数years (当日期校验标识为0，如果须指定起保日期为何时，则此字段为必填；如果此字段不配置则默认起保日期为次日凌晨)的值
     */
    public void setCustomUnit(String customUnit) {
        this.customUnit = customUnit;
    }

    /**
     * 获取属性指定起保日期差单位[T+D T=当前时间，D=时间差]的值
     */
    public Integer getCustomDate() {
        return this.customDate;
    }

    /**
     * 设置属性指定起保日期差单位[T+D T=当前时间，D=时间差]的值
     */
    public void setCustomDate(Integer customDate) {
        this.customDate = customDate;
    }

    /**
     * 获取属性起终保日期差标识：对应t_pub_code 的 code_type=DateUnit：H-小时hours；D-天数days；M-月数months；Y-年数years (当日期校验标识为2时，此字段为必填; 当日期校验标识为1,并且即时生效校验标识Y时，此字段作为起终保日期差校验值；当日期校验标识0时，如果指定起终保日期时间差则配置值，为空则默认终保日期为一年期)的值
     */
    public String getDateUnit() {
        return this.dateUnit;
    }

    /**
     * 设置属性起终保日期差标识：对应t_pub_code 的 code_type=DateUnit：H-小时hours；D-天数days；M-月数months；Y-年数years (当日期校验标识为2时，此字段为必填; 当日期校验标识为1,并且即时生效校验标识Y时，此字段作为起终保日期差校验值；当日期校验标识0时，如果指定起终保日期时间差则配置值，为空则默认终保日期为一年期)的值
     */
    public void setDateUnit(String dateUnit) {
        this.dateUnit = dateUnit;
    }

    /**
     * 获取属性起终保日期差单位[T+D T=起保日期，D=时间差]的值
     */
    public Integer getDateValue() {
        return this.dateValue;
    }

    /**
     * 设置属性起终保日期差单位[T+D T=起保日期，D=时间差]的值
     */
    public void setDateValue(Integer dateValue) {
        this.dateValue = dateValue;
    }

    /**
     * 获取属性保费校验标识：对应t_pub_code 的 code_type=PremiumFlag：0-不校验；1-不为空校验(公共方法校验)；2-不为空校验(意健险校验)的值
     */
    public String getPremiumFlag() {
        return this.premiumFlag;
    }

    /**
     * 设置属性保费校验标识：对应t_pub_code 的 code_type=PremiumFlag：0-不校验；1-不为空校验(公共方法校验)；2-不为空校验(意健险校验)的值
     */
    public void setPremiumFlag(String premiumFlag) {
        this.premiumFlag = premiumFlag;
    }

    /**
     * 获取属性短期费率表查询标识：对应t_pub_code 的 code_type=ProRateFlag：0-不查询；1-被保人统一费率查询；2-被保人不统一费率查询的值
     */
    public String getProRateFlag() {
        return this.proRateFlag;
    }

    /**
     * 设置属性短期费率表查询标识：对应t_pub_code 的 code_type=ProRateFlag：0-不查询；1-被保人统一费率查询；2-被保人不统一费率查询的值
     */
    public void setProRateFlag(String proRateFlag) {
        this.proRateFlag = proRateFlag;
    }

    /**
     * 获取属性保费校验值:（保费校验标识为1,2，并且短期费率表查询标识为0，此字段必填）的值
     */
    public java.math.BigDecimal getPremium() {
        return this.premium;
    }

    /**
     * 设置属性保费校验值:（保费校验标识为1,2，并且短期费率表查询标识为0，此字段必填）的值
     */
    public void setPremium(java.math.BigDecimal premium) {
        this.premium = premium;
    }

    /**
     * 获取属性投保人类型否：对应t_pub_code 的 code_type=InsuredType： 1-个人或2-企业（可多选）的值
     */
    public String getAppliType() {
        return this.appliType;
    }

    /**
     * 设置属性投保人类型否：对应t_pub_code 的 code_type=InsuredType： 1-个人或2-企业（可多选）的值
     */
    public void setAppliType(String appliType) {
        this.appliType = appliType;
    }

    /**
     * 获取属性投保人证件类型：对应t_pub_code的 code_type=InsuredIdentity (可多选)的值
     */
    public String getAppliDocType() {
        return this.appliDocType;
    }

    /**
     * 设置属性投保人证件类型：对应t_pub_code的 code_type=InsuredIdentity (可多选)的值
     */
    public void setAppliDocType(String appliDocType) {
        this.appliDocType = appliDocType;
    }

    /**
     * 获取属性投保人年龄校验标识：对应t_pub_code 的 code_type=AgeFlag：0-不校验；1-校验天数到年份；2-校验年份到年份；3-天数到无穷大；4-年份到无穷大的值
     */
    public String getAppliAgeFlag() {
        return this.appliAgeFlag;
    }

    /**
     * 设置属性投保人年龄校验标识：对应t_pub_code 的 code_type=AgeFlag：0-不校验；1-校验天数到年份；2-校验年份到年份；3-天数到无穷大；4-年份到无穷大的值
     */
    public void setAppliAgeFlag(String appliAgeFlag) {
        this.appliAgeFlag = appliAgeFlag;
    }

    /**
     * 获取属性投保人年龄下限 （投保人年龄校验标识1,2,3,4此字段必填）的值
     */
    public Integer getAppliAgeLower() {
        return this.appliAgeLower;
    }

    /**
     * 设置属性投保人年龄下限 （投保人年龄校验标识1,2,3,4此字段必填）的值
     */
    public void setAppliAgeLower(Integer appliAgeLower) {
        this.appliAgeLower = appliAgeLower;
    }

    /**
     * 获取属性投保人年龄上限(最大年龄+1) （投保人年龄校验标识1,2此字段必填）的值
     */
    public Integer getAppliAgeUpper() {
        return this.appliAgeUpper;
    }

    /**
     * 设置属性投保人年龄上限(最大年龄+1) （投保人年龄校验标识1,2此字段必填）的值
     */
    public void setAppliAgeUpper(Integer appliAgeUpper) {
        this.appliAgeUpper = appliAgeUpper;
    }

    /**
     * 获取属性被保险人类型:：对应t_pub_code 的 code_type=InsuredType： 1-个人或2-企业（可多选）的值
     */
    public String getInsuredType() {
        return this.insuredType;
    }

    /**
     * 设置属性被保险人类型:：对应t_pub_code 的 code_type=InsuredType： 1-个人或2-企业（可多选）的值
     */
    public void setInsuredType(String insuredType) {
        this.insuredType = insuredType;
    }

    /**
     * 获取属性被保险人证件类型：对应t_pub_code的 code_type=InsuredIdentity (可多选)的值
     */
    public String getInsuredDocType() {
        return this.insuredDocType;
    }

    /**
     * 设置属性被保险人证件类型：对应t_pub_code的 code_type=InsuredIdentity (可多选)的值
     */
    public void setInsuredDocType(String insuredDocType) {
        this.insuredDocType = insuredDocType;
    }

    /**
     * 获取属性被保人年龄校验标识：对应t_pub_code 的 code_type=AgeFlag：0-不校验；1-校验天数到年份；2-校验年份到年份；3-天数到无穷大；4-年份到无穷大的值
     */
    public String getInsuredAgeFlag() {
        return this.insuredAgeFlag;
    }

    /**
     * 设置属性被保人年龄校验标识：对应t_pub_code 的 code_type=AgeFlag：0-不校验；1-校验天数到年份；2-校验年份到年份；3-天数到无穷大；4-年份到无穷大的值
     */
    public void setInsuredAgeFlag(String insuredAgeFlag) {
        this.insuredAgeFlag = insuredAgeFlag;
    }

    /**
     * 获取属性被保人年龄下限 （被保人年龄校验标识1,2,3,4此字段必填）的值
     */
    public Integer getInsuredAgeLower() {
        return this.insuredAgeLower;
    }

    /**
     * 设置属性被保人年龄下限 （被保人年龄校验标识1,2,3,4此字段必填）的值
     */
    public void setInsuredAgeLower(Integer insuredAgeLower) {
        this.insuredAgeLower = insuredAgeLower;
    }

    /**
     * 获取属性被保人年龄上限(最大年龄+1) （被保人年龄校验标识1,2此字段必填）的值
     */
    public Integer getInsuredAgeUpper() {
        return this.insuredAgeUpper;
    }

    /**
     * 设置属性被保人年龄上限(最大年龄+1) （被保人年龄校验标识1,2此字段必填）的值
     */
    public void setInsuredAgeUpper(Integer insuredAgeUpper) {
        this.insuredAgeUpper = insuredAgeUpper;
    }

    /**
     * 获取属性被保人人数校验标识：对应t_pub_code 的 code_type=QuantityFlag：0-不校验；1-校验少到多；2-校验到最少；3-校验到最多；4-固定人数 （意健险产品必填）的值
     */
    public String getQuantityFlag() {
        return this.quantityFlag;
    }

    /**
     * 设置属性被保人人数校验标识：对应t_pub_code 的 code_type=QuantityFlag：0-不校验；1-校验少到多；2-校验到最少；3-校验到最多；4-固定人数 （意健险产品必填）的值
     */
    public void setQuantityFlag(String quantityFlag) {
        this.quantityFlag = quantityFlag;
    }

    /**
     * 获取属性最少被保人人数（被保人人数校验标识1,2,4必填）的值
     */
    public Integer getQuantityMin() {
        return this.quantityMin;
    }

    /**
     * 设置属性最少被保人人数（被保人人数校验标识1,2,4必填）的值
     */
    public void setQuantityMin(Integer quantityMin) {
        this.quantityMin = quantityMin;
    }

    /**
     * 获取属性最多被保人人数 （被保人人数校验标识1,3必填）的值
     */
    public Integer getQuantityMax() {
        return this.quantityMax;
    }

    /**
     * 设置属性最多被保人人数 （被保人人数校验标识1,3必填）的值
     */
    public void setQuantityMax(Integer quantityMax) {
        this.quantityMax = quantityMax;
    }

    /**
     * 获取属性被保险人关系限制编码(多选用英文”,”隔开 对应t_pub_code的 code_type=InsuredIdentity的值
     */
    public String getApplirelation() {
        return this.applirelation;
    }

    /**
     * 设置属性被保险人关系限制编码(多选用英文”,”隔开 对应t_pub_code的 code_type=InsuredIdentity的值
     */
    public void setApplirelation(String applirelation) {
        this.applirelation = applirelation;
    }

    /**
     * 获取属性职业代码(多选用英文”,”隔开)参考职业类别信息的值
     */
    public String getOccupationCode() {
        return this.occupationCode;
    }

    /**
     * 设置属性职业代码(多选用英文”,”隔开)参考职业类别信息的值
     */
    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    /**
     * 获取属性职业等级(多选用英文”,”隔开参考职业类别信息的值
     */
    public String getOccupationLevel() {
        return this.occupationLevel;
    }

    /**
     * 设置属性职业等级(多选用英文”,”隔开参考职业类别信息的值
     */
    public void setOccupationLevel(String occupationLevel) {
        this.occupationLevel = occupationLevel;
    }

    /**
     * 获取属性是否允许生效退保标志：Y-是；N-否的值
     */
    public String getCancelFlag() {
        return this.cancelFlag;
    }

    /**
     * 设置属性是否允许生效退保标志：Y-是；N-否的值
     */
    public void setCancelFlag(String cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    /**
     * 获取属性退保日期差标识：对应t_pub_code 的 code_type=DateUnit：H-小时hours；D-天数days；M-月数months；Y-年数years (当退保生效标识为Y时，此字段为null则不作退保时间控制)的值
     */
    public String getCancelDateUnit() {
        return this.cancelDateUnit;
    }

    /**
     * 设置属性退保日期差标识：对应t_pub_code 的 code_type=DateUnit：H-小时hours；D-天数days；M-月数months；Y-年数years (当退保生效标识为Y时，此字段为null则不作退保时间控制)的值
     */
    public void setCancelDateUnit(String cancelDateUnit) {
        this.cancelDateUnit = cancelDateUnit;
    }

    /**
     * 获取属性退保日期差单位[T+D T=起保日期，D+1=时间差]的值
     */
    public Integer getCancelDate() {
        return this.cancelDate;
    }

    /**
     * 设置属性退保日期差单位[T+D T=起保日期，D+1=时间差]的值
     */
    public void setCancelDate(Integer cancelDate) {
        this.cancelDate = cancelDate;
    }

    /**
     * 获取属性失效标志：0-有效，1-失效的值
     */
    public Integer getInvalidFlag() {
        return this.invalidFlag;
    }

    /**
     * 设置属性失效标志：0-有效，1-失效的值
     */
    public void setInvalidFlag(Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }

    /**
     * 获取属性创建人的值
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * 设置属性创建人的值
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * 获取属性创建时间的值
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * 设置属性创建时间的值
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取属性更新人的值
     */
    public String getUpdatedUser() {
        return this.updatedUser;
    }

    /**
     * 设置属性更新人的值
     */
    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    /**
     * 获取属性更新时间的值
     */
    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    /**
     * 设置属性更新时间的值
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
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

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getFinalDateFormat() {
		return finalDateFormat;
	}

	public void setFinalDateFormat(String finalDateFormat) {
		this.finalDateFormat = finalDateFormat;
	}

	public String getEnterpriseDocType() {
		return enterpriseDocType;
	}

	public void setEnterpriseDocType(String enterpriseDocType) {
		this.enterpriseDocType = enterpriseDocType;
	}

}