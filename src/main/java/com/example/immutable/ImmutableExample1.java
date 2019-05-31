package com.example.immutable;


import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Package:com.example.immutable
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  1:03
 **/
public class ImmutableExample1 {

	private final static Integer a = 1;
	private final static String b = "2";
	private final static Map<Integer, Integer> map = Maps.newHashMap();

	static {
		map.put(1, 3);
		map.put(2, 4);

	}


	private void test(final int a) {
		//a=1;
	}

	public static void main(String[] args) {

	}


}
