package com.example.controller;

import com.example.util.AcccessControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Package:com.example.controller
 * *Author:ray
 * *version:...
 * *Created in 2019/6/19  13:16
 **/
@RestController
public class LimitRateController {

	@Autowired
	private AcccessControl acccessControl;

	@RequestMapping("access")
	public String testRate(){
		if (acccessControl.tryAcquire()){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
			return "success"+new Date().toString();
		}
		return "fail"+new Date().toString();
	}
}
