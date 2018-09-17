package com.yaic.app.pubs.service;


import com.yaic.app.pubs.dto.msg.MailRequestDto;
import com.yaic.app.pubs.dto.msg.MailResponseDto;

public interface MailService {
    
	/**
	 * 发送邮件
	 * <p>User: wangwf
	 * <p>Date: 2017-7-13
	 * <p>Version: 1.0
	 * @param requestMessage
	 * @return
	 * @throws Exception
	 */
    public MailResponseDto sendEmail(MailRequestDto requestMessage);

}
