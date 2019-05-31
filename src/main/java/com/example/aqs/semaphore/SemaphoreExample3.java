package com.example.semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Package:com.example.semaphore
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  22:57
 **/
@Slf4j
public class SemaphoreExample3 {


	private final static int threadCount=200;



	public static void main(String[] args) throws InterruptedException {


		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore=new Semaphore(20);

		for (int i = 0; i < threadCount-5; i++) {
			final int threadNum=i;

			executorService.execute(()->{
				try {
					//许可数
					if(semaphore.tryAcquire(5, 1,TimeUnit.MINUTES)){
						test(threadNum);
						//释放许可
						semaphore.release(20);
					}
				} catch (InterruptedException e) {
					log.error("exception",e );
				}
			});
		}
		log.info("finish" );
		executorService.shutdown();
	}
	public static void test(int threadNum) throws InterruptedException {

		log.info("{}",threadNum );
		Thread.sleep(1000);
	}

}
