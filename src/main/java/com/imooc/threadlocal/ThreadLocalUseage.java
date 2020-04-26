package com.imooc.threadlocal;

/**
 * Package:com.imooc.threadlocal
 * *Author:ray
 * *version:...
 * *Created in 2020/3/25  22:55
 **/
public class ThreadLocalUseage {
}




class ThreadLocalDemo{
	static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

	ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return Integer.valueOf(2);
		}
	};

	ThreadLocal<Integer> threadLocal1 = ThreadLocal.withInitial(()->Integer.valueOf(3));
}
