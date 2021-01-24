package com.zjf.algorithm.offer;

/**
 * description: 数组中出现奇次数找只出现一次的数字用此方法
 * date: 2021/1/21 18:38 <br>
 * author: 张建峰 <br>
 */
public class Offer56_2 {

	/**
	 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
	 *
	 * 示例 1：
	 * 输入：nums = [3,4,3,3]
	 * 输出：4
	 * 示例 2：
	 * 输入：nums = [9,1,7,9,7,9,7]
	 * 输出：1
	*/
	public int singleNumber(int[] nums) {
		int[] counts = new int[32];
		for(int num : nums) {
			for(int j = 0; j < 32; j++) {
				counts[j] += num & 1;
				num >>>= 1;
			}
		}
		int res = 0, m = 3;
		for(int i = 0; i < 32; i++) {
			res <<= 1;
			res |= counts[31 - i] % m;
		}
		return res;
	}
}
