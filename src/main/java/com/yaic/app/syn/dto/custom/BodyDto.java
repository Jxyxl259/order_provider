package com.yaic.app.syn.dto.custom;

public class BodyDto {

    private PolicyMainDto guPolicyMainDto;
    
    private PolicyMainMapDto policyMainMap;

    public PolicyMainDto getGuPolicyMainDto() {
        return guPolicyMainDto;
    }

    public void setGuPolicyMainDto(PolicyMainDto guPolicyMainDto) {
        this.guPolicyMainDto = guPolicyMainDto;
    }

    public PolicyMainMapDto getPolicyMainMap() {
        return policyMainMap;
    }

    public void setPolicyMainMap(PolicyMainMapDto policyMainMap) {
        this.policyMainMap = policyMainMap;
    }

}
