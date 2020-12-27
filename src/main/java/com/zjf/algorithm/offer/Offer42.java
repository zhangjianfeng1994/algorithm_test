package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-12-26 13:02  //时间
 */
public class Offer42 {

	/**
	 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
	 * 要求时间复杂度为O(n)。
	 *
	 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
	 * 输出: 6
	 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	 * 提示：
	 * 1 <= arr.length <= 10^5
	 * -100 <= arr[i] <= 100
	 */
	public int maxSubArray(int[] nums) {
		if (nums.length == 0){
			return 0;
		}
		if (nums.length == 1){
			return nums[0];
		}
		int currSum = nums[0];
		int maxSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (currSum> 0 ){
				currSum +=nums[i];
			}else {
				currSum = nums[i];
			}
			maxSum = Math.max(maxSum,currSum);
		}
		//dp(n) = max(dp(n-1)+n,n)
		return maxSum;
	}
}
