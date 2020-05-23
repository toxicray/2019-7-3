package com.pattern.behavioral.chainrespon;

/**
 * Package:com.pattern.behavioral.chainrespon
 * *Author:ray
 * *version:...
 * *Created in 2020/4/27  0:58
 **/
public class Test {
	public static void main(String[] args) {
		ArticleApprover articleApprover = new ArticleApprover();
		VideoApprover videoApprover = new VideoApprover();
		Course course = new Course();
		course.setName("java");
		course.setArticle("java设计模式手记");
		course.setVideo("java设计模式视频");

		articleApprover.setNexrApprover(videoApprover);
		articleApprover.deployCourse(course);
	}
}
