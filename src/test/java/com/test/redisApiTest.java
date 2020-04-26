package com.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Package:com.test
 * *Author:ray
 * *version:...
 * *Created in 2020/2/22  14:55
 **/
public class redisApiTest extends BaseTest {

	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	@Test
	public void testRedisApi(){
		redisTemplate.boundValueOps("haha").set("hehe");
		String haha = redisTemplate.boundValueOps("haha").get();
		System.out.println(haha);
		String andSet = redisTemplate.boundValueOps("haha").getAndSet("ray");
		System.out.println(andSet);
		//redisTemplate.opsForValue().setBit()
	}


	@Test
	public void testRedisDcre(){
		Long num = redisTemplate.boundValueOps("num").decrement(6L);
		if (num<0){
			System.out.println(num);
		}
		Long num1 = redisTemplate.boundValueOps("num").increment(7);
		//redisTemplate.opsForValue().setBit()
	}

	@Test
	public void testRedisDcreDouble(){
		//Long num = redisTemplate.boundValueOps("num").decrement(5);
		//if (num<0){
		//	System.out.println(num);
		//}
		Double num1 = redisTemplate.boundValueOps("num").increment(-0.235);
		//redisTemplate.opsForValue().setBit()
	}
}
