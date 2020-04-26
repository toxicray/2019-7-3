package com.pattern.behavioral.teplate;

/**
 * Package:com.pattern.behavioral.teplate
 * *Author:ray
 * *version:...
 * *Created in 2020/3/24  15:58
 **/
public class PatternDesign extends Acourse {
	@Override
	void packageCourse() {
		System.out.println("提供java源代码");
	}

	@Override
	protected boolean needWriteArticle() {

		return true;
	}
}
