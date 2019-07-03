package com.example.event;

import org.springframework.stereotype.Component;

/**
 * Package:com.example.event
 * *Author:ray
 * *version:...
 * *Created in 2019/7/2  23:01
 **/
@Component
public class EventListener {

	@org.springframework.context.event.EventListener
	public void lis(EventTest test){

		System.out.println(test.toString());
		System.out.println("1监听到了请求");
	}

	@org.springframework.context.event.EventListener
	public void lis2(EventTest test){

		System.out.println(test.toString());
		System.out.println("2监听到了请求");
	}


}
