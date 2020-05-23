package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Package:com.test
 * *Author:ray
 * *version:...
 * *Created in 2020/4/27  11:09
 **/
public class RayArthas {
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		List list1 = (List)list.clone();
		list1.add(3);
		list1.forEach(v->{
			System.out.println(v);
		});
		list.forEach(v->{
			System.out.println(v);
		});
	}

	private static String getNum(int i) {
		String s = String.valueOf(i);
		return s;
	}
}
