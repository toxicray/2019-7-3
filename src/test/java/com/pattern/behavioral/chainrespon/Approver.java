package com.pattern.behavioral.chainrespon;

/**
 * Package:com.pattern.behavioral.chainrespon
 * *Author:ray
 * *version:...
 * *Created in 2020/4/27  0:47
 **/
public abstract class Approver {

	//批准者类型里面添加批准者,让子类获取到
	protected Approver approver;

	public void setNexrApprover(Approver approver){
		this.approver = approver;
	}

	public abstract void deployCourse(Course course);

}
