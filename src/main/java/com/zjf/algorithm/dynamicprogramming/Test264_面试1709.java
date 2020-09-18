package com.zjf.algorithm.dynamicprogramming;

/**
 * description: Test264 <br>
 * date: 2020/9/16 17:54 <br>
 * author: 张建峰 <br>
 */
public class Test264_面试1709 {

	/**
	 * 编写一个程序，找出第 n 个丑数。
	 * 丑数就是质因数只包含 2, 3, 5 的正整数。
	 * 示例:
	 * 输入: n = 10
	 * 输出: 12
	 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
	 * 说明:  
	 * 1 是丑数。
	 * n 不超过1690。
	*/
	public int nthUglyNumber(int n) {
		int[] nums = new int[1690];
		nums[0] = 1;
		int ugly, i2 = 0, i3 = 0, i5 = 0;
		for(int i = 1; i < n; ++i) {
			ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
			nums[i] = ugly;

			if (ugly == nums[i2] * 2) ++i2;
			if (ugly == nums[i3] * 3) ++i3;
			if (ugly == nums[i5] * 5) ++i5;
		}
		return nums[n - 1];
	}

	/**
	 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
	 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。
	 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
	 * 示例 1:
	 * 输入: k = 5
	 * 输出: 9
	*/
	public int getKthMagicNumber(int k) {
		int[] nums = new int[1690];
		nums[0] = 1;
		int ugly, i3 = 0, i5 = 0, i7 = 0;
		for(int i = 1; i < k; ++i) {
			ugly = Math.min(Math.min(nums[i3] * 3, nums[i5] * 5), nums[i7] * 7);
			nums[i] = ugly;

			if (ugly == nums[i3] * 3) ++i3;
			if (ugly == nums[i5] * 5) ++i5;
			if (ugly == nums[i7] * 7) ++i7;
		}
		return nums[k - 1];
	}

	public static void main(String[] args) {
		Test264_面试1709 test = new Test264_面试1709();
		System.out.println(test.nthUglyNumber(10));
		System.out.println(test.getKthMagicNumber(5));
	}
}
