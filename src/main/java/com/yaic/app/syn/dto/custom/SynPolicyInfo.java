package com.yaic.app.syn.dto.custom;

import java.util.List;

import com.yaic.app.syn.dto.domain.SynPolicyDtlDto;
import com.yaic.app.syn.dto.domain.SynPolicyDto;

public class SynPolicyInfo {

    private SynPolicyDto synPolicy;

    private List<SynPolicyDtlDto> synPolicyDtlList;

    public SynPolicyDto getSynPolicy() {
        return synPolicy;
    }

    public void setSynPolicy(SynPolicyDto synPolicy) {
        this.synPolicy = synPolicy;
    }

    public List<SynPolicyDtlDto> getSynPolicyDtlList() {
        return synPolicyDtlList;
    }

    public void setSynPolicyDtlList(List<SynPolicyDtlDto> synPolicyDtlList) {
        this.synPolicyDtlList = synPolicyDtlList;
    }

}
