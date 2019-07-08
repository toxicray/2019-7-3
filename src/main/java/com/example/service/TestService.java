package com.example.service;

import com.example.annodemo.Anno1;
import com.example.event.EventTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Package:com.example.service
 * *Author:ray
 * *version:...
 * *Created in 2019/7/2  22:55
 **/
@Service
public class TestService {


	@Autowired
	private ApplicationContext applicationContext;


	@Async
	public void listener1(){
		applicationContext.publishEvent(new EventTest(new Test("2","2")));
	}


	@Async
	public String sayHello() throws InterruptedException {

		Thread.sleep(2000);
		return "我爱你呀!";
	}

	@Async
	public Future<String> asyncFunc() throws InterruptedException {
		int thinking = 2;
		Thread.sleep(thinking * 1000);
		System.out.println("async!");
		return new AsyncResult<String>("发送消息用了" + thinking + "秒");
	}




	@Anno1
	public void testAspect(String str1, String str2) {

		System.out.println("service层执行了:"+str1+"-----"+str2);
	}
}
class Test{
	private String code;
	private String score;

	public Test(String code, String score) {
		this.code = code;
		this.score = score;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Test{" +
				"code='" + code + '\'' +
				", score='" + score + '\'' +
				'}';
	}
}
