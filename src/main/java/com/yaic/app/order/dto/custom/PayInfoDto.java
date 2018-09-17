package com.yaic.app.order.dto.custom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PayInfoDto implements Serializable {

    private static final long serialVersionUID = -6364570394151012150L;
    /** 订单提交URL 注:success="true"时必填**/
    private String serviceUrl = null;
    /** 订单是否成功  注:true|false **/
    private String success = "false";
    /** 订单批次号 **/
    private String batchNo = null;
    /** 订单号 **/
    private String orderID = null;
    /** 订单日期  yyyyMMddHHmmss**/
    private String orderDate = null;
    /** 接口名称 alipay.trade.precreate success="true"时必填**/
    private String method = null;
    /** 开发者的AppId success="true"时必填**/
    private String app_id = null;
    /** 参数字符编码 success="true"时必填**/
    private String charset = null;
    /** 签名类型 RSA，success="true"时必填 **/
    private String sign_type = null;
    /** 签名 success="true"时必填**/
    private String sign = null;
    /** 时间戳 2014-07-24 03:07:50，success="true"时必填**/
    private String timestamp = null;
    /** 业务参数 JSON格式，success="true"时必填**/
    private String biz_content = null;
    /** 错误说明 **/
    private String errorMsg = "";
    /** 预支付ID **/
    private String prepayId = null;
    /** 二维码地址 **/
    private String codeUrl = null;
    /** 参数 **/
    private Map<String, Object> parameter = new HashMap<String, Object>();

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public Map<String, Object> getParameter() {
        return parameter;
    }

    public void setParameter(Map<String, Object> parameter) {
        this.parameter = parameter;
    }

    public void addParameter(String key, Object value) {
        if (this.parameter == null) {
            this.parameter = new HashMap<String, Object>();
        }
        this.parameter.put(key, value);
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBiz_content() {
        return biz_content;
    }

    public void setBiz_content(String biz_content) {
        this.biz_content = biz_content;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

}
