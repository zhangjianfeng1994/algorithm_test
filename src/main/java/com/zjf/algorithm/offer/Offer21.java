package com.zjf.algorithm.offer;

import java.util.Arrays;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-10 00:03  //时间
 */
public class Offer21 {

	/**
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
	 *
	 *
	 * 示例：
	 * 输入：nums = [1,2,3,4]
	 * 输出：[1,3,2,4]
	 * 注：[3,1,2,4] 也是正确的答案之一。
	 *
	 * 提示：
	 * 1 <= nums.length <= 50000
	 * 1 <= nums[i] <= 10000
	 */
	//双指针交换
	public int[] exchange(int[] nums) {
		if (nums.length == 0){
			return nums;
		}
		int left = 0;
		int right = nums.length-1;
		while (left < right){
			//奇数
			while ((nums[left]&1) ==1 && left < right ){
				left++;
			}
			//偶数
			while ((nums[right]&1) !=1 && left < right){
				right--;
			}
			if (left < right){
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		Offer21 test = new Offer21();
		int[] nums = {1,2,3,4};
		System.out.println(Arrays.toString(test.exchange(nums)));
	}
}
