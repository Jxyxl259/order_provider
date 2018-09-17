package com.yaic.app.pay.service;

import com.yaic.app.order.dto.msg.common.RequestMessage;
import com.yaic.app.order.dto.msg.common.ResponseMessage;

public interface PayService {
    
    /**
     * 5.2.16 第三方支付回调
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage callBackThirdPay(RequestMessage requestMessageObj) throws Exception;

    /**
     * 5.2.17 发起订单支付
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage initOrderPay(RequestMessage requestMessageObj) throws Exception;
    
    /**
     * 5.2.22 获取微信签名
     * 
     * @Author: lujicong
     * @Date: 2015-12-24
     * @Version: 1.0
     * @param requestMessageObj
     * @return
     * @throws Exception
     */
    public ResponseMessage getWxSign(RequestMessage requestMessageObj) throws Exception;
    
}
