package com.example.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Package:com.example.stream
 * *Author:ray
 * *version:...
 * *Created in 2019/7/10  0:06
 **/
public class Demo01 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("张无忌");
		list.add("周芷若");
		list.add("赵敏");
		list.add("张强");
		list.add("张三丰");

		list.stream().filter((e) -> {//lambda标准格式写法
			return e.startsWith("张");
		}).filter((e)->{return e.length()==3;}).forEach((e)->{
			System.out.println(e);
		});//方法调用完毕返回一个流,还可以继续调用,链式调用

		list.stream()
				.filter(s -> s.startsWith("张"))//lambda省略格式写法
				.filter(s -> s.length() == 3)
				.forEach(System.out::println);//用下方法引用
	}


}
