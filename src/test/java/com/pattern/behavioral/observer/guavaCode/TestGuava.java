package com.pattern.behavioral.observer.guavaCode;

import com.google.common.eventbus.EventBus;

/**
 * Package:com.pattern.behavioral.observer.guavaCode
 * *Author:ray
 * *version:...
 * *Created in 2019/12/31  0:22
 **/
public class TestGuava {
	public static void main(String[] args) {

		EventBus eventBus=new EventBus();
		GuavaEvent guavaEvent=new GuavaEvent();

		eventBus.register(guavaEvent);
		eventBus.post("post内容");
	}

}
