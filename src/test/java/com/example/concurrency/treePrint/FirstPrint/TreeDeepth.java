package com.example.concurrency.treePrint.FirstPrint;

/**
 * Package:com.example.concurrency.treePrint.FirstPrint
 * *Author:ray
 * *version:...
 * *Created in 2019/5/22  23:13
 **/
public class TreeDeepth {
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
		System.out.println(getTreeDeepth(node));
	}
	//获取二叉树的深度
	public static int getTreeDeepth(TreeNode node){
		return node==null?0:1+(Math.max(getTreeDeepth(node.left),getTreeDeepth(node.right) ));
	}
}
