package com.zjf.algorithm.offer;

import java.io.File;
import java.util.*;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2021-01-14 23:29  //时间
 */
public class Offer53_2 {
	/**
	 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
	 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
	 * 示例 1:
	 * 输入: [0,1,3]
	 * 输出: 2
	 * 示例 2:
	 * 输入: [0,1,2,3,4,5,6,8,9]  长度9   4  左边4  右边4 8
	 * 输出: 8
	 * 二分,目标值在左右两边长度少的一边,继续二分
	 * l-r =
	 * 下标 = num  右边  7 9
	 */
	public int missingNumber(int[] nums) {
		return 1;
	}
	//如果递增不缺少数字,n=nums[n],n为下标;根据n=nums[n]可得知,缺少的数字在右边,否则在左边
	public int missingNumber1(int[] nums) {
		int i = 0, j = nums.length - 1;
		while(i <= j) {
			int m = (i + j) / 2;
			if(nums[m] == m) {
				i = m + 1;
			} else {
				j = m - 1;
			}
		}
		return i;
	}

	/*public static void main(String[] args) {
		System.out.println(Integer.valueOf("33",2));
	}*/
}
