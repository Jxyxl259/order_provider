package com.yaic.app.nfin.service;

import com.yaic.app.nfin.dto.msg.common.NFinRequestMessage;
import com.yaic.app.nfin.dto.msg.common.NFinResponseMessage;

public interface NFinService {
    
	/**
	 * <p>新收付查询暂收款是否可用
	 * <p>User: zhaobaoyang
	 * <p>Date: 2018-08-14
	 * @param requestMessage
	 * @return NFinResponseMessage
	 * @throws Exception
	 */
    public NFinResponseMessage checkPoa(NFinRequestMessage requestMessage) throws Exception;

}
