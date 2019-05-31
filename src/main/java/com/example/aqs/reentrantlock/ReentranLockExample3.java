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

/**
 * Package:com.example.aqs.reentrantlock
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  23:40
 **/
@Slf4j
public class ReentranLockExample3 {

	private final Map<String,Data> map=new TreeMap<>();

	private final static ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

	private final static Lock readlock=lock.readLock();

	private final static Lock writelock=lock.writeLock();

	public Data get(String key){
		readlock.lock();
		try {
			return map.get(key);
		}finally {
			readlock.unlock();
		}
	}

	public Set<String> getAllKeys(){
		readlock.lock();
		try {
		    return map.keySet();
		} finally {
			readlock.unlock();
		}
	}


	public Data put(String key,Data value){
		writelock.lock();
		try {
		    return map.put(key,value );
		} finally {
			writelock.unlock();
		}
	}



	class Data{

	}


}
