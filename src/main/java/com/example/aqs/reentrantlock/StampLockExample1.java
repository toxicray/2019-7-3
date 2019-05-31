package com.example.aqs.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * Package:com.example.aqs.reentrantlock
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  23:40
 **/
@Slf4j
public class StampLockExample1 {

	//请求总数
	public static int clienTotal=5000;

	public static int threadTotal=200;

	public static int count =0;


	//默认使用的是非公平锁
	private  static final StampedLock lock=new StampedLock();

	//tryLock

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
		long stamp = lock.writeLock();
		try {
			count++;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock(stamp);
		}
	}
}
