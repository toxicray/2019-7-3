package com.example.publish;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Package:com.example.publish
 * *Author:ray
 * *version:...
 * *Created in 2019/5/26  0:06
 **/
@Slf4j
public class UnsafePublish {
	private  String [] states={"a","b","c"};

	public String[] getStates(){
		return states;
	}

	/**
	 *@Description 
			* @Param 不安全的发布对象
			* @return 
			**/
	public static void main(String[] args) {

	}
}
