package com.zjf.algorithm.offer;

/**
 * description: Offer49 <br>
 * date: 2021/1/4 16:56 <br>
 * author: 张建峰 <br>
 */
public class Offer49 {

	/**
	 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
	 * 求按从小到大的顺序的第 n 个丑数。
	 *
	 * 示例:
	 * 输入: n = 10
	 * 输出: 12
	 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
	 * 说明:  
	 * 1 是丑数。
	 * n 不超过1690。
	 *
	*/
	/**
	 * 动态规划
	*/
	public int nthUglyNumber(int n) {
		int[] nums = new int[n];
		nums[0] = 1;
		int ugly,i2 = 0, i3 = 0, i5 = 0;
		for (int i = 1; i < n; i++) {
			ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
			nums[i] = ugly;

			if (ugly == nums[i2] * 2) ++i2;
			if (ugly == nums[i3] * 3) ++i3;
			if (ugly == nums[i5] * 5) ++i5;
		}
		return 1;
	}
}
