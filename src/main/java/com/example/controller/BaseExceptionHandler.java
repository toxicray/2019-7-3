package com.example.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Package:com.example.controller
 * *Author:ray
 * *version:...
 * *Created in 2019/7/10  0:00
 **/
@ControllerAdvice
public class BaseExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String error(Exception e){
		return e.getMessage();
	}
}
