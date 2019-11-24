package com.example.guava;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package:com.example.guava
 * *Author:ray
 * *version:...
 * *Created in 2019/7/22  23:13
 **/
public class TestList {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		List<List<Integer>> lists = Lists.partition(list, 30);
		for (List<Integer> integers : lists) {
			for (Integer integer : integers) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}
	@Test
	public void testRateLimiter(){
		RateLimiter rateLimiter=RateLimiter.create(3);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			executorService.submit(new ThreadDemo());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//rateLimiter.tryAcquire()
	}
	class ThreadDemo implements Runnable{
		@Override
		public void run() {
			System.out.println(new Date().toString()+Thread.currentThread().getName());
		}
	}

}
