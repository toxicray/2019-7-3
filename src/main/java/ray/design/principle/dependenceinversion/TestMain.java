package ray.design.principle.dependenceinversion;

/**
 * Package:ray.design.principle.dependenceinversion
 * *Author:ray
 * *version:...
 * *Created in 2019/8/28  0:02
 **/






/**
 *@Description   面向实现来编程,也可以使用接口来处理,可以符合开闭原则
		* @return
		**/


//高层次的模块   抽象的架构会比较稳定,这样能提高代码结构的稳定性
	//类似还有spring的依赖注入和控制反转
public class TestMain {
	public static void main(String[] args) {

		Geely geely=new Geely(new JavaCourse());
		geely.study(new JavaCourse());
	}
}
