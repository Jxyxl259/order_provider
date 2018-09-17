package com.yaic;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yaic.fa.redis.core.RedisTemplate;


/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests
{

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 *
	 */
	@Ignore
	@Test
	public void contextLoads()
	{
		System.out.println("Hello world");
	}

	/**
	 * Redis测试
	 */
	@Test
	public void redisTest()
	{
		final String key = "T_USER_DEF_92337290581377024000";

		redisTemplate.set(key, "abcdefg");
		redisTemplate.get(key);

		final Object object = redisTemplate.get(key);
		System.out.println(object);
	}

}
