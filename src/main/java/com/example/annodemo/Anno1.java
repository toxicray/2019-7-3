package com.example.annodemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Package:com.example.annodemo
 * *Author:ray
 * *version:...
 * *Created in 2019/7/6  0:55
 **/@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Anno1 {

	String name() default "我是谁";

	String test() default "";

}
