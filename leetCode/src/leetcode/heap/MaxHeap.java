package leetcode.heap;

/**
 * Package:leetcode.heap
 * *Author:ray
 * *version:...
 * *Created in 2019/10/24  23:19
 **/
public class MaxHeap<E extends Comparable> {

	private Array<E> data;

	public MaxHeap(int capacity) {
		data = new Array<>(capacity);
	}

	public MaxHeap() {
		data=new Array<>();
	}

	//返回堆中的元素个数
	public int size(){
		return  data.getSize();
	}
	//判断堆是否为空
	public boolean isEmpty(){
		return data.isEmpty();
	}

	//返回索引的父亲节点的索引
	public int parent(int index){
		if (index==0){
		    throw new IllegalArgumentException("failed!");
		}
		return (index-1)/2;
	}

	private int leftChild(int index){
		return 2*index+1;
	}

	private int rightChild(int index){
		return 2*index+2;
	}
}
