package com.zjf.algorithm.stack;

import java.util.HashSet;
import java.util.Set;

/**
 * description: 滑动窗口类
 * date: 2020/6/16 16:44 <br>
 * author: 张建峰 <br>
 */

public class Test567 {
	/*
	 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
		换句话说，第一个字符串的排列之一是第二个字符串的子串。
		示例1:
		输入: s1 = "ab" s2 = "eidbaooo"
		输出: True
		解释: s2 包含 s1 的排列之一 ("ba").
		示例2:
		输入: s1= "ab" s2 = "eidboaoo"
		输出: False
		注意：
		输入的字符串只包含小写字母
		两个字符串的长度都在 [1, 10,000] 之间
	 *
	*/
	private static Set<String> result = new HashSet<String>();

	public boolean checkInclusion(String s1, String s2) {

		return false;
	}


	private static void permutation(char[] a, int from, int to) {
		if (a == null || from > to || from < 0) {
			return;
		}
		if (from == to) {
			result.add(String.valueOf(a));
		}
		for (int i = from; i <= to; i++) {
			swap(a, i, from);
			permutation(a, from + 1, to);
			swap(a, i, from);
		}
	}

	private static void swap(char[] a, int left, int right) {
		char temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	public static void main(String[] args) {
		Test567 test = new Test567();
		String str = "ab";
		char[] a = str.toCharArray();
		test.permutation(a,0,a.length-1);
		Set<String> result = test.result;
		for (String aa : result) {
			System.out.println(aa);
		}
	}
}
