package com.example.aqs.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Package:com.example.aqs
 * *Author:ray
 * *version:...
 * *Created in 2019/5/27  21:49
 **/
@Slf4j
public class FutureExample {

	static class MyCallable implements Callable<String>{
		@Override
		public String call() throws InterruptedException {

			log.info("do something in callable" );

				Thread.sleep(5000);

			return "Done";
		}
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newCachedThreadPool();
		Future<String> submit = pool.submit(new MyCallable());
		log.info("do something in main!" );
		Thread.sleep(1000);
		String s = submit.get();
		log.info(s );
	}
}
