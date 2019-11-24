package com.example.aqs.pool;

import java.util.concurrent.*;

/**
 * Package:com.example.aqs.pool
 * *Author:ray
 * *version:...
 * *Created in 2019/11/6  22:57
 **/
public class ThreadPoolExample {
	static class MyRunable implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {

		ThreadPoolExecutor executorService=new ThreadPoolExecutor(5, 10,
				100,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(10),
				new RejectHandler());

		for (int i = 0; i < 15; i++) {
			executorService.submit(new MyRunable());
		}
		System.out.println(executorService.getActiveCount());
		executorService.shutdown();
	}
}
