package com.pattern.behavioral.chainrespon;

import org.apache.commons.lang3.StringUtils;

/**
 * Package:com.pattern.behavioral.chainrespon
 * *Author:ray
 * *version:...
 * *Created in 2020/4/27  0:51
 **/
public class VideoApprover extends Approver {
	@Override
	public void deployCourse(Course course) {
		if (StringUtils.isNotEmpty(course.getVideo())) {
			System.out.println(course.getName()+"含有视频,批准!");
			if(approver != null){
				approver.deployCourse(course);
			}
		}else{
			System.out.println("不包含视频,审核拒绝");
			return;
		}
	}
}
