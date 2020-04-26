package com.pattern.behavioral.teplate;

/**
 * Package:com.pattern.behavioral.teplate
 * *Author:ray
 * *version:...
 * *Created in 2020/3/24  15:37
 **/
public class MainTest {
	public static void main(String[] args) {
		//一次性实现一个算法的不变的部分,并将可变的行为留给子类来实现

		//各子类中公共的行为被提取出来,并集中到一个公共的父类中.从而避免代码重复

		//好处   提高了扩展性,提高了复用性,符合开闭原则

		//缺点  类数目的增加 增加了实现的复杂度,继承的缺点

		//钩子方法    关键的时刻可以去扩展

		//模板方法和观察方法   策略模式的区别

		Acourse acourse = new PatternDesign();
		acourse.makeCourse();
		Acourse b = new FECourse(true);
		b.makeCourse();


	}
}
