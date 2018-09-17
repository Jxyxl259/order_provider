package com.yaic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;


/**
 * @author Wang Zhonghua
 */
@Configuration
public class WebConfiguration
{
	/**
	 * @Description i18n的配置
	 * @return ResourceBundleMessageSource
	 */
	@Bean(name = "messageSource")
	public ResourceBundleMessageSource messageSource()
	{
		ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
		bean.setBasenames("messages.common","messages.biz");
		return bean;
	}

}
