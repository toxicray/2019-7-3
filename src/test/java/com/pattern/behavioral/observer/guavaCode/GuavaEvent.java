package com.pattern.behavioral.observer.guavaCode;

import com.google.common.eventbus.Subscribe;

/**
 * Package:com.pattern.behavioral.observer.guavaCode
 * *Author:ray
 * *version:...
 * *Created in 2019/12/31  0:18
 **/

public class GuavaEvent {
	@Subscribe
	public void subscribe(String str){
		System.out.println("执行了subsCribe方法,入参是: "+str);
	}

}
