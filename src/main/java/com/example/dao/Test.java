package com.example.dao;

import java.text.MessageFormat;
import java.time.LocalTime;

/**
 * Package:com.example.dao
 * *Author:ray
 * *version:...
 * *Created in 2019/7/8  20:43
 **/
public class Test{
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

	public static void main(String[] args) throws InterruptedException {

		LocalTime now = LocalTime.now();
		System.out.println(now.getHour());

		printMethod(1);
		int result = returnMethod(2);

		for (int i = 0; i < 10000; i++) {
			returnMethod(5);
		}

		Thread.sleep(10*100000);
	}

	private static int returnMethod(int i) {
		return i;
	}

	private static void printMethod(int i) {
		System.out.println(1);
	}
}
