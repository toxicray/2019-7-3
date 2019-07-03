package com.example.event;

import org.springframework.context.ApplicationEvent;

/**
 * Package:com.example
 * *Author:ray
 * *version:...
 * *Created in 2019/7/2  22:53
 **/
public class EventTest extends ApplicationEvent {

	public EventTest(Object source) {
		super(source);
	}
}
