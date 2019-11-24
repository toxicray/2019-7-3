package com.example.aqs.pool;

import java.util.concurrent.ThreadFactory;

/**
 * Package:com.example.aqs.pool
 * *Author:ray
 * *version:...
 * *Created in 2019/11/7  0:12
 **/
public class CustomFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread thread=new Thread("ray");
		return thread;
	}
}
