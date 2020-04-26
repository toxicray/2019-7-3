package com.example.concurrency.chapter3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Package:com.example.concurrency.chapter3
 * *Author:ray
 * *version:...
 * *Created in 2020/1/17  19:31
 **/
public class TestSynLock {
	//请求总数
	public static int clienTotal=10000;
	public static int threadTotal=200;
	public static int count =0;

	public static void main(String[] args) throws InterruptedException {

		ExecutorService threadPool= Executors.newCachedThreadPool();
		//信号量
		final Semaphore semaphore=new Semaphore(threadTotal);
		//锁
		final CountDownLatch countDownLatch=new CountDownLatch(clienTotal);
		TestSynLock demo=new TestSynLock();

		for (int i = 0; i < clienTotal; i++) {
			final int index=i;
			threadPool.execute(()->
			{
				try {
					semaphore.acquire();
					//if (index%2==0){
					//    demo.add2();
					//}else{
					//	demo.add1();
					//}
					demo.add3();
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		System.out.println(count);
		threadPool.shutdown();
	}
	public synchronized static void add(){
		count++;
	}
	public synchronized void add1(){
		count++;
	}
	public synchronized void add2(){
		count++;
	}
	public void add3(){
		Object object=new Object();
		synchronized (object){
			count++;
		}
	}
	public void add4(){
		count++;
	}
}
