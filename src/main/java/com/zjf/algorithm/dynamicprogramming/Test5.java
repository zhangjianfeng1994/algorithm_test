package com.zjf.algorithm.dynamicprogramming;

import sun.applet.Main;

import java.util.Arrays;

/**
 * description: Test5 <br>
 * date: 2020/9/15 17:36 <br>
 * author: 张建峰 <br>
 */
public class Test5 {

	/**
	 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
	 * 示例 1：
	 * 输入: "babad"
	 * 输出: "bab"
	 * 注意: "aba" 也是一个有效答案。
	 * 示例 2：
	 * 输入: "cbbd"
	 * 输出: "bb"
	*/
	public String longestPalindrome(String s) {
		int n = s.length();
		if (n < 2){
			return s;
		}
		String res = "";
		for (int i = 0; i < n; i++) {
			String s1 = centerSpread(s,i,i);
			String s2 = centerSpread(s,i,i+1);
			res = res.length()>s1.length()?res:s1;
			res = res.length()>s2.length()?res:s2;
		}
		return res;
	}

	private String centerSpread(String s, int left, int right) {
		while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left--;right++;
		}
		return s.substring(left+1,right);
	}



	public String longestPalindrome1(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	public int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			--left;
			++right;
		}
		return right - left - 1;
	}




	public static void main(String[] args) {
		Test5 test = new Test5();
		String s = "babxad";
		System.out.println(test.longestPalindrome(s));
	}
}
