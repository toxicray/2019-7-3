package com.example.fbsLock.commen;

import com.example.fbsLock.annotation.CacheLock;
import com.example.fbsLock.annotation.CacheParam;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Package:com.example.fbsLock.commen
 * *Author:ray
 * *version:...
 * *Created in 2019/6/19  16:57
 **/
public class LockKeyGenerator implements CacheKeyGenerator {
	@Override
	public String getLockKey(ProceedingJoinPoint pjp) {
		//获得对象方法的签名?
		MethodSignature signature= (MethodSignature) pjp.getSignature();
		//获取到对应的方法
		Method method=signature.getMethod();
		//获取该方法上的锁的注解
		CacheLock lockAnnotation =method.getAnnotation(CacheLock.class);
		//获取到pjp的参数
		final Object[] args=pjp.getArgs();
		final Parameter[] parameters=method.getParameters();

		StringBuilder builder=new StringBuilder();
		//默认解析方法里面带CacheParam注解的属性,如果没有尝试着解析实体对象中的
		for (int i = 0; i < parameters.length; i++) {
			final CacheParam annotation=parameters[i].getAnnotation(CacheParam.class);
			if (annotation==null){
			    continue;
			}
			//生成锁的key,拼接上分隔符
			builder.append(lockAnnotation.delimeter());
		}
		//解析实体对象中的
		if (StringUtils.isEmpty(builder.toString())){
			final Annotation[] [] parameterAnnotations=method.getParameterAnnotations();
			for (int i = 0; i < parameterAnnotations.length; i++) {
				final Object object = args[i];
				final Field[] fields = object.getClass().getDeclaredFields();
				for (Field field : fields) {
					final CacheParam annotation = field.getAnnotation(CacheParam.class);
					if (annotation == null) {
						continue;
					}
					field.setAccessible(true);
					builder.append(lockAnnotation.delimeter()).append(ReflectionUtils.getField(field, object));
				}
			}
		}
		return lockAnnotation.prefix()+builder.toString();
	}
}
