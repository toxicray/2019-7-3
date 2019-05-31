package com.example.concurrency.day01;

/**
 * Package:com.example.concurrency.day01
 * *Author:ray
 * *version:...
 * *Created in 2019/5/14  23:47
 **/
public class MyThread extends Thread {

	private static int num=5;


	@Override
	public synchronized void run() {
		num--;
		System.out.println(Thread.currentThread().getName()+": "+num);
	}
	public static void main(String[] args) {
	    MyThread thread=new MyThread();
		Thread thread1=new Thread(thread,"t1");
		Thread thread2=new Thread(thread,"t2");
		Thread thread3=new Thread(thread,"t3");
		Thread thread4=new Thread(thread,"t4");
		Thread thread5=new Thread(thread,"t5");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
