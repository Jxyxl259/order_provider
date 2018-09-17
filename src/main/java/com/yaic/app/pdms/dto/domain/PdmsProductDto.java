/*
 * Created By lujicong (2017-06-19 10:59:27)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.pdms.dto.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaic.fa.dto.BaseDto;

/**
 * 产品表
 */
@Table(name = "t_pdms_product")
public class PdmsProductDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = PdmsProductDto.class.getName().hashCode();

    /** 主键ID */
    @Id
    private Integer prodId;
    
    /** 产品代码 */
    private String prodCode;

    /** 产品名称 */
    private String prodName;

    /** 产品版本 */
    private String prodVersion;

    /** 助记码 */
    private String mnemonicCode;

    /** 广义险种代码*/
    private String prodRiskCode;
    
    /** 产品系列 */
    private String prodLine;
    
    /** 产品类型：对应t_pub_code 的 code_type=ProductType */
    private String prodType;
    
    /** 产品状态：对应t_pub_code 的 code_type=ProductStatus */
    private String prodStatus;

    /** 生效日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date validDate;

    /** 失效日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date invalidDate;

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

    /**产品系列名称*/
    @Transient
    private String manyFactorFlag;
    
    /**产品系列名称*/
    @Transient
    private String prodLineName;
    
    /**币别代码*/
    @Transient
    private String currencyCode;
    
    /**币别名称*/
    @Transient
    private String currencyName;
    
    /**单位代码*/
    @Transient
    private String unitCode;
    
    /**单位名称*/
    @Transient
    private String unitName;
    
    /**限额代码*/
    @Transient
    private String limitCode;
    
    /**限额名称*/
    @Transient
    private String limitName;
    
    /**搜索起始时间*/
    @Transient
    private Date searchStartTime;
    
    /**搜索结束时间*/
    @Transient
    private Date searchEndTime;
    
    /**业务校验映射*/
    @Transient
    private PdmsCheckMappingDto checkMappingDto;
    
    /** 产品险种信息列表 */
    @Transient
    private List<PdmsProductRiskDto> productRiskList;
    
    /**
     * 获取产品ID
     */
	public Integer getProdId() {
		return prodId;
	}
	
	/**
     * 设置产品ID
     */
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	/**
     * 获取属性产品代码的值
     */
    public String getProdCode() {
        return this.prodCode;
    }

    /**
     * 设置属性产品代码的值
     */
    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    /**
     * 获取属性产品名称的值
     */
    public String getProdName() {
        return this.prodName;
    }

    /**
     * 设置属性产品名称的值
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    /**
     * 获取属性产品版本的值
     */
    public String getProdVersion() {
        return this.prodVersion;
    }

    /**
     * 设置属性产品版本的值
     */
    public void setProdVersion(String prodVersion) {
        this.prodVersion = prodVersion;
    }

    /**
     * 获取属性助记码的值
     */
    public String getMnemonicCode() {
        return this.mnemonicCode;
    }

    /**
     * 设置属性助记码的值
     */
    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    /**
     * 获取属性产品系列的值
     */
    public String getProdLine() {
        return this.prodLine;
    }

    /**
     * 设置属性产品系列的值
     */
    public void setProdLine(String prodLine) {
        this.prodLine = prodLine;
    }

    /**
     * 获取产品系列名称的值
     */
	public String getProdLineName() {
		return prodLineName;
	}
	
	/**
     * 设置产品系列名称的值
     */
	public void setProdLineName(String prodLineName) {
		this.prodLineName = prodLineName;
	}

    /**
     * 获取属性产品类型：对应t_pub_code 的 code_type=ProductType的值
     */
    public String getProdType() {
        return this.prodType;
    }

    /**
     * 设置属性产品类型：对应t_pub_code 的 code_type=ProductType的值
     */
    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    /**
     * 获取属性产品状态：对应t_pub_code 的 code_type=ProductStatus的值
     */
    public String getProdStatus() {
        return this.prodStatus;
    }

    /**
     * 设置属性产品状态：对应t_pub_code 的 code_type=ProductStatus的值
     */
    public void setProdStatus(String prodStatus) {
        this.prodStatus = prodStatus;
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

    /**产品系列名称*/
	public String getManyFactorFlag() {
		return manyFactorFlag;
	}

	/**产品系列名称*/
	public void setManyFactorFlag(String manyFactorFlag) {
		this.manyFactorFlag = manyFactorFlag;
	}
	
    /**
     * 获取生效时间
     */
    public Date getValidDate() {
		return validDate;
	}
    
    /**
     * 设置生效时间
     */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
    
	 /**
     * 获取失效时间
     */
	public Date getInvalidDate() {
		return invalidDate;
	}

	/**
	 * 设置失效时间
	 */
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	
	/**
     * 获取货币代码
     */
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	/**
     * 设置货币代码
     */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
     * 获取货币名称
     */
	public String getCurrencyName() {
		return currencyName;
	}

	/**
     * 设置货币名称
     */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	/**
     * 获取单位代码
     */
	public String getUnitCode() {
		return unitCode;
	}

	/**
     * 设置单位代码
     */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	/**
     * 获取单位名称
     */
	public String getUnitName() {
		return unitName;
	}

	/**
     * 设置单位名称
     */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	/**
     * 获取限额代码
     */
	public String getLimitCode() {
		return limitCode;
	}

	/**
     * 设置限额代码
     */
	public void setLimitCode(String limitCode) {
		this.limitCode = limitCode;
	}
	
	/**
     * 获取限额名称
     */
	public String getLimitName() {
		return limitName;
	}

	/**
     * 设置限额名称
     */
	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}

	/**
     * 获取产品险种代码
     */
	public String getProdRiskCode() {
		return prodRiskCode;
	}

	/**
     * 设置产品险种代码
     */
	public void setProdRiskCode(String prodRiskCode) {
		this.prodRiskCode = prodRiskCode;
	}

	/**
     * 获取搜索起始时间
     */
	public Date getSearchStartTime() {
		return searchStartTime;
	}

	/**
     * 设置搜索起始时间
     */
	public void setSearchStartTime(Date searchStartTime) {
		this.searchStartTime = searchStartTime;
	}

	/**
     * 获取搜索结束时间
     */
	public Date getSearchEndTime() {
		return searchEndTime;
	}

	/**
     * 设置搜索结束时间
     */
	public void setSearchEndTime(Date searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

	/**
     * 获取业务校验映射
     */
	public PdmsCheckMappingDto getCheckMappingDto() {
		return checkMappingDto;
	}

	/**
	 * 设置业务校验映射
	 */
	public void setCheckMappingDto(PdmsCheckMappingDto checkMappingDto) {
		this.checkMappingDto = checkMappingDto;
	}

	/**
     *  获取产品险种列表
     */
    public List<PdmsProductRiskDto> getProductRiskList() {
		return productRiskList;
	}
    
    /**
     *  设置产品险种列表
     */
    public void setProductRiskList(List<PdmsProductRiskDto> productRiskList) {
    	this.productRiskList = productRiskList;
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