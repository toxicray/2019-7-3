package com.example.singleton;

/**
 * Package:com.example.singleton
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  0:27
 **/
public class SingletonExample2 {

	private SingletonExample2(){

	}
	//单例对象
	public  static SingletonExample2 instance=new SingletonExample2();



	//饿汉模式,这种写法的线程安全的,构造方法中的执行可能会使得加载较慢,而且该类一定会使用
	public static SingletonExample2 getInstance(){
		return instance;
	}



}
