package com.example.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Package:com.example.concurrency.controller
 * *Author:ray
 * *version:...
 * *Created in 2019/5/15  0:12
 **/
@Controller
@Slf4j
public class TestController {


	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "test";
	}

}
