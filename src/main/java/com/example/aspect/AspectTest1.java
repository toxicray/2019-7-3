package com.example.aspect;

import com.alibaba.fastjson.JSON;
import com.example.annodemo.Anno1;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Package:com.example.aspect
 * *Author:ray
 * *version:...
 * *Created in 2019/7/6  0:20
 **/
@Aspect
@Component
@Order(5)
public class AspectTest1 {


	@Pointcut("execution(* com.example.service..*.*(..))")
	private void pt1(){}

	//@Pointcut("@annotation(com.example.annodemo.Anno1)")
	//public void pt1(){}


	@Around("pt1()&&@annotation(anno1)")
	//@Around("pt1()&&@annotation(anno1)")
	public void aroundTest(ProceedingJoinPoint pjp, Anno1 anno1){
		//String str= JSON.toJSONString(pjp);
		//System.out.println(str);
		Object rtValue=null;
		Object[] args = pjp.getArgs();//得到方法执行所需的参数
		//for (Object arg : args) {
		//	System.out.println(arg);
		//}
		//System.out.println("---------------------------");
		//String name = pjp.getSignature().getName();
		//System.out.println(name);
		//
		//System.out.println("---------------------------");
		//Signature s = pjp.getSignature();
		//MethodSignature ms = (MethodSignature)s;
		//String name1 = ms.getMethod().getName();
		//System.out.println(name1);
		//
		//
		//System.out.println("----------------------------");
		//System.out.println(anno1.name());
		//System.out.println(anno1.test());

		System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置1");

		try {
			rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）
			System.out.println(rtValue.toString()+"-------------1");
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}

}
