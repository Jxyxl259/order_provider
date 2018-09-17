package com.yaic.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yaic.fa.mybatis.mapper.helper.MapperInterceptor;
import com.yaic.fa.mybatis.pagehelper.PageHelper;


/**
 * @author Wang Weifeng
 */
@Configuration
public class MyBatisConfiguration
{
	/**
	 * @return the PageHelper
	 */
	@Bean
	public PageHelper pageHelper()
	{
		final PageHelper pageHelper = new PageHelper();
		final Properties properties = new Properties();
		properties.setProperty("dialect", "mysql");
		properties.setProperty("reasonable", "true");
		pageHelper.setProperties(properties);
		return pageHelper;
	}

	/**
	 * @return the MapperInterceptor
	 */
	@Bean
	public MapperInterceptor mapperInterceptor()
	{
		final MapperInterceptor mapperInterceptor = new MapperInterceptor();
		final Properties properties = new Properties();
		properties.setProperty("mappers", "com.yaic.fa.mybatis.mapper.common.Mapper");
		properties.setProperty("IDENTITY", "MySQL");
		properties.setProperty("notEmpty", "true");
		mapperInterceptor.setProperties(properties);
		return mapperInterceptor;
	}
}
