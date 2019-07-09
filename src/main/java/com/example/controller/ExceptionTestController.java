package com.example.controller;

import com.example.exception.ValidateException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package:com.example.controller
 * *Author:ray
 * *version:...
 * *Created in 2019/7/9  23:55
 **/
@RestController
public class ExceptionTestController {

	@GetMapping("ext1")
	public String testException(){

		int i=10/0;
		return "请求层";

	}


	@GetMapping("ext2")
	public String testException1(){
		if (true){
			throw new ValidateException("数据格式错误");

		}
		return "抛出异常";
	}



}
