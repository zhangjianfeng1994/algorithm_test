package com.zjf.algorithm.stack;

import java.lang.reflect.Array;
import java.util.*;

public class Test面试59 {

	/**
	 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
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
	 * 提示：
	 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0){
			return new int[0];
		}
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(Integer.MIN_VALUE);
		int[] res = new int[nums.length-k+1];
		for (int i = 0; i < nums.length-k+1; i++) {
			for (int j = i+k-1; j >i; j--) {
				int max = stack.pop();
				int num = nums[j];
				max = Math.max(max,num);
				stack.push(max);
			}
			res[i] = Math.max(stack.peek(),nums[i]);
		}
		return res;
	}

	public int[] maxSlidingWindow1(int[] nums, int k) {
		Deque<Integer> max = new ArrayDeque<Integer>();
		int n = nums.length;
		if (n == 0) {
			return nums;
		}
		int result[] = new int[n - k + 1];
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (i >= k) {
				if (max.peekFirst() == nums[i - k]) {
					max.removeFirst();
				}
			}
			while (!max.isEmpty() && nums[i] > max.peekLast()) {
				max.removeLast();
			}

			max.addLast(nums[i]);
			if (i >= k - 1) {
				result[index++] = max.peekFirst();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Test面试59 test = new Test面试59();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		System.out.println(Arrays.toString(test.maxSlidingWindow(nums,3)));
	}
}
