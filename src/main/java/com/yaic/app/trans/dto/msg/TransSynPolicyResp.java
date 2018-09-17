package com.yaic.app.trans.dto.msg;

import java.math.BigInteger;
import java.util.List;

import com.yaic.app.trans.dto.custom.SynPolicyDetail;

public class TransSynPolicyResp {
    /** 订单编号 */
    private BigInteger orderCode;

    /** 同步保单处理状态 0-未处理,1-处理成功,2-处理失败 */ 
    private String synPolicyStatus;

    /**同步保单明细列表 **/
    private List<SynPolicyDetail> synPolicyDetailList;

    public BigInteger getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(BigInteger orderCode) {
        this.orderCode = orderCode;
    }

    public String getSynPolicyStatus() {
        return synPolicyStatus;
    }

    public void setSynPolicyStatus(String synPolicyStatus) {
        this.synPolicyStatus = synPolicyStatus;
    }

    public List<SynPolicyDetail> getSynPolicyDetailList() {
        return synPolicyDetailList;
    }

    public void setSynPolicyDetailList(List<SynPolicyDetail> synPolicyDetailList) {
        this.synPolicyDetailList = synPolicyDetailList;
    }
    
    
    
}
