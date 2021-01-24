package com.zjf.algorithm.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * description: Offer57_2 <br>
 * date: 2021/1/21 19:03 <br>
 * author: 张建峰 <br>
 */
public class Offer59_2 {

	/**
	 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
	 * 若队列为空，pop_front 和 max_value 需要返回 -1
	 * 示例 1：
	 * 输入:
	 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
	 * [[],[1],[2],[],[],[]]
	 * 输出: [null,null,null,2,1,2]
	 * 示例 2：
	 * 输入:
	 * ["MaxQueue","pop_front","max_value"]
	 * [[],[],[]]
	 * 输出: [null,-1,-1]
	*/
	class MaxQueue {

		Queue<Integer> q;
		Deque<Integer> d; //单调递增的双端队列保存最大值

		public MaxQueue() {
			q = new LinkedList<Integer>();
			d = new LinkedList<Integer>();
		}

		public int max_value() {
			if (d.isEmpty()) {
				return -1;
			}
			return d.peekFirst();
		}

		public void push_back(int value) {
			while (!d.isEmpty() && d.peekLast() < value) {
				d.pollLast();
			}
			d.offerLast(value);
			q.offer(value);
		}
		//删除的如若跟最大值一样,同时删除最大值
		public int pop_front() {
			if (q.isEmpty()) {
				return -1;
			}
			int ans = q.poll();
			if (ans == d.peekFirst()) {
				d.pollFirst();
			}
			return ans;
		}
	}
}
