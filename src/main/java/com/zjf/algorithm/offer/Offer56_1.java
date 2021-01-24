package com.zjf.algorithm.offer;

import java.sql.SQLOutput;

/**
 * description: 出现偶次数找一次的数字用此方法
 * date: 2021/1/21 18:38 <br>
 * author: 张建峰 <br>
 */
public class Offer56_1 {

	/**
	 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
	 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
	 * 示例 1：
	 * 输入：nums = [4,1,4,6]
	 * 输出：[1,6] 或 [6,1]
	 * 示例 2：
	 * 输入：nums = [1,2,10,4,1,4,3,3]
	 * 输出：[2,10] 或 [10,2]
	*/
	/**
	 * 由于数组中存在着两个数字不重复的情况，我们将所有的数字异或操作起来，
	 * 最终得到的结果是这两个数字的异或结果：(相同的两个数字相互异或，值为0)) 最后结果一定不为0，
	 * 因为有两个数字不重复。
	 *
	 *
	 *
	 */
	public int[] singleNumbers(int[] nums) {
		//用于将所有的数异或起来(1和6的异或)
		int k = 0;

		for(int num: nums) {
			k ^= num;
		}

		//获得k中最低位的1
		int mask = 1;

		//mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
		while((k & mask) == 0) {
			mask <<= 1;
		}
		//把数组分为两组,不同的数据分到不同的组
		int a = 0;
		int b = 0;

		for(int num: nums) {
			//不同的数据与mask与运算 要么为0 要么为1
			if((num & mask) == 0) {
				a ^= num;
			} else {
				b ^= num;
			}
		}

		return new int[]{a, b};
	}

	public static void main(String[] args) {
		System.out.println(4^4);
	}
}
