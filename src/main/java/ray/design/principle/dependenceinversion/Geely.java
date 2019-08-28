package ray.design.principle.dependenceinversion;

/**
 * Package:ray.design.principle.dependenceinversion
 * *Author:ray
 * *version:...
 * *Created in 2019/8/27  23:39
 **/
public class Geely {

	Icourse icourse;
	/**
	 *@Description
			* @Param 构造器来注入数据
			* @return
			**/
	public Geely(Icourse icourse) {
		this.icourse = icourse;
	}

	public void study(Icourse icourse){
		icourse.study();
	}

}
