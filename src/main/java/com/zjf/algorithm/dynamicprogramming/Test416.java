package com.zjf.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * description: Test416 <br>
 * date: 2020/9/3 15:33 <br>
 * author: 张建峰 <br>
 */
public class Test416 {

	/**
	 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，
	 * 使得两个子集的元素和相等。
	 * 注意:
	 * 每个数组中的元素不会超过 100
	 * 数组的大小不会超过 200
	 * 示例 1:
	 * 输入: [1, 5, 11, 5]
	 * 输出: true
	 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
	 * 示例 2:
	 * 输入: [1, 2, 3, 5]
	 * 输出: false
	 * 解释: 数组不能分割成两个元素和相等的子集.
	*/
	public boolean canPartition(int[] nums) {
		int len = nums.length;
		if (len == 0){
			return true;
		}
		if (len == 1){
			return false;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		//如果总数除以2有余数,说明无法分割
		if(sum%2 != 0){
			return false;
		}
		//总数和的一半
		int num_2 = sum/2;
		//前i个数凑出j的可能
		boolean[][] dp = new boolean[len+1][num_2+1];
		for (int i = 0; i < len; i++) {
			dp[i][0] = true; //总数为0不用凑直接为成功
		}
		//
		//dp[0] = true;
		for (int i =1; i <= len; i++) {
			for (int j = 1; j <= num_2; j++) {
				if (j-nums[i-1] < 0){
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
				}
	 		}
		}
		/*
			0 0 0 1
			0 1 0 1
		 */
		for (int i =1; i <= len; i++) {
			for (int j = num_2; j >= 0; j--) {
				if (j-nums[i-1] < 0){
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
				}
	 		}
		}
		return dp[len][num_2];
	}

	/**
	 * 状态压缩
	*/
	public boolean canPartition1(int[] nums) {
		int len = nums.length;
		if (len == 0){
			return true;
		}
		if (len == 1){
			return false;
		}
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num += nums[i];
		}
		//如果总数除以2有余数,说明无法分割
		if(num%2 != 0){
			return false;
		}
		//总数的一半
		int num_2 = num/2;
		//凑出总数的可能
		boolean[] dp = new boolean[num_2+1];

		dp[0] = true;
		/*
		 *为啥是j--?
		 *  //一维数组隐含的状态i:([i-1][j])
			//dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
			//dp[i][j-nums[i-1]]
			* dp[j] = (dp[j] || dp[j-nums[i]]) 从小到大的时候会导致j-nums[i]的值被覆盖
			* 变成dp[i][j-nums[i-1]],这样计算到后面的时候.硬币或者数被重复使用
			* 所以应该从大到小
		*/
		for (int i =0; i < len; i++) {
			for (int j = num_2; j >= 0; j--) {
				if (j-nums[i] >= 0){
					dp[j] = (dp[j] || dp[j-nums[i]]) ;
				}
			}
		}
		/*for (int i =0; i < len; i++) {
			for (int j = 1; j <=num_2 ; j++) {
				if (j-nums[i] >= 0){
					dp[j] = (dp[j] || dp[j-nums[i]]);
				}
			}
		}*/
		return dp[num_2];
	}

	public static void main(String[] args) {
	 	Test416 test = new Test416();
		int[] nums = {1, 2, 5}; //4
		System.out.println(test.canPartition(nums));
		System.out.println(test.canPartition1(nums));
	}
}
