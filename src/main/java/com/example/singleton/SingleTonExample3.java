package com.example.singleton;

/**
 * Package:com.example.singleton
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  0:40
 **/
public class SingleTonExample3 {
	//单例对象
	public  static SingleTonExample3 instance=null;

	static {
		instance=new SingleTonExample3();
	}




	//饿汉模式,这种写法的线程安全的,构造方法中的执行可能会使得加载较慢,而且该类一定会使用
	public static SingleTonExample3 getInstance(){
		return instance;
	}
	public static void main(String[] args) {
		System.out.println(SingleTonExample3.getInstance().hashCode());
	}
	//静态域和静态代码的顺序


}
