package leetcode.heap;

/**
 * Package:leetcode.heap
 * *Author:ray
 * *version:...
 * *Created in 2019/10/23  23:04
 **/
public class Array<E> {

	private E[] data;

	private int size;

	//初始化一个数组
	public Array(int capacity) {
		data=(E[])new Object[capacity];
		size=0;
	}

	public Array() {
		this(10);
	}

	//获取数组的容量
	public int getCapacity(){
		return data.length;
	}

	//获取数组中的元素个数
	public int getSize(){
		return size;
	}

	//判断是否为空
	public boolean isEmpty(){
		return size==0;
	}

	//添加元素到某个位置
	public void add(int index,E e){
		if (index<0||index>this.getCapacity()){
		    throw new IllegalArgumentException("Add Failed");
		}
		if (size==data.length){
		    resize(2*data.length);
		}
		for (int i = size - 1; i > index; i--) {
			data[i+1]=data[i];
		}
		data[index]=e;
		size++;
	}

	//向所有元素后添加一个新的元素
	public void addLast(E e){
		add(size,e );
	}

	public void addFirst(E e){
		add(0,e );
	}

	//获取index索引位置的元素
	public E get(int index){
		if (index<0||index>=size){
		    throw new IllegalArgumentException("Failed,out of index");
		}
		return data[index];
	}

	//修改对应位置的元素
	public void set(E e,int index){
		if (index<0||index>=size){
			throw new IllegalArgumentException("Failed,out of index");
		}
		data[index]=e;
	}

	//查找数组中是否已拥有某个元素
	public boolean contains(E e){
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)){
			    return true;
			}
		}
		return false;
	}
	//查找元素e在数组中的位置
	public int find(E e){
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)){
			    return i;
			}
		}
		return -1;
	}

	// 从数组中删除index位置的元素, 返回删除的元素
	public E remove(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Remove failed. Index is illegal.");

		E ret = data[index];
		for(int i = index + 1 ; i < size ; i ++)
			data[i - 1] = data[i];
		size --;
		data[size] = null; // loitering objects != memory leak

		if(size == data.length / 4 && data.length / 2 != 0)
			resize(data.length / 2);
		return ret;
	}

	// 从数组中删除第一个元素, 返回删除的元素
	public E removeFirst(){
		return remove(0);
	}

	// 从数组中删除最后一个元素, 返回删除的元素
	public E removeLast(){
		return remove(size - 1);
	}

	// 从数组中删除元素e
	public void removeElement(E e){
		int index = find(e);
		if(index != -1)
			remove(index);
	}

	private void resize(int newCapacity){
		E[] newData=(E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i]=data[i];
		}
		data=newData;
	}

}
