package com.example.limit;

import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * Package:com.example.limit
 * *Author:ray
 * *version:...
 * *Created in 2019/6/28  18:27
 **/
public class TreeMapDemo {
	public static void main(String[] args) {
		TreeMap<Integer,Object> map=new TreeMap();
		Random random=new Random();
		for (int i = 0; i < 20; i++) {
			map.put(random.nextInt(100),null );
		}
		Set set = map.keySet();
		for (Object o : set) {
			System.out.println(o);
		}
	}
}
