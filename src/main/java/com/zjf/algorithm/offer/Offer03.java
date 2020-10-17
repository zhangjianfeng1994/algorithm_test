package com.zjf.algorithm.offer;

import java.util.*;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-10-13 21:35  //时间
 */
public class Offer03 {

	/**
	 * 找出数组中重复的数字。
	 *
	 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
	 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
	 * 请找出数组中任意一个重复的数字。
	 *
	 */
	public int findRepeatNumber(int[] nums) {
		int n = nums.length;
		Set<Integer> set = new HashSet<>(n);
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			if (!set.add(num)){
				return num;
			}
			set.add(num);
		}
		return -1;
	}


	public int findRepeatNumber1(int[] nums) {
		int[] d = new int[nums.length];
		for (int n : nums) {
			if (++ d[n] > 1) {
				return n;
			}
		}
		return -1;
	}


}
