package com.example.concurrency.queueAndstack;

import javax.xml.soap.Node;
import java.util.Stack;

/**
 * Package:com.example.concurrency.queueAndstack
 * *Author:ray
 * *version:...
 * *Created in 2019/5/20  22:41
 **/
public class Stack2Queue {

	Stack<Integer> in=new Stack<>();
	Stack<Integer> out=new Stack<>();


	public void push(int num){
		in.push(num);
	}

	public int pop() throws Exception {
		if (out.empty()){
		    while (!in.empty()){
		    	out.push(in.pop());
			}
		}
		if (out.empty()){
		    throw new Exception("queue is empty!");
		}
		return out.pop();
	}
	public static void main(String[] args) {
	    Stack2Queue queue=new Stack2Queue();
	    queue.push(1);
	    queue.push(2);
	    queue.push(3);
	    queue.push(4);
		for (int i = 0; i < 4; i++) {
			try {
				System.out.println(queue.pop());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
