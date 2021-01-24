package com.zjf.algorithm.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * description: Offer57 <br>
 * date: 2021/1/21 18:52 <br>
 * author: 张建峰 <br>
 */
public class Offer59_1 {

	/**
	 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
	 *
	 * 示例:
	 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
	 * 输出: [3,3,5,5,6,7]
	 * 解释:
	 *   滑动窗口的位置                最大值
	 * ---------------               -----
	 * [1  3  -1] -3  5  3  6  7       3
	 *  1 [3  -1  -3] 5  3  6  7       3
	 *  1  3 [-1  -3  5] 3  6  7       5
	 *  1  3  -1 [-3  5  3] 6  7       5
	 *  1  3  -1  -3 [5  3  6] 7       6
	 *  1  3  -1  -3  5 [3  6  7]      7
	 *  
	 * 提示：
	 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
	*/
	/**
	 * 口对应的数据结构为 双端队列 ，本题使用 单调队列 即可解决以上问题。遍历数组时，每轮保证单调队列 dequedeque ：
	 *
	 * dequedeque 内 仅包含窗口内的元素 \Rightarrow⇒ 每轮窗口滑动移除了元素 nums[i - 1]nums[i−1] ，需将 dequedeque 内的对应元素一起删除。
	 * dequedeque 内的元素 非严格递减 \Rightarrow⇒ 每轮窗口滑动添加了元素 nums[j + 1]nums[j+1] ，需将 dequedeque 内所有 < nums[j + 1]<nums[j+1]
	 * 的元素删除。
	 * 算法流程：
	 * 初始化： 双端队列 dequedeque ，结果列表 resres ，数组长度 nn ；
	 * 滑动窗口： 左边界范围 i \in [1 - k, n + 1 - k]i∈[1−k,n+1−k] ，右边界范围 j \in [0, n - 1]j∈[0,n−1] ；
	 * 若 i > 0i>0 且 队首元素 deque[0]deque[0] == 被删除元素 nums[i - 1]nums[i−1] ：则队首元素出队；
	 * 删除 dequedeque 内所有 < nums[j]<nums[j] 的元素，以保持 dequedeque 递减；
	 * 将 nums[j]nums[j] 添加至 dequedeque 尾部；
	 * 若已形成窗口（即 i \geq 0i≥0 ）：将窗口最大值（即队首元素 deque[0]deque[0] ）添加至列表 resres 。
	 * 返回值： 返回结果列表 resres 。
	 *
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0 || k == 0) {
			return new int[0];
		}
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
			if(i > 0 && deque.peekFirst() == nums[i - 1]) {
				deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
			}
			while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
				deque.removeLast(); // 保持 deque 递减
			}
			deque.addLast(nums[j]);
			if(i >= 0) {
				res[i] = deque.peekFirst();  // 记录窗口最大值
			}
		}
		return res;
	}
}
