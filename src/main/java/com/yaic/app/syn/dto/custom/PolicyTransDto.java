package com.yaic.app.syn.dto.custom;

public class PolicyTransDto {

    private HeadDto headRequest = new HeadDto();

    private BodyDto bodyRequest = new BodyDto();

    private HeadDto headResponse = new HeadDto();

    private BodyDto bodyResponse = new BodyDto();

    public HeadDto getHeadRequest() {
        return headRequest;
    }

    public void setHeadRequest(HeadDto headRequest) {
        this.headRequest = headRequest;
    }

    public BodyDto getBodyRequest() {
        return bodyRequest;
    }

    public void setBodyRequest(BodyDto bodyRequest) {
        this.bodyRequest = bodyRequest;
    }

    public HeadDto getHeadResponse() {
        return headResponse;
    }

    public void setHeadResponse(HeadDto headResponse) {
        this.headResponse = headResponse;
    }

    public BodyDto getBodyResponse() {
        return bodyResponse;
    }

    public void setBodyResponse(BodyDto bodyResponse) {
        this.bodyResponse = bodyResponse;
    }

}
