package com.pattern.behavioral.teplate;

/**
 * Package:com.pattern.behavioral.teplate
 * *Author:ray
 * *version:...
 * *Created in 2020/3/24  15:59
 **/
public class FECourse extends Acourse {

	private boolean needWrite = false;

	public FECourse(boolean needWrite) {
		this.needWrite = needWrite;
	}

	@Override
	void packageCourse() {
		System.out.println("提供图片资料");
	}

	@Override
	protected boolean needWriteArticle() {
		return  needWrite;
	}
}
