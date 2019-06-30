package com.example.util;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

/**
 * Package:com.example.util
 * *Author:ray
 * *version:...
 * *Created in 2019/6/19  13:17
 **/

@Component
public class AcccessControl {

	RateLimiter rateLimiter=RateLimiter.create(0.1);


	public boolean tryAcquire(){
		return rateLimiter.tryAcquire();
	}
}
