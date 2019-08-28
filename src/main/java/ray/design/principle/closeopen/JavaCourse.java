package ray.design.principle.closeopen;

/**
 * Package:ray.design.principle
 * *Author:ray
 * *version:...
 * *Created in 2019/8/25  22:43
 **/
public class JavaCourse implements Icourse {

	private Integer id;

	private String name;

	private Double price;

	public JavaCourse() {
	}

	public JavaCourse(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	@Override
	public Double getDisCountPrice() {
		return this.price*0.8;
	}
}
