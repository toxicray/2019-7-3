package com.example.singleton;

/**
 * Package:com.example.singleton
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  0:44
 **/
public class SingletonExample4 {


	public SingletonExample4() {
		Singleton.INSTANCE.getInstance();
	}



	private enum Singleton{
		INSTANCE;

		private SingletonExample4 singletonExample4;


		//JVM保证这个方法只会被调用一次
		Singleton(){
			singletonExample4=new SingletonExample4();
		}
		public SingletonExample4 getInstance(){
			return  singletonExample4;
		}

	}

}
