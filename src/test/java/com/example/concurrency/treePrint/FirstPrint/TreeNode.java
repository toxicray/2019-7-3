package com.example.concurrency.treePrint.FirstPrint;

/**
 * Package:com.example.concurrency.treePrint.FirstPrint
 * *Author:ray
 * *version:...
 * *Created in 2019/5/19  22:43
 **/
public class TreeNode<T> {
	public   T data;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TreeNode{" +
				"data=" + data +
				", left=" + left +
				", right=" + right +
				'}';
	}
}
