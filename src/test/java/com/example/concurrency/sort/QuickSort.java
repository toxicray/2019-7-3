package com.example.concurrency.sort;

import java.util.Arrays;

/**
 * Package:com.example.concurrency.sort
 * *Author:ray
 * *version:...
 * *Created in 2019/6/20  0:10
 **/
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 4, 5, 7, 6, 1, 9, 9, 7, 4};
		System.out.println(Arrays.toString(arr));
		quickSort_2(arr,0,11);
		System.out.println(Arrays.toString(arr));


	}

	public static void quickSort_2(int[] data, int start, int end) {
		if (data == null || start >= end) {
			return;
		}
		int i = start, j = end;
		int pivotKey = data[start];
		while (i < j) {
			//指针左移
			while (i < j && data[j] >= pivotKey) {
				j--;
			}
			//指针右移
			while (i < j && data[i] <= pivotKey) {
				i++;
			}

			if (i < j) {
				int swap = data[i];
				data[i] = data[j];
				data[j] = swap;
			}
		}
		//交换pivotKey
		pivotKey = data[i];
		data[i] = data[start];
		data[start] = pivotKey;
		quickSort_2(data, start, i - 1);
		quickSort_2(data, i + 1, end);
	}
}
