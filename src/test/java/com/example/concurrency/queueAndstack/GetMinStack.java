package com.example.concurrency.queueAndstack;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Stack;

/**
 * Package:com.example.concurrency.queueAndstack
 * *Author:ray
 * *version:...
 * *Created in 2019/5/20  22:49
 **/
public class GetMinStack {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minstack = new Stack<>();
	private static int size = 0;

	public void push(int num) {
		stack.push(num);
		if (minstack.empty() || minstack.peek() >= num) {
			minstack.push(num);
		}
		size++;
	}

	public int pop() {
		if (stack.peek() == minstack.peek()) {
			minstack.pop();
		}
		size--;
		return stack.pop();
	}

	public int getMin() {
		return minstack.peek();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	//publish void push(int num){
	//	stack.push(num);
	//	minstack.push(minstack.empty()?num:Math.min(num,minstack.peek() ));
	//}
	//publish int pop(){
	//	minstack.pop();
	//	return stack.pop();
	//}
	//
	//publish int getMin(){
	//	return minstack.peek();
	//}
	public static void main(String[] args) {
		GetMinStack stack = new GetMinStack();
		stack.push(2);
		stack.push(1);
		stack.push(3);
		stack.push(5);
		while (!stack.isEmpty()){
			System.out.println(stack.getMin());
			stack.pop();
		}
	}
}
