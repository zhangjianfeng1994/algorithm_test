package com.zjf.algorithm.backtrack;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test131 {

	/**
	 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
	 * 返回 s 所有可能的分割方案。
	 * 示例:
	 * 输入: "aab"
	 *   a  a  b
	 *  a b
	 * 输出:
	 * [
	 *   ["aa","b"],
	 *   ["a","a","b"]
	 * ]
	 *
	 * 1、每一个结点表示剩余没有扫描到的字符串，产生分支是截取了剩余字符串的前缀；
	 *
	 * 2、产生前缀字符串的时候，判断前缀字符串是否是回文。
	 *
	 * 如果前缀字符串是回文，则可以产生分支和结点；
	 * 如果前缀字符串不是回文，则不产生分支和结点，这一步是剪枝操作。
	 * 3、在叶子结点是空字符串的时候结算，此时从根结点到叶子结点的路径，就是结果集里的一个结果，使用深度优先遍历，记录下所有可能的结果。
	 *
	 */
	List<List<String>> res = new ArrayList<>();
	public List<List<String>> partition(String s) {
		int len = s.length();
		if(len == 0){
			return res;
		}
		backtrack(s,0,new ArrayList<String>(),len);
		return res;
	}

	public void backtrack(String s,int start,List<String> list,int len){
		if (start == len){
			List<String> copy = new ArrayList<>();
			copy.addAll(list);
			res.add(copy);
			return;
		}
		for (int i = start; i < len; i++) {
			if (!isPalindrome(s,start,i)){
				continue;
			}
			list.add(s.substring(start, i + 1));
			backtrack(s,i+1,list,len);
			list.remove(list.size()-1);
		}
	}
	/**
	 * @description 判断是否是回文串
	 * @author ZJF
	 * @date 2020/7/5 22:51
	 * @Param
	 * @return
	 * @throws
	 */
	public boolean isPalindrome(String s,int left,int right) {
		while (left < right) {
				if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
					return false;
				}
				++left;
				--right;
		}
		return true;
	}


	/**
	 * 利用动态规划把结果先算出来，
	 * 这样就可以以 O(1)O(1) 的时间复杂度直接得到一个子串是否是回文
	 */

	public List<List<String>> partition1(String s) {
		int len = s.length();
		List<List<String>> res = new ArrayList<>();
		if (len == 0) {
			return res;
		}

		// 预处理
		// 状态：dp[i][j] 表示 s[i][j] 是否是回文
		boolean[][] dp = new boolean[len][len];
		// 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
		for (int right = 0; right < len; right++) {
			// 注意：left <= right 取等号表示 1 个字符的时候也需要判断
			for (int left = 0; left <= right; left++) {
				if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
					dp[left][right] = true;
				}
			}
		}

		Deque<String> stack = new ArrayDeque<>();
		backtracking1(s, 0, len, dp, stack, res);
		return res;
	}

	private void backtracking1(String s,
	                          int start,
	                          int len,
	                          boolean[][] dp,
	                          Deque<String> path,
	                          List<List<String>> res) {
		if (start == len) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = start; i < len; i++) {
			// 剪枝
			if (!dp[start][i]) {
				continue;
			}
			path.addLast(s.substring(start, i + 1));
			backtracking1(s, i + 1, len, dp, path, res);
			path.removeLast();
		}
	}

}
