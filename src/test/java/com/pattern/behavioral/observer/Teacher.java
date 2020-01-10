package com.pattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Package:com.pattern.behavioral.observer
 * *Author:ray
 * *version:...
 * *Created in 2019/12/30  23:47
 **/
public class Teacher implements Observer {

	private String teacherName;

	public Teacher(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public void update(Observable o, Object arg) {
		Course course=(Course) o;
		Question question= (Question) arg;
		System.out.println(teacherName+":..."+course.getCourseName()+"---"+question.getUserName());
	}
}
