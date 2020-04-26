package com.pattern.behavioral.teplate;

/**
 * Package:com.pattern.behavioral.teplate
 * *Author:ray
 * *version:...
 * *Created in 2020/3/24  15:52
 **/
public abstract class Acourse {

	//钩子方法
	protected final void makeCourse(){
		this.makePPT();
		this.makeVideo();
		if(needWriteArticle()){
			this.makeArticle();
		}
		this.packageCourse();
	}

	//必须执行
	final void makePPT(){
		System.out.println("制作ppt");
	}

	final void makeVideo(){
		System.out.println("制作视频");
	}

	void makeArticle(){
		System.out.println("编写手记");
	}

	protected boolean needWriteArticle(){
		return false;
	}

	//不同的课程包装方法不一样
	abstract void packageCourse();
}
