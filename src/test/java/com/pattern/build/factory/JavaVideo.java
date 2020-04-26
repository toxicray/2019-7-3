package com.pattern.build.factory;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Package:com.pattern.build.factory
 * *Author:ray
 * *version:...
 * *Created in 2020/3/24  19:14
 **/
public class JavaVideo extends Video {
	@Override
	public void produce() {
		System.out.println("java 视频");
		ConcurrentSkipListMap map  = new ConcurrentSkipListMap();
	}
}
