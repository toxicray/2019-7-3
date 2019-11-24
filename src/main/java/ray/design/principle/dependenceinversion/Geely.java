package ray.design.principle.dependenceinversion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Package:ray.design.principle.dependenceinversion
 * *Author:ray
 * *version:...
 * *Created in 2019/8/27  23:39
 **/
public class Geely {

	Icourse icourse;

	/**
	 * @return
	 * @Description
	 * @Param 构造器来注入数据
	 **/
	public Geely(Icourse icourse) {
		this.icourse = icourse;
	}

	public void study(Icourse icourse) {
		icourse.study();
	}


	private static int[] mergeArr(int[] arr1, int[] arr2) {
		List result = new LinkedList<Integer>();

		List<Integer> list = mergeToList(arr1, arr2);
		return null;

	}

	private static List<Integer> mergeToList(int[] arr1, int[] arr2) {
		if (arr1.length == 0) {
		}
		for (int i = 0; i < 5; i++) {

		}

		return null;
	}

	public static int climbStairs(int n) {

		if (n == 1 || n == 2) {
			return n;
		}
		int temp = 0;
		int a = 1;
		int b = 2;
		for (int i = 2; i < n; i++) {
			temp = a;
			a = b;
			b = a + temp;
		}
		return b;
	}

	public static void main(String[] args) {
		int [] arr=new int[]{2,7,9,3,1};
		System.out.println(rob(arr));
	}

	public static int rob(int[] nums) {

		int num=maxRob(nums,0,nums.length-1);
		return num;
	}

	private static int maxRob(int[] nums, int start, int end) {
		if(end==2){
			return nums[0]+nums[1];
		}
		if(end==1){
			return nums[0];
		}
		if (nums.length>2){
			return Math.max(maxRob(nums, 0,end-1 ), maxRob(nums, 0,end-2 )+nums[end]);
		}
		return 0;
	}


}
