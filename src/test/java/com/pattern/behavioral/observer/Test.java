package com.pattern.behavioral.observer;

/**
 * Package:com.pattern.behavioral.observer
 * *Author:ray
 * *version:...
 * *Created in 2019/12/30  23:58
 **/
public class Test {
	public static void main(String[] args) {

		Course course=new Course("java设计模式精讲");
		Teacher teacher=new Teacher("Alpha");
		course.addObserver(teacher);
		Teacher teacher1=new Teacher("Beta");
		course.addObserver(teacher1);

		//业务逻辑代码
		Question question=new Question();
		question.setQuestionContent("java主函数的编写");
		question.setUserName("geely");
		course.produceQuestion(course,question );
	}
}
