package com.example.concurrency.binarySearch.DemoSearch;




/**
 * Package:com.example.concurrency.binarySearch.DemoSearch
 * *Author:ray
 * *version:...
 * *Created in 2019/5/19  23:07
 **/
public class BinarySearch {
	public static void main(String[] args) {

		int arr[]={1,2,3,4,5,6,7,8,9};
		int target=5;
		//int index=searchNum(arr,target);
		System.out.println(binarySearchDG(arr,0 ,arr.length-1 , 5));


	}

	private static int searchNum(int[] arr, int target) {
		int min=0;
		int max=arr.length-1;
		int mid;
		while(min<=max){

			//mid=min+(max-min)/2;
			mid=min+((max-min)>>>1);
			//这个地方可以防止越界
			mid=(min+max)/2;
			if (arr[mid]<target){
			    min=mid+1;
			}else if(arr[mid]>target) {
			    max=mid-1;
			}else {
				return mid;
			}
		}
		return -1;
	}

	//二分查找的的递归实现
	public static int binarySearchDG(int[]arr,int low,int high,int target ){
		if (low<=high){
			int mid=low+((high-low)>>>1);
		    if (arr[mid]<target){
		        binarySearchDG(arr,mid+1 ,high ,target );
		    }else if (arr[mid]>target){
		        binarySearchDG(arr,low  ,mid-1 ,target );
		    }else {
		 		return mid;
		    }
		}
		return -1;
	}
	//二分查找法的变种



}
