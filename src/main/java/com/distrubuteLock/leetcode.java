package com.distrubuteLock;

/**
 * Package:com.distrubuteLock
 * *Author:ray
 * *version:...
 * *Created in 2019/10/7  10:01
 **/
public class leetcode {


	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}


	public static void main(String[] args) {
		ListNode headA=new ListNode(1);
		ListNode headB=new ListNode(2);
		ListNode node=getIntersectionListNode(headA,headB);



	}

	private static ListNode getIntersectionListNode(ListNode headA, ListNode headB) {
		if (headA==null||headB==null){
		    return null;
		}
		ListNode pA=headA,pB=headB;
		while (pA!=pB){
			pA=pA==null?headB: pA.next;
			pB=pB==null?headA: pB.next;
		}
		return pA;
	}
}
