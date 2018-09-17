package com.yaic.app.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * ID生成器
 *
 * @author Qu Dihuai
 */
@Component("idGenerator")
public class IdGenerator
{
	@Autowired
	private IdWorker idWorker;

	/**
	 * 生成ID的核心方法
	 *
	 * @return ID
	 */
	public String generate()
	{
		return Long.toString(idWorker.nextId());
	}
}
