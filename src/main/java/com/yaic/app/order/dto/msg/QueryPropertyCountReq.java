package com.yaic.app.order.dto.msg;

import java.math.BigInteger;

public class QueryPropertyCountReq {

    /** 订单编号 */
    private BigInteger orderCode;

    /** 用户id */
    private BigInteger userId;
    
    /** 订单来源 */
    private java.lang.String referer;
    
    /** 商品的id */
    private java.lang.String goodsId;

    /** 协议号 */
    private String agrtCode;

    /** 方案代码 */
    private String projectCode;

    /** 投保单号 */
    private java.lang.String proposalNo;

    /** 保单号 */
    private java.lang.String policyNo;
    
    /** 省份代码 */ 
    private java.lang.String itemProvinceCode;
    
    /** 省份名称 */ 
    private java.lang.String itemProvinceCname;
    
    /** 城市代码 */ 
    private java.lang.String itemCityCode;
    
    /** 城市名称 */ 
    private java.lang.String itemCityCname;
    
    /** 区县代码 */ 
    private java.lang.String itemDistrictCode;
    
    /** 区县名称 */ 
    private java.lang.String itemDistrictCname;
    
    /** 保险住所 */ 
    private java.lang.String situation;

    public BigInteger getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(BigInteger orderCode) {
        this.orderCode = orderCode;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public java.lang.String getReferer() {
        return referer;
    }

    public void setReferer(java.lang.String referer) {
        this.referer = referer;
    }

    public java.lang.String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(java.lang.String goodsId) {
        this.goodsId = goodsId;
    }

    public String getAgrtCode() {
        return agrtCode;
    }

    public void setAgrtCode(String agrtCode) {
        this.agrtCode = agrtCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public java.lang.String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(java.lang.String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public java.lang.String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }

    public java.lang.String getItemProvinceCode() {
        return itemProvinceCode;
    }

    public void setItemProvinceCode(java.lang.String itemProvinceCode) {
        this.itemProvinceCode = itemProvinceCode;
    }

    public java.lang.String getItemProvinceCname() {
        return itemProvinceCname;
    }

    public void setItemProvinceCname(java.lang.String itemProvinceCname) {
        this.itemProvinceCname = itemProvinceCname;
    }

    public java.lang.String getItemCityCode() {
        return itemCityCode;
    }

    public void setItemCityCode(java.lang.String itemCityCode) {
        this.itemCityCode = itemCityCode;
    }

    public java.lang.String getItemCityCname() {
        return itemCityCname;
    }

    public void setItemCityCname(java.lang.String itemCityCname) {
        this.itemCityCname = itemCityCname;
    }

    public java.lang.String getItemDistrictCode() {
        return itemDistrictCode;
    }

    public void setItemDistrictCode(java.lang.String itemDistrictCode) {
        this.itemDistrictCode = itemDistrictCode;
    }

    public java.lang.String getItemDistrictCname() {
        return itemDistrictCname;
    }

    public void setItemDistrictCname(java.lang.String itemDistrictCname) {
        this.itemDistrictCname = itemDistrictCname;
    }

    public java.lang.String getSituation() {
        return situation;
    }

    public void setSituation(java.lang.String situation) {
        this.situation = situation;
    }
    
    
}
