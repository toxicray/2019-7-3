package com.example;

import java.util.*;

/**
 * Package:com.example
 * *Author:ray
 * *version:...
 * *Created in 2019/6/26  22:52
 **/
public class trySet {

	public static void main(String[] args) {


		//List list=new LinkedList<User>();
		//User user1=new User("1","2");
		//User user2=new User("1","2");
		//list.add(user1);
		//list.add(user2);
		//Set set=new HashSet(list);
		//for (Object o : set) {
		//	System.out.println(o.toString());
		//}
		char a = "h".charAt(0);
		char b = "e".charAt(0);
		System.out.println(a ^ b);
		int number = a ^ b;
		int sum;
		String result = "";
		for (int i = number; i >= 1; i = i / 2) {
			if (i % 2 == 0) {
				sum = 0;
			} else {
				sum = 1;
			}
			result = sum + result;
		}
		System.out.println(result);
	}
}


class User {
	private String name;
	private String hobby;

	public User(String name, String hobby) {
		this.name = name;
		this.hobby = hobby;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(name, user.name) &&
				Objects.equals(hobby, user.hobby);
	}

	@Override
	public int hashCode() {

		return Objects.hash(name, hobby);
	}
}