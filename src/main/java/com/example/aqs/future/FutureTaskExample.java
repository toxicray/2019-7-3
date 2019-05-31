package com.example.aqs.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Package:com.example.aqs.future
 * *Author:ray
 * *version:...
 * *Created in 2019/5/27  21:56
 **/
@Slf4j
public class FutureTaskExample {
	public static void main(String[] args) throws Exception {

		FutureTask<String> futureTask=new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				log.info("do something in callable" );
				Thread.sleep(5000);
				return "Done";
			}
		});

	new Thread(futureTask).start();
		log.info("do something in main!" );
		Thread.sleep(1000);
		String s = futureTask.get();
		log.info("result:{}",s );
	}
}
