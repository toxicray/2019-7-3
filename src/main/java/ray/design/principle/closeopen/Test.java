package ray.design.principle.closeopen;

/**
 * Package:ray.design.principle
 * *Author:ray
 * *version:...
 * *Created in 2019/8/25  22:45
 **/
public class Test {
	public static void main(String[] args) {
		Icourse course1=new JavaDisCountCourse(100,"哈哈",2.5);
		JavaDisCountCourse course=(JavaDisCountCourse)course1;
		System.out.println(course.getId()+course.getName()+course.getPrice()+course.getOriginPrice());

	}
}
