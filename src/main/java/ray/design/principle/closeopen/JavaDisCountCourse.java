package ray.design.principle.closeopen;

/**
 * Package:ray.design.principle
 * *Author:ray
 * *version:...
 * *Created in 2019/8/25  22:49
 **/
public class JavaDisCountCourse extends JavaCourse {

	public JavaDisCountCourse(Integer id, String name, Double price) {
		super(id, name, price);
	}

	public Double getOriginPrice(){
		return super.getPrice();
	}


	@Override
	public Double getPrice(){
		return super.getPrice()*0.8;
	}

}
