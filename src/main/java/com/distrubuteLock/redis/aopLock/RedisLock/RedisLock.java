package com.distrubuteLock.redis.aopLock.RedisLock;

import java.lang.annotation.*;

/**
 * Package:com.distrubuteLock.redis.aopLock.RedisLock
 * *Author:ray
 * *version:...
 * *Created in 2019/8/25  20:27
 **/


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisLock {

	/**锁的资源,redis的key*/
	String value() default "default";

	/**持锁时间,单位毫秒*/
	long keepMillis() default 30000;

	LockFailAction action();

	public enum LockFailAction{
		//放弃
		GIVEUP,
		//继续
		CONTINUE;
	}

	/*重试时间间隔*/
	long sleepMillis() default 200;
	/*重试次数*/
	int retryTimes() default 5;

}
