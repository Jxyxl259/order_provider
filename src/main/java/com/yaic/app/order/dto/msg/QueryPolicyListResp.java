package com.yaic.app.order.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.custom.PolicyInfo;

public class QueryPolicyListResp {

    /** 保单信息列表 **/
    List<PolicyInfo> policyInfoList = null;

    /** 保单总数 **/
    private Integer total = null;

    public List<PolicyInfo> getPolicyInfoList() {
        return policyInfoList;
    }

    public void setPolicyInfoList(List<PolicyInfo> policyInfoList) {
        this.policyInfoList = policyInfoList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
