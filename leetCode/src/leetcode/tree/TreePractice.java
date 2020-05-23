package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Package:com.yjp.danamicprogress
 * *Author:ray
 * *version:...
 * *Created in 2019/10/15  20:30
 **/
public class TreePractice {

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
		//前序打印
		//printPre(root);
		//System.out.println();
		//中序打印
		//printMid(root);
		//获取最大深度
		//System.out.println(maxDepth(root));
		//获取节点个数
		//System.out.println(nodeCount(root));
		//获取子节点个数
		//System.out.println(sonNode(root));
		//迭代法遍历二叉树
		//printList(preOrder(root));
		//System.out.println();
		//printList(preOrderRecursive(root));
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

	public static void printPre(TreeNode root){
		if (root==null){
		    return;
		}
		System.out.print(root.value+"-");
		printPre(root.left);
		printPre(root.right);
	}

	public static void printMid(TreeNode root){
		if (root==null){
			return;
		}
		printMid(root.left);
		System.out.print(root.value+"-");
		printMid(root.right);
	}

	public static void printLast(TreeNode root){
		if (root==null){
			return;
		}
		printMid(root.left);
		printMid(root.right);
		System.out.print(root.value+"-");
	}
	public static int maxDepth(TreeNode root){
		if (root==null){
		    return 0;
		}
		return Math.max(maxDepth(root.left),maxDepth(root.right) )+1;
	}
	public static int nodeCount(TreeNode node){
		if (node==null){
		    return 0;
		}
		int left=nodeCount(node.left);
		int right=nodeCount(node.right);
		return left+right+1;
	}
	public static int sonNode(TreeNode root){
		if (root==null){
		    return 0;
		}
		if (root.right==null&&root.left==null){
		    return 1;
		}
		int left=sonNode(root.left);
		int right=sonNode(root.right);
		return left+right;
	}

	//打印list
	public static void printList(List list){
		list.forEach(l-> System.out.print(l+"-"));
	}

	//二叉树的前序遍历的迭代实现,借助一个栈来实现,注意push的先后位置
	public static List<Integer> preOrder(TreeNode root){
		Stack<TreeNode>  stack=new Stack<>();
		ArrayList<Integer> list=new ArrayList<>();
		if (null==root){
		    return list;
		}
		stack.push(root);
		while (!stack.empty()){
			TreeNode node = stack.pop();
			list.add(node.value);
			if (null!=node.right){
				stack.push(node.right);
			}
			if (null!=node.left){
			    stack.push(node.left);
			}
		}
		return list;
	}
	//二叉树遍历的递归实现
	public static List<Integer> preOrderRecursive(TreeNode root){
		List<Integer> list=new ArrayList<>();
		if (null==root){
		    return list;
		}
		preOrder2(root ,list);
		return list;
	}

	private static void preOrder2(TreeNode root, List<Integer> list) {
		if (null==root){
		    return;
		}
		list.add(root.value);
		preOrder2(root.left,list);
		preOrder2(root.right,list);
	}

	//二叉树的中序遍历
	public static List<Integer> midOrder(TreeNode node){
		ArrayList<Integer> list=new ArrayList<>();
		if (null==node){
		    return list;
		}
		Stack<TreeNode> stack=new Stack<>();
		stack.push(node);
		while (!stack.empty()){
			TreeNode pop = stack.pop();
			if (pop.right!=null){
			    stack.push(pop.right);
			}
		}
		return list;
	}


}
