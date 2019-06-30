//package com.example.fbsLock.interceptor;
//
//import com.example.fbsLock.annotation.CacheLock;
//import com.example.fbsLock.commen.CacheKeyGenerator;
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import java.lang.reflect.Method;
//
///**
// * Package:com.example.fbsLock.interceptor
// * *Author:ray
// * *version:...
// * *Created in 2019/6/19  17:46
// **/
//
//
//@Aspect
//@Configuration
//public class LockMethodIntecepter {
//	private final StringRedisTemplate lockRedisTemplate;
//	private final CacheKeyGenerator cacheKeyGenerator;
//
//	@Autowired
//	public LockMethodIntecepter(StringRedisTemplate lockRedisTemplate, CacheKeyGenerator cacheKeyGenerator) {
//		this.lockRedisTemplate = lockRedisTemplate;
//		this.cacheKeyGenerator = cacheKeyGenerator;
//	}
//
//	@Around("execution(public * *(..)) && @annotation(com.example.fbsLock.annotation.CacheLock)")
//	public Object interceptor(ProceedingJoinPoint pjp) {
//		MethodSignature signature = (MethodSignature) pjp.getSignature();
//		Method method = signature.getMethod();
//		CacheLock lock = method.getAnnotation(CacheLock.class);
//		if (StringUtils.isEmpty(lock.prefix())) {
//			throw new RuntimeException("lock key can't be null!");
//		}
//
//		final String lockKey = cacheKeyGenerator.getLockKey(pjp);
//		try {
//			final boolean success = lockRedisTemplate.opsForValue().setIfAbsent(lockKey, "");
//			if (success) {
//				lockRedisTemplate.expire(lockKey, lock.expire(), lock.timeUnit());
//			} else {
//				throw new RuntimeException("请勿重复请求!");
//			}
//			try {
//				return pjp.proceed();
//			} catch (Throwable throwable) {
//				throw new RuntimeException("系统异常!");
//			}
//		} finally {
//			lockRedisTemplate.delete(lockKey);
//		}
//	}
//}