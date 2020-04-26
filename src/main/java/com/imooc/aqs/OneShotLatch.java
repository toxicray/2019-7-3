package com.imooc.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Package:com.imooc.aqs
 * *Author:ray
 * *version:...
 * *Created in 2020/3/26  21:43
 **/
public class OneShotLatch {

	private final Sync sync  = new Sync();

	public void await(){
		sync.acquireShared(0);
	}

	public void signal(){

		sync.releaseShared(0);
	}

	private class Sync extends AbstractQueuedSynchronizer{
		@Override
		protected int tryAcquireShared(int arg) {
			//如果是-1   那么就会加入到阻塞队列
			return (getState() == 1) ? 1:-1;
		}

		//开闸  将state改为1,取消阻塞
		@Override
		protected boolean tryReleaseShared(int arg) {
			setState(1);
			return true;
		}
	}

	public static void main(String[] args) throws InterruptedException {

		//OneShotLatch latch = new OneShotLatch();
		//for (int i = 0; i < 10; i++) {
		//	new Thread(()->{
		//		System.out.println(Thread.currentThread().getName()+"获取latch,失败就等待");
		//		latch.await();
		//		System.out.println(Thread.currentThread().getName()+"获取latch成功");
		//	}).start();
		//}
		//Thread.sleep(5000L);
		//latch.signal();


		OneShotLatch oneShotLatch = new OneShotLatch();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"尝试获取latch，获取失败那就等待");
					oneShotLatch.await();
					System.out.println("开闸放行"+Thread.currentThread().getName()+"继续运行");
				}
			}).start();
		}
		Thread.sleep(5000);
		oneShotLatch.signal();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"尝试获取latch，获取失败那就等待");
				oneShotLatch.await();
				System.out.println("开闸放行"+Thread.currentThread().getName()+"继续运行");
			}
		}).start();
	}

}
