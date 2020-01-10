package com.pattern.behavioral.observer;

import java.util.Observable;

/**
 * Package:com.pattern.behavioral.observer
 * *Author:ray
 * *version:...
 * *Created in 2019/12/30  23:49
 **/
public class Course extends Observable {

	private String courseName;

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void produceQuestion(Course course,Question question){
		System.out.println(question.getUserName()+"在"+course.getCourseName());
		setChanged();
		notifyObservers(question);
	}
}
