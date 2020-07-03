package com.zjf.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Test131 {

	/**
	 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
	 * 返回 s 所有可能的分割方案。
	 * 示例:
	 * 输入: "aab"
	 * 输出:
	 * [
	 *   ["aa","b"],
	 *   ["a","a","b"]
	 * ]
	 */
	List<List<String>> res = new ArrayList<>();
	public List<List<String>> partition(String s) {
		int len = s.length();

		return res;
	}

	public void backtrack(String s,int start,List<String> list){
		if (start == s.length()){
			return;
		}
		if (!isPalindrome(s)){
			return;
		}
		list.add(s);
		for (int i = start; i < s.length(); i++) {
			char aChar = s.charAt(i);

		}
	}

	public boolean isPalindrome(String s) {
		int n = s.length();
		int left = 0, right = n - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				++left;
			}
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				--right;
			}
			if (left < right) {
				if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
					return false;
				}
				++left;
				--right;
			}
		}
		return true;
	}
}
