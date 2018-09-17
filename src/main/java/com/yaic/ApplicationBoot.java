package com.yaic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;


/**
 * This is application Boot, used to configure the scan paths for mapper, servlet and filter etc.
 *
 * @author Qu Dihuai
 */
@SpringBootApplication
@ImportResource(locations = { "classpath:config/spring-beans.xml" })
@MapperScan(basePackages = { "com.yaic.**.dao" })
@ServletComponentScan(basePackages = { "com.yaic.servlet" })
public class ApplicationBoot extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application)
	{
		return application.sources(ApplicationBoot.class);
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{
		SpringApplication.run(ApplicationBoot.class, args);
	}
}

