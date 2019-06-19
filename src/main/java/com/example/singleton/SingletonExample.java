package com.example.singleton;

/**
 * Package:com.example.singleton
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  0:23
 **/
public class SingletonExample {

	private SingletonExample(){

	}
	//单例对象
	public  static volatile SingletonExample instance=null;



	//懒汉模式,这种写法的线程是不安全的
	public static SingletonExample getInstance(){
		if (instance==null){
		    instance=new SingletonExample();
		}
		return instance;
	}



	//这种写法的问题是性能较差,每次都会有个synchronize
	public synchronized static SingletonExample getInstance1(){
		if (instance==null){
			instance=new SingletonExample();
		}
		return instance;
	}



	//1.分配内存空间
	//2,初始化对象
	//3,设定instance指向刚刚分配完的内存

	//JVM和CPU优化,发生了指令重排,将2和3的顺序进行交换,会有线程安全问题

	//双重同步锁单例模式
	public static SingletonExample getInstance2(){
		if (instance==null){
			synchronized (SingletonExample.class) {
				if (instance==null){
					instance = new SingletonExample();
				}
			}
		}
		return instance;
	}



	//将该指针标注为volatile
	//volatile +双重检测机制来让懒汉模式的线程安全




}
