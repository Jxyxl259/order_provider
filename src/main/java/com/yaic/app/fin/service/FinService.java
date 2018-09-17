package com.yaic.app.fin.service;

import com.yaic.app.fin.dto.msg.common.FinRequestMessage;
import com.yaic.app.fin.dto.msg.common.FinResponseMessage;

public interface FinService {
    
	/**
	 * 查询暂收款是否可用
	 * <p>User: wangwf
	 * <p>Date: 2017-7-12
	 * <p>Version: 1.0
	 * @param requestMessage
	 * @return
	 * @throws Exception
	 */
    public FinResponseMessage checkPoa(FinRequestMessage requestMessage) throws Exception;

}
