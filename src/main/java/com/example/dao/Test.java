package com.example.dao;

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
}
