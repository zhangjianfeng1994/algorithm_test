package com.zjf.algorithm.dynamicprogramming;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-09-29 23:26  //时间
 */
public class Test28_KMP {

	/**
	 * 实现 strStr() 函数。
	 *
	 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
	 *
	 * 示例 1:
	 *
	 * 输入: haystack = "hello", needle = "ll"
	 * 输出: 2
	 * 示例 2:
	 *
	 * 输入: haystack = "aaaaa", needle = "bba"
	 * 输出: -1
	 * 说明:
	 *
	 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
	 */
	public int strStr(String haystack, String needle) {

		int m = haystack.length(), n = needle.length();
		if (n == 0) return 0;
		for (int i = 0; i <= m - n; i++) {
			for (int j = 0; j < n; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) break;
				if (j == n - 1) return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Test28_KMP test = new Test28_KMP();
		String haystack = "mississippi";
		String needle = "issip";
		System.out.println(test.strStr(haystack,needle));
	}
}
