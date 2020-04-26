package com.example.publish;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Package:com.example.publish
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  0:12
 **/

public class Escape {
	public static void main(String[] args) {

		CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->{
			sleep(1);
			return 1;
		});
		CompletableFuture<Integer> future1=CompletableFuture.supplyAsync(()->{
			sleep(2);
			return 2;
		});
		CompletableFuture<Integer> future2=CompletableFuture.supplyAsync(()->{
			sleep(3);
			return 3;
		});
		CompletableFuture<Integer>[] arr=new CompletableFuture[3];
		arr[0]=future;
		arr[1]=future1;
		arr[2]=future2;
		CompletableFuture<Void> future3=CompletableFuture.allOf(arr);


		CompletableFuture<Object> future4 = CompletableFuture.anyOf(arr);
		future4.join();


		for (CompletableFuture<Integer> completableFuture : arr) {
			completableFuture.cancel(true);
		}
		try {
			System.out.println(future4.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		//	future3.join();
	//	int reult= 0;
	//	for (CompletableFuture<Integer> item : arr) {
	//		try {
	//			reult+=item.get();
	//		} catch (InterruptedException e) {
	//			e.printStackTrace();
	//		} catch (ExecutionException e) {
	//			e.printStackTrace();
	//		}
	//	}
	//	System.out.println(reult);
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
