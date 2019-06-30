package com.example.fbsLock.commen;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Package:com.example.fbsLock.commen
 * *Author:ray
 * *version:...
 * *Created in 2019/6/19  16:42
 **/
public interface CacheKeyGenerator {


	String getLockKey(ProceedingJoinPoint pjp);

}
