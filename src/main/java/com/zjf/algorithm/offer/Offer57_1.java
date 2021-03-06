package com.zjf.algorithm.offer;

import java.util.*;

/**
 * description: Offer57 <br>
 * date: 2021/1/21 18:52 <br>
 * author: 张建峰 <br>
 */
public class Offer57_1 {

	/**
	 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
	 * 如果有多对数字的和等于s，则输出任意一对即可。
	 * 示例 1：
	 * 输入：nums = [2,7,11,15], target = 9
	 * 输出：[2,7] 或者 [7,2]
	 * 示例 2：
	 * 输入：nums = [10,26,30,31,47,60], target = 40
	 * 输出：[10,30] 或者 [30,10]
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int other = target - nums[i];
			if (map.containsKey(other)) {
				result[0] = other;
				result[1] = nums[i];
			}
			map.put(nums[i], i);
		}
		return result;
	}

	public int[] twoSum1(int[] nums, int target) {
		int i= 0,j = nums.length-1;
		while (i<j){
			if (nums[i]+nums[j]<target){
				i++;
			}else if (nums[i]+nums[j]<target){
				j--;
			}else{
				return new int[]{nums[i],nums[j]};
			}
		}
		return new int[0];
	}
}
