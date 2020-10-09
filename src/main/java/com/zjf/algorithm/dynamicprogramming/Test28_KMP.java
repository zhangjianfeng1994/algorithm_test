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

	/*
	 * kmp算法
	*/
	private int[][] dp;
	private String pat;

	public Test28_KMP(String pat) {
		this.pat = pat;
		int M = pat.length();
		// dp[状态][字符] = 下个状态
		dp = new int[M][256];
		// base case
		dp[0][pat.charAt(0)] = 1;
		// 影子状态 X 初始为 0
		int X = 0;
		// 当前状态 j 从 1 开始
		for (int j = 1; j < M; j++) {
			for (int c = 0; c < 256; c++) {
				if (pat.charAt(j) == c)
					dp[j][c] = j + 1;
				else
					dp[j][c] = dp[X][c];
			}
			// 更新影子状态
			X = dp[X][pat.charAt(j)];
		}
	}

	public int search(String txt) {
		int M = pat.length();
		int N = txt.length();
		// pat 的初始态为 0
		int j = 0;
		for (int i = 0; i < N; i++) {
			// 计算 pat 的下一个状态
			j = dp[j][txt.charAt(i)];
			// 到达终止态，返回结果
			if (j == M) return i - M + 1;
		}
		// 没到达终止态，匹配失败
		return -1;
	}

	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issip";
		Test28_KMP test = new Test28_KMP(needle);
		System.out.println(test.strStr(haystack,needle));
	}
}
