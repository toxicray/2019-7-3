package com.example.concurrency.list;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Package:com.example.concurrency.list
 * *Author:ray
 * *version:...
 * *Created in 2019/5/20  23:10
 **/
public class MyList {
	public static void main(String[] args) {
		ListNode<Integer> node=new ListNode<>(1);
		node.next=new ListNode<Integer>(2);
		node.next.next=new ListNode<Integer>(3);
		node.next.next.next=new ListNode<Integer>(4);
		node.next.next.next.next=new ListNode<Integer>(5);
		node.next.next.next.next.next=new ListNode<Integer>(6);
		int result=getNumK(node,3);
		System.out.println(result);
		System.out.println(GetKnode(node,3 ));
	}

	private static int getNumK(ListNode<Integer> node,int num) {
		int length=getLength(node);
		if (num> length){
		    return -1;
		}
		for (int i = 0; i < length - num; i++) {
			node=node.next;
		}
		return node.data;
	}

	private static int getLength(ListNode<Integer> node) {
		int length=0;
		while (node!=null){
			node=node.next;
			length++;
		}
		return length;
	}

	//递归的方法来获取倒数第K个节点


	public static ListNode<Integer> GetKnode(ListNode<Integer> node,int k){
		if (node==null){
		    return null;
		}
		ListNode listNode = GetKnode(node.next, k);
		if (listNode!=null){
		    return listNode;
		}else {
		    k--;
		    if (k==0){
		        return listNode;
		    }
		    return null;
		}
	}
}
