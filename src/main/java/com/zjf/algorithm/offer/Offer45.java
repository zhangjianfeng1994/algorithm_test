package com.zjf.algorithm.offer;

import java.util.Arrays;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-12-30 00:17  //时间
 */
public class Offer45 {

	/**
	 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，
	 * 打印能拼接出的所有数字中最小的一个。
	 *
	 *  
	 *
	 * 示例 1:
	 *
	 * 输入: [10,2]
	 * 输出: "102"
	 * 示例 2:
	 *
	 * 输入: [3,30,34,5,9]
	 * 输出: "3033459"
	 *  
	 *
	 * 提示:
	 *
	 * 0 < nums.length <= 100
	 * 说明:
	 *
	 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
	 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
	 */
	public String minNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
		StringBuilder res = new StringBuilder();
		for(String s : strs) {
			res.append(s);
		}
		return res.toString();
	}


	public String minNumber1(int[] nums) {
		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		fastSort(strs, 0, strs.length - 1);
		StringBuilder res = new StringBuilder();
		for(String s : strs) {
			res.append(s);
		}
		return res.toString();
	}
	/**
	 * ?????  strs[l] 为什么是和这个比较
	 * [5,3,30,34,9]
	 */
	void fastSort(String[] strs, int l, int r) {
		if(l >= r) {
			return;
		}
		int i = l, j = r;
		String base = strs[i];
		while(i < j) {
			while((strs[j] + base).compareTo(base + strs[j]) >= 0 && i < j) {
				j--;
			}
			while((strs[i] + base).compareTo(base + strs[i]) <= 0 && i < j) {
				i++;
			}
			String tmp1 = strs[i];
			strs[i] = strs[j];
			strs[j] = tmp1;
		}
		strs[l] = strs[i];
		strs[i] = base;
		fastSort(strs, l, i - 1);
		fastSort(strs, i + 1, r);
	}

}




