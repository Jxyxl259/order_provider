package com.yaic.app.order.dto.msg;

import java.util.Map;

public class GetWxSignReq {

    private String appid;
    private String dataSource;
    private String characterEncoding;
    @SuppressWarnings("rawtypes")
    private Map data;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getCharacterEncoding() {
        return characterEncoding;
    }

    public void setCharacterEncoding(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    @SuppressWarnings("rawtypes")
    public Map getData() {
        return data;
    }

    @SuppressWarnings("rawtypes")
    public void setData(Map data) {
        this.data = data;
    }

}
