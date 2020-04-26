package com.example;

import java.util.*;

/**
 * Package:com.example
 * *Author:ray
 * *version:...
 * *Created in 2019/6/26  22:52
 **/


public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode pre = new ListNode(-1);
		ListNode cur = pre;
		while (cur != null){
			cur.next =getMinNode(lists);
			cur = cur.next;
		}
		return pre.next;
	}

	private ListNode getMinNode(ListNode[] lists) {
		ListNode temp = null;
		int index = 0;
		for (int i = 0; i < lists.length; i++) {
			if(lists[i] != null){
				if(temp == null){
					temp = lists[i];
					index = i;
				}else{
					if(temp.val > lists[i].val){
						temp = lists[i];
						index = i;
					}
				}
			}else{
				continue;
			}
		}
		ListNode temp1 = temp;
		if(temp != null){
			lists[index] = lists[index].next;
		}
		return temp1;
	}

	public static void main(String[] args) {
		ListNode node1= new ListNode(1);
		ListNode node2= new ListNode(2);
		ListNode node3= new ListNode(3);
		ListNode node4= new ListNode(4);
		ListNode node5= new ListNode(5);
		node1.next = node3;
		node2.next = node4;
		node4.next = node5;

		ListNode[] arr= new ListNode[2];
		arr[0] = node1;
		arr[1] = node2;
		ListNode node;
		Solution solution = new Solution();
		while ((node = solution.getMinNode(arr)) != null){
			System.out.println(node.val);
		}
	}
}