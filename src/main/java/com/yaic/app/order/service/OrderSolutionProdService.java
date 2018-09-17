/*
 * Created By lujicong (2015-12-21 16:02:13)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.service;

import com.yaic.app.pdms.dto.msg.common.PdmsRequestMessage;
import com.yaic.app.pdms.dto.msg.common.PdmsResponseMessage;

public interface OrderSolutionProdService {

    /**
	 * 根据方案代码查询出销售方案信息
	 * <p>User: xruichang
	 * <p>Date: 2017年9月5日
	 * <p>Version: 1.0
	 */
	public PdmsResponseMessage getPdmsSolution(PdmsRequestMessage requestMessage) throws Exception;
	
	/**
	 * 查询产品信息
	 * <p>User: xruichang
	 * <p>Date: 2017年9月5日
	 * <p>Version: 1.0
	 */
	public PdmsResponseMessage getPdmsProduct(PdmsRequestMessage requestMessage) throws Exception;
	
	/**
	 * 查询产品工厂销售及产品的所有信息
	 * <p>User: xruichang
	 * <p>Date: 2017年9月5日
	 * <p>Version: 1.0
	 */
	public PdmsResponseMessage getPdmsSolutionProd(PdmsRequestMessage requestMessage) throws Exception;
	
}
