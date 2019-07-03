package com.example.enumPractice;

/**
 * Package:com.example.enumPractice
 * *Author:ray
 * *version:...
 * *Created in 2019/7/2  23:50
 **/
public enum SeasonEnum {
	SPRING("春天"),SUMMER("夏天"),FALL("秋天"),WINTER("冬天");

	private final String name;

	private SeasonEnum(String name)
	{
		this.name = name;
	}

	public String getName() {
		return name;
	}
}