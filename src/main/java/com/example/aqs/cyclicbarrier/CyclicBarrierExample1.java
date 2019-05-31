package com.example.aqs.cyclicbarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package:com.example.aqs.cyclicbarrier
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  23:10
 **/
@Slf4j
public class CyclicBarrierExample1 {


	private static CyclicBarrier barrier=new CyclicBarrier(5);


	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int threadNum=i;
			Thread.sleep(1000);
			executorService.execute(()->{

				try {
					race(threadNum);
				} catch (Exception e) {
					log.error("exception",e );
					e.printStackTrace();
				}
			});
		}





	}
	private static void race(int threadNum) throws Exception {
		Thread.sleep(1000);
		log.info("{} is ready",threadNum );
		barrier.await();
		log.info("{} is continue",threadNum );
	}
}
