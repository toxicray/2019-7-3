
package com.example.concurrency.javalock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Package:com.example.concurrency.javalock
 * *Author:ray
 * *version:...
 * *Created in 2020/1/8  22:54
 **/
public class Lock01 {

	//读写锁,允许多个线程同时读变量
	//仅仅允许一个线程写变量
	//写变量的时候不允许读变量

	private static final ReadWriteLock rwl=new ReentrantReadWriteLock();

	public static void main(String[] args) {
		Lock lock = rwl.readLock();
		Lock lock1 = rwl.writeLock();
	}
}
