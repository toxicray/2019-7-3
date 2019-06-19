package com.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Package:com.example.immutable
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  1:16
 **/
public class Unmodeified {



	private final static List <Integer> list= ImmutableList.of(1,2,3);
	private final static ImmutableSet<Integer> set= ImmutableSet.copyOf(list);

	public static void main(String[] args) {


		//Map map=new HashMap<>();
		//map.put(1,2 );
		//map = Collections.unmodifiableMap(map);
		//map.put(2,4 );
		//System.out.println(map.size());
		list.add(4);
	}

}
