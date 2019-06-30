package com.example.fbsLock.controller;

import com.example.fbsLock.annotation.CacheLock;
import com.example.fbsLock.annotation.CacheParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package:com.example.fbsLock.controller
 * *Author:ray
 * *version:...
 * *Created in 2019/6/19  19:21
 **/
@RestController
public class LockController {


	@CacheLock(prefix = "test")
	@GetMapping("/test")
	public String query(@RequestParam String token){


		return "success-"+token;
	}

}
