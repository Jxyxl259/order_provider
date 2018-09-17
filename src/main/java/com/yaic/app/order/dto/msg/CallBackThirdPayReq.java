package com.yaic.app.order.dto.msg;

public class CallBackThirdPayReq {
    /**订单号 **/
    private String orderCode;
    
    /** 支付人**/
    private String payeeName;
    
    /** 支付银行**/
    private String bankName;
    
    /** 支付账号**/
    private String bankAccount; 

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

}
