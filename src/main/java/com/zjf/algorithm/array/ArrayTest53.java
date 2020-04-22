package com.zjf.algorithm.array;

/**
 * description: ArrayTest53 <br>
 * date: 2020/4/22 16:23 <br>
 * author: 张建峰 <br>
 */
public class ArrayTest53 {

	/**
	 * description:
	 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	 *
	 * 示例:
	 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
	 * 输出: 6
	 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	*/
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		if(len == 0){
			return 0;
		}
		if (len == 1){
			return nums[0];
		}
		//标记开始位置
		int k;
		//记录总数
		int sum = nums[0];;
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num >= sum + num){
				sum = num;
				k = i;
			}else {
				sum += num;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		ArrayTest53 arrayTest53 = new ArrayTest53();
		int sum = arrayTest53.maxSubArray(nums);
		System.out.println(sum);
	}
}
