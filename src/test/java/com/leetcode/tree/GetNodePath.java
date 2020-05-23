package com.leetcode.tree;

import com.sun.corba.se.spi.ior.IORTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.leetcode.tree.ConstructAndTravel.printList;

/**
 * Package:com.leetcode.tree
 * *Author:ray
 * *version:...
 * *Created in 2020/5/11  0:11
 **/
public class GetNodePath {


	static List<List<Integer>> result = new ArrayList<>();

	static ArrayList<Integer> list = new ArrayList<>();

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return null;
	}

	static class TreeNode{

		Integer value;

		TreeNode left;

		TreeNode right;

		public TreeNode(Integer value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
		TreeNode root=constructTree(arr,0,arr.length-1);
		List<List<Integer>> lists = getAllPath(root);
		lists.forEach(item ->{
			printList(item);
		});

	}

	private static TreeNode constructTree(int[] arr, int start, int end) {
		if(start>end){
			return null;
		}
		int mid=(start+end)>>1;
		TreeNode node=new TreeNode(arr[mid]);
		node.left=constructTree(arr, start,mid-1 );
		node.right=constructTree(arr, mid+1,end );
		return node;
	}

	public static List<List<Integer>> getAllPath(TreeNode root){
		if(root != null){
			list.add(root.value);
			if(root.left == null && root.right == null){
				List newList = (List)list.clone();
				list.clear();
				result.add(newList);
			}else{
				getAllPath(root.left);
				getAllPath(root.right);
			}
		}
		return result;
	}
}
