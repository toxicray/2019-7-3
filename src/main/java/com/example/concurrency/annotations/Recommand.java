package com.example.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Package:com.example.concurrency.annotations
 * *Author:ray
 * *version:...
 * *Created in 2019/5/15  0:06
 **/
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Recommand {

	String value() default "";
}
