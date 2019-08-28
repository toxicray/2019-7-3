package com.distrubuteLock.redis.aopLock.RedisLock;

import com.distrubuteLock.redis.DistributeLock;
import com.distrubuteLock.redis.RedisDistributeLock;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Package:com.distrubuteLock.redis.aopLock.RedisLock
 * *Author:ray
 * *version:...
 * *Created in 2019/8/25  21:32
 **/
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class DistributeLockAutoConfiguration {

	//@Bean
	//@ConditionalOnBean(RedisTemplate.class)
	//public DistributeLock redisDistributeLock(RedisTemplate<Object,Object> redisTemplate){
	//	return new RedisDistributeLock(redisTemplate);
	//}

}
