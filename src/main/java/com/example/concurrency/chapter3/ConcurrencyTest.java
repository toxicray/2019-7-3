package com.example.concurrency.chapter3;

import com.example.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Package:com.example.concurrency.chapter3
 * *Author:ray
 * *version:...
 * *Created in 2019/5/17  0:11
 **/
@Slf4j
public class ConcurrencyTest {

	//请求总数
	public static int clienTotal=5000;

	public static int threadTotal=200;


	public static int count =0;


	public static void main(String[] args) throws InterruptedException {
		ExecutorService threadPool= Executors.newCachedThreadPool();
		//信号量
		final Semaphore semaphore=new Semaphore(threadTotal);
		//锁
		final CountDownLatch countDownLatch=new CountDownLatch(clienTotal);

		for (int i = 0; i < clienTotal; i++) {
			threadPool.execute(()->
			{
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
					log.error("exception",e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		threadPool.shutdown();
		log.info("count:{}",count);

	}


	public static void add(){
		count++;
	}




}
