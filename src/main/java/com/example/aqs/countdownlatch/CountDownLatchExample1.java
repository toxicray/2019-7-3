package com.example.aqs.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package:com.example.aqs
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  22:34
 **/
@Slf4j
public class CountDownLatchExample1 {

	private final static int threadCount=200;



	public static void main(String[] args) throws InterruptedException {


		ExecutorService executorService = Executors.newCachedThreadPool();

		final CountDownLatch countDownLatch=new CountDownLatch(threadCount);
		for (int i = 0; i < threadCount-5; i++) {
			final int threadNum=i;

			executorService.execute(()->{
				try {
					test(threadNum);
				} catch (InterruptedException e) {
					log.error("exception",e );
				}finally {
					countDownLatch.countDown();
				}
			});
		}
		countDownLatch.await();
		log.info("finish" );
		executorService.shutdown();
	}
	public static void test(int threadNum) throws InterruptedException {
		Thread.sleep(100);
		log.info("{}",threadNum );
		Thread.sleep(100);
	}
}
