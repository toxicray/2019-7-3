package com.example.guava;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

/**
 * Package:com.example.guava
 * *Author:ray
 * *version:...
 * *Created in 2019/7/22  23:13
 **/
public class TestList {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		List<List<Integer>> lists = Lists.partition(list, 30);
		for (List<Integer> integers : lists) {
			for (Integer integer : integers) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}


	}


}
