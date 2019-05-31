package com.example.concurrency.treePrint.FirstPrint;

import java.util.*;

/**
 * Package:com.example.concurrency.treePrint.FirstPrint
 * *Author:ray
 * *version:...
 * *Created in 2019/5/19  22:42
 **/
public class FirstPrint {
	public static void main(String[] args) {
		TreeNode<Integer> node=new TreeNode<>(1);
		TreeNode<Integer> node1=new TreeNode<>(2);
		TreeNode<Integer> node2=new TreeNode<>(3);
		TreeNode<Integer> node3=new TreeNode<>(4);
		TreeNode<Integer> node4=new TreeNode<>(5);
		node.left=node1;
		node.right=node2;
		node.left.left=node3;
		node.left.right=node4;

		//printFirst( node);
		//List<Integer> list = preOrder(node);//12453
		//for (Integer integer : list) {
		//	System.out.println(integer);
		//}
		//中序遍历的结果42513
		//List<Integer> list = midOrder(node);
		//for (Integer integer : list) {
		//	System.out.println(integer);
		//}


		List<List<Integer>> lists = levelOrder(node);
		for (List<Integer> integers : lists) {
			for (Integer integer : integers) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}

	private static void printFirst(TreeNode<Integer> node) {
		if (node==null){
		    return;
		}
		System.out.println(node.data);
		printFirst(node.left);
		printFirst(node.right);
	}


	//先序遍历的非递归实现
	public static List<Integer> preOrder(TreeNode<Integer> node){
		Stack<TreeNode> stack=new Stack<>();
		List<Integer> list=new LinkedList<>();
		if (node==null){
		    return list;
		}
		stack.push(node);
		while (!stack.empty()){
			node=stack.pop();
			list.add(node.data);
			if (node.right!=null){
			    stack.push(node.right);
			}
			if (node.left!=null){
			    stack.push(node.left);
			}
		}
		return list;
	}
	//中序遍历的非递归实现
	public static List<Integer> midOrder(TreeNode<Integer> node ){
		Stack<TreeNode> stack=new Stack<>();
		List<Integer> list=new LinkedList<>();
		if (node==null){
		    return list;
		}
		stack.push(node);
		while (!stack.empty()){
			node=stack.pop();
			if (node.right!=null){
			    stack.push(node.right);
			}
			list.add(node.data);
			if (node.left!=null){
			    stack.push(node.left);
			}
		}
		return list;
	}


	public static List<List<Integer>> levelOrder(TreeNode<Integer> node){
		List<List<Integer>> list=new ArrayList<>();
		if (node==null){
		    return list;
		}
		Queue<TreeNode<Integer>> queue=new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()){
			int count=queue.size();
			List<Integer> list1=new ArrayList();
			while (count>0){
				TreeNode<Integer> node1=queue.poll();
				list1.add(node1.data);
				if (node1.left!=null){
				    queue.add(node1.left);
				}
				if (node1.right!=null){
				    queue.add(node1.right);
				}
				count--;
			}
			list.add(list1);
		}
		return list;
	}
}
