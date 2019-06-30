package com.example.fbsLock.annotation;

/**
 * Package:com.example.fbsLock.annotation
 * *Author:ray
 * *version:...
 * *Created in 2019/6/19  16:39
 **/


public @interface CacheParam {

	/**
	 *@Description 字段名称
			* @Param
			* @return
			**/
   String name() default "";
}
