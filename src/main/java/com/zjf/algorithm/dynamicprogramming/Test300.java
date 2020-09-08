package com.zjf.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-09-08 22:57  //时间
 */
public class Test300 {

	/**
	 *给定一个无序的整数数组，找到其中最长上升子序列的长度。
	 * 示例:
	 * 输入: [10,9,2,5,3,7,101,18]
	 * 输出: 4
	 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
	 * 说明:
	 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
	 * 你算法的时间复杂度应该为 O(n2) 。
	 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
	 */
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		if(len == 0){
			return 0;
		}
		if (len ==1){
			return 1;
		}
		int[] dp = new int[len];
		//dp[0] = 1;
		Arrays.fill(dp,1);
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]){
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < len; i++) {
			max = Math.max(max,dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		Test300 test = new Test300();
		int[] nums = {2,2};
		System.out.println(test.lengthOfLIS(nums));
	}
}
