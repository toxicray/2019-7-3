package com.example.fbsLock.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * Package:com.example.fbsLock.annotation
 * *Author:ray
 * *version:...
 * *Created in 2019/6/19  16:24
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheLock {


	/**
	 * @return
	 * @Description redis锁的前缀
	 * @Param
	 **/
	String prefix() default "";

	/**
	 * @return 轮询锁的事件
	 * @Description 过期时间, 默认为5s
	 * @Param
	 **/
	int expire() default 5;

	/**
	 *@Description 超时的时间单位
			* @Param
			* @return 默认为秒
			**/
	TimeUnit timeUnit() default TimeUnit.SECONDS;


	/**
	 *@Description key的分隔符(默认为 :)
			* @Param
			* @return 比如生成的key N:SO1008:500</P>
			**/
	String delimeter() default ":";

}
