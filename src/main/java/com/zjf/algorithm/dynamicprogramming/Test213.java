package com.zjf.algorithm.dynamicprogramming;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-08-12 00:07  //时间
 */
public class Test213 {

	/**
	 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
	 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
	 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
	 *
	 * 示例 1:
	 * 输入: [2,3,2]
	 * 输出: 3
	 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
	 *
	 * 示例 2:
	 * 输入: [1,2,3,1]
	 * 输出: 4
	 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
	 *      偷窃到的最高金额 = 1 + 3 = 4 。
	 */
	public int rob(int[] nums) {

		int len = nums.length;
		if (len == 0){
			return 0;
		}
		if (len == 1){
			return nums[0];
		}
		int pre = 0; //代替上边代码中的 dp[i - 2]
		int cur = nums[0]; //代替上边代码中的 dp[i - 1] 和 dp[i]
		for (int i = 2; i <= len-1; i++) {
			int temp = cur;
			cur = Math.max(pre + nums[i - 1], cur);
			pre = temp;
		}
		int pre1 = 0; //第一天不偷
		int cur1 = nums[1]; //第二天偷
		for (int i = 3; i <= len; i++) {
			int temp = cur1;
			cur1 = Math.max(pre1 + nums[i - 1], cur1);
			pre1 = temp;
		}
		return Math.max(cur,cur1);
	}

	public int rob1(int[] nums) {
		int len = nums.length;
		if (len == 0){
			return 0;
		}
		int dp_i_0_0 = 0;
		int dp_i_1_0 = Integer.MIN_VALUE;
		int dp_i_0_1 = Integer.MIN_VALUE;
		int dp_i_1_1 = nums[0];
		for (int i = 1; i < len; i++) {
			int temp = dp_i_0_0;
			int temp1 = dp_i_0_1;

			dp_i_0_0 = Math.max(dp_i_0_0,dp_i_1_0);
			dp_i_1_0 = temp +nums[i];
			if(i == len-1){
				dp_i_0_1 = Math.max(dp_i_0_1,dp_i_1_1);
				dp_i_1_1 = dp_i_0_1;
			}else{
				dp_i_0_1 = Math.max(dp_i_0_1,dp_i_1_1);
				dp_i_1_1 = temp1 +nums[i];
			}
		}
		return Math.max(Math.max(dp_i_0_0,dp_i_1_0),Math.max(dp_i_0_1,dp_i_1_1));
	}
	public static void main(String[] args) {
		Test213 test = new Test213();
		int[] nums = {2,3,2};
		System.out.println(test.rob1(nums));
	}

}
