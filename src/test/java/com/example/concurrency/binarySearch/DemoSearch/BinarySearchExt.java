package com.example.concurrency.binarySearch.DemoSearch;

import java.lang.annotation.Target;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Package:com.example.concurrency.binarySearch.DemoSearch
 * *Author:ray
 * *version:...
 * *Created in 2019/5/19  23:31
 **/
public class BinarySearchExt {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 8, 8, 8, 9};
		int arr1[]={1,3,5,7,9,11};
		//System.out.println(getFirstGENum(arr1, 6));
		System.out.println(getFirstLENum(arr1,6 ));
		//int firstNum = getFirstNum(arr, 8);
		//System.out.println(firstNum);
		//System.out.println(getLastNum(arr, 8));

		SoftReference<String> sr=new SoftReference<String>(new String("java"));
		WeakReference<String> wr = new WeakReference<String>(new String("world"));
		String s = sr.get();
		System.out.println(s);
		System.out.println(wr);

	}

	//获得第一个等于查找值得索引
	private static int getFirstNum(int[] arr, int i) {
		int low = 0;
		int high = arr.length;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < i) {
				low = mid + 1;
			} else if (arr[mid] > i) {
				high = mid - 1;
			} else {
				if (mid == 0 || arr[mid - 1] != i) {
					return mid;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	//获得最后一个等于查找值的索引
	private static int getLastNum(int[] arr, int i) {
		int low = 0;
		int high = arr.length;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < i) {
				low = mid + 1;
			} else if (arr[mid] > i) {
				high = mid - 1;
			} else {
				if (mid == 0 || arr[mid + 1] != i) {
					return mid;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	//查找第一个大于等于给定值的元素
	public static int getFirstGENum(int arr[], int target) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) >>> 1);
			if (arr[mid] < target) {
				low = mid + 1;
			} else if (arr[mid] >= target) {
				if (mid==0||arr[mid - 1] < target) {
					return mid;
				} else if (arr[mid - 1] > target) {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
	public static int getFirstLENum(int arr[], int target) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) >>> 1);
			if (arr[mid] > target) {
				high = mid - 1;
			} else if (arr[mid] <= target) {
				if (mid==high||arr[mid + 1] > target) {
					return mid;
				} else if (arr[mid + 1] < target) {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}