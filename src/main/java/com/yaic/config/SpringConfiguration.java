package com.yaic.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yaic.app.generator.IdWorker;

/**
 * 配置类
 *
 * @author Qu Dihuai
 */
@Configuration
public class SpringConfiguration extends WebMvcConfigurerAdapter
{
	@Value("${user.interceptor.permission.ignoreUrl}")
	private String ignoreUrl;

	@Value("${user.interceptor.permission.ignoreFileType}")
	private String ignoreFileType;

	@Value("${idwork.service.work.id}")
	private long workerId;

	@Value("${idwork.service.datacenter.id}")
	private long datacenterId;
	
	//------------------------------- Filter -----------------------------------


	/**
	 * 添加安全防御的过滤器
	 *
	 * @return the SecurityDefenseFilter Registration bean
	 */
	@Bean
	public FilterRegistrationBean addShiroFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setName("shiroFilter");

		final DelegatingFilterProxy filter = new DelegatingFilterProxy();
		registrationBean.setFilter(filter);

		final Set<String> urlPatterns = new HashSet<>(1);
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);

		registrationBean.addInitParameter("shiroFilter", "true");
		return registrationBean;
	}
	

	/**
	 * @return the idWorker instance
	 */
	@Bean("idWorker")
	public IdWorker idWorker()
	{
		return new IdWorker(workerId, datacenterId);
	}
	
}
