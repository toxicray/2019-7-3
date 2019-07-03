package com.example;

import com.example.fbsLock.commen.CacheKeyGenerator;
import com.example.fbsLock.commen.LockKeyGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Package:com.example
 * *Author:ray
 * *version:...
 * *Created in 2019/6/19  13:07
 **/

@EnableAsync
@SpringBootApplication
@SpringBootConfiguration
public class ConcuuApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConcuuApplication.class,args);
	}

	@Bean
	public CacheKeyGenerator cacheKeyGenerator(){
		return new LockKeyGenerator();
	}



}
