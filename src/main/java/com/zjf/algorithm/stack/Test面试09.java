package com.zjf.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Test面试09 {

	class CQueue {

		Stack<Integer> tail ;
		Stack<Integer> head;
		int size;
		public CQueue() {
			tail = new Stack<Integer>();
			head = new Stack<Integer>();
			size = 0;
		}

		public void appendTail(int value) {
			tail.push(value);
			size++;
		}

		public int deleteHead() {
			if (size == 0){
				return -1;
			}
			for (int i = 0; i < size-1; i++) {
				Integer val = tail.pop();
				head.push(val);
			}
			int ret = tail.pop();
			size--;
			for (int i = 0; i < size; i++){
				Integer val = head.pop();
				tail.push(val);
			}
			return ret;
		}
	}

	class CQueue1 {

		Stack<Integer> stack1 ; //用来添加
		Stack<Integer> stack2; //用来删除
		public CQueue1() {
			stack1 = new Stack<Integer>();
			stack2 = new Stack<Integer>();
		}

		public void appendTail(int value) {
			stack1.push(value);
		}

		public int deleteHead() {
			if (stack1.isEmpty() && stack2.isEmpty()) {
				return -1;
			}
			if (!stack2.isEmpty()) {
				return stack2.pop();
			} else {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
				return stack2.pop();
			}
		}
	}
}
