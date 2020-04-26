package com.imooc.cache;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Package:com.imooc.cache
 * *Author:ray
 * *version:...
 * *Created in 2020/3/26  22:21
 **/
public class ImoocCache1 {

	private final HashMap<String ,Integer> cache = new HashMap<>();


	public Integer computer(String userId){
		Integer result = cache.get(userId);
		//
		if (result == null) {
		//如果缓存中查不到数据
			try {
				result = doCompute(userId);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cache.put(userId,result);
		}
		return result;
	}


	private Integer doCompute(String userId) throws InterruptedException {
		TimeUnit.SECONDS.sleep(2000);
		return Integer.valueOf(userId);
	}

	public static void main(String[] args) {

	}
}

