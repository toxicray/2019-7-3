package com.example.controller;

import com.example.dao.Test;
import com.example.service.TestService;
import com.example.util.AcccessControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

	@Autowired
	private TestService testService;

	@RequestMapping("access")
	public String testRate() {
		if (acccessControl.tryAcquire()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
			return "success" + new Date().toString();
		}
		return "fail" + new Date().toString();
	}


	@GetMapping("event")
	public String testEvent() {

		testService.listener1();
		return "发布";
	}


	@GetMapping("async")
	public String testAsync() {

		try {
			return testService.sayHello() + "1";
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "出错了";
	}


	@GetMapping("async1")
	public String testAsync1() {
		try {
			Future<String> future = testService.asyncFunc();
			return future.get();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "出错了";
	}


	@GetMapping("aspect")
	public String testAspect() {
		String str1 = "参数1";
		String str2 = "参数2";
		Test test = new Test("2", "2");
		testService.testAspect("b", "a",test);
		return "请求成功!";
	}

	@PostMapping("enum")
	public String testEnum(@RequestBody Student student) {

		System.out.println(student.toString());

		return "发送json成功";
	}


}

class Student {
	private String name;
	private genderEnum gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public genderEnum getGender() {
		return gender;
	}

	public void setGender(genderEnum gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", gender=" + gender +
				'}';
	}
}

enum genderEnum {
	MALE(1), FEMALE(0);

	private Integer sex;

	private genderEnum(int sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return sex;
	}
}
