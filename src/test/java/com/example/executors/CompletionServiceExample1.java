package com.example.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Package:com.example.executors
 * *Author:ray
 * *version:...
 * *Created in 2020/4/15  19:39
 **/
public class CompletionServiceExample1 {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer> future = service.submit(() -> {
			sleep(2);
			return 10;
		});

	}

	private static void sleep(int num) throws InterruptedException {
		TimeUnit.SECONDS.sleep(num);
	}


}
