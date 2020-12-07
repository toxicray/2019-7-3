package com.imooc.flowcontrol.countdownlatch;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Package:com.imooc.flowcontrol.countdownlatch
 * *Author:ray
 * *version:...
 * *Created in 2020/3/30  0:33
 **/
public class CountDownLatch1 {

	public static void main(String[] args) {

	}
	public static void test(){
		if (true){
			throw new Exception();
		}
	}
	public static void fail(String message) {
		if (message == null) {
			throw new Exception();
		} else {
			throw new Exception(message);
		}
	}
}
