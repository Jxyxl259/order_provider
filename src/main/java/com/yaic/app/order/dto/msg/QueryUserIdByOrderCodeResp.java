package com.yaic.app.order.dto.msg;

import java.math.BigInteger;

public class QueryUserIdByOrderCodeResp {
    /** 用户ID **/
    private BigInteger userId;

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
}
