package com.zjf.algorithm.offer;

import org.checkerframework.checker.units.qual.A;

import java.util.Stack;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-17 22:53  //时间
 */
public class Offer30 {


	/**
	 * 义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
	 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
	 *
	 * 示例:
	 * MinStack minStack = new MinStack();
	 * minStack.push(-2);
	 * minStack.push(0);
	 * minStack.push(-3);
	 * minStack.min();   --> 返回 -3.
	 * minStack.pop();
	 * minStack.top();      --> 返回 0.
	 * minStack.min();   --> 返回 -2.
	 *
	 * 提示：
	 * 各函数的调用总次数不超过 20000 次
	 */
	class MinStack {


		Stack<Integer> A;
		Stack<Integer> B;
		/** initialize your data structure here. */
		public MinStack() {
			A = new Stack<>();
			B = new Stack<>();
		}

		public void push(int x) {
			A.push(x);
			if (B.empty() || B.peek() >= x){
				B.push(x);
			}
		}

		public void pop() {
			if (A.pop().equals(B.peek())){
				B.pop();
			}
		}

		public int top() {
			return A.peek();
		}

		public int min() {
			return B.peek();
		}
	}


}
