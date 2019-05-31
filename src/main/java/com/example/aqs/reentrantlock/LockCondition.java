package com.example.aqs.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Package:com.example.aqs.reentrantlock
 * *Author:ray
 * *version:...
 * *Created in 2019/5/27  0:51
 **/
@Slf4j
public class LockCondition {
	public static void main(String[] args) {
		ReentrantLock reentrantLock=new ReentrantLock();
		Condition condition = reentrantLock.newCondition();

		new Thread(()->{
			try {
			    reentrantLock.lock();
			    log.info("wait signal" );//1,等待信号
			    condition.await();
			} catch(Exception e) {
			    e.printStackTrace();
			}
			log.info("get signal" );//4
			reentrantLock.unlock();
		}).start();
		new Thread(()->{
			reentrantLock.lock();
			log.info("get lock" );//2
			try {
			    Thread.sleep(3000);
			} catch(Exception e) {
			    e.printStackTrace();
			}
			condition.signalAll();
			log.info("send signal ~" );//3
			reentrantLock.unlock();
		}).start();
	}
}
