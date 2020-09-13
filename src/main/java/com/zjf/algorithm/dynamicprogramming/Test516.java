package com.zjf.algorithm.dynamicprogramming;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-09-12 20:00  //时间
 */
public class Test516 {

	/**
	 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。
	 * 可以假设 s 的最大长度为 1000 。
	 *示例 1:
	 * 输入:
	 * "bbbab"
	 * 输出:
	 * 4
	 * 一个可能的最长回文子序列为 "bbbb"。
	 * 示例 2:
	 * 输入:
	 * "cbbd"
	 * 输出:
	 * 2
	 * 一个可能的最长回文子序列为 "bb"。
	 */
	public int longestPalindromeSubseq(String s) {
		int len = s.length();
		if(len == 0){
			return 0;
		}
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}
		for (int i = len-2; i >=0; i--) {
			for (int j = i+1; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)){
					dp[i][j] = dp[i + 1][j - 1] + 2;
				}else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][len-1];
	}

	public static void main(String[] args) {
		Test516 test = new Test516();
		String s = "bbbab";
		System.out.println(test.longestPalindromeSubseq(s));
	}
}
