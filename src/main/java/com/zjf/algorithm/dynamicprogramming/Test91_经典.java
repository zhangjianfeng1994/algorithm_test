package com.zjf.algorithm.dynamicprogramming;

import java.util.HashMap;

/**
 * description: Test91 <br>
 * date: 2020/7/30 11:16 <br>
 * author: 张建峰 <br>
 */
public class Test91_经典 {

	/**
	 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
	 * 'A' -> 1
	 * 'B' -> 2
	 * ...
	 * 'Z' -> 26
	 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
	 * 示例 1:
	 * 输入: "12"
	 * 输出: 2
	 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
	 * 2626 (2,6,2,6) (26,26) (2,6,26) (26,2,6)
	 * 273
	*/
	int sum = 0;
	public int numDecodings(String s) {
		if (s==null &&s.length() ==0){
			return 0;
		}
		int len = s.length();
		backtrack(s,0,len);
		return sum;

	}


	public void backtrack(String s, int start,int len){
		if (start== len){
			sum++;
		}
		for (int i = start; i < len; i++) {
			if (i > start + 2) {
				break;
			}
			String sub = s.substring(start, i + 1);
			if (!isMessage(sub)) {
				break;
			}
			backtrack(s, i + 1, len);
		}
	}

	public boolean isMessage(String s){
		Integer num = Integer.parseInt(s);
		if (num >= 1 && num<=26){
			return true;
		}
		return false;
	}

	/**
	 * 递归
	 * 对于第一个字母我们有两种划分方式。
	 * 2|32232323232 和 23|2232323232
	*/
	public int numDecodings1(String s) {
		return getAns1(s, 0);
	}

	private int getAns1(String s, int start) {
		//划分到了最后返回 1
		if (start == s.length()) {
			return 1;
		}
		//开头是 0,0 不对应任何字母，直接返回 0
		if (s.charAt(start) == '0') {
			return 0;
		}
		//得到第一种的划分的解码方式
		int ans1 = getAns1(s, start + 1);
		int ans2 = 0;
		//判断前两个数字是不是小于等于 26 的
		if (start < s.length() - 1) {
			int ten = (s.charAt(start) - '0') * 10;
			int one = s.charAt(start + 1) - '0';
			if (ten + one <= 26) {
				ans2 = getAns1(s, start + 2);
			}
		}
		return ans1 + ans2;
	}

	/**
	 * memoization  对函数返回值进行缓存(一种计算机程序优化技术)
	 * 解法一的递归中，走完左子树，再走右子树会把一些已经算过的结果重新算，
	 * 所以我们可以用 memoization 技术，就是算出一个结果很就保存，
	 * 第二次算这个的时候直接拿出来就可以了
	*/
	public int numDecodings2(String s) {
		HashMap<Integer, Integer> memoization = new HashMap<>();
		return getAns2(s, 0, memoization);
	}

	private int getAns2(String s, int start, HashMap<Integer, Integer> memoization) {
		if (start == s.length()) {
			return 1;
		}
		if (s.charAt(start) == '0') {
			return 0;
		}
		//判断之前是否计算过
		int m = memoization.getOrDefault(start, -1);
		if (m != -1) {
			return m;
		}
		int ans1 = getAns2(s, start + 1, memoization);
		int ans2 = 0;
		if (start < s.length() - 1) {
			int ten = (s.charAt(start) - '0') * 10;
			int one = s.charAt(start + 1) - '0';
			if (ten + one <= 26) {
				ans2 = getAns2(s, start + 2, memoization);
			}
		}
		//将结果保存
		memoization.put(start, ans1 + ans2);
		return ans1 + ans2;
	}


	/**
	 * 同样的，递归就是压栈压栈压栈，出栈出栈出栈的过程，
	 * 我们可以利用动态规划的思想，省略压栈的过程，直接从 bottom 到 top。
	 * 用一个 dp 数组， dp [ i ] 代表字符串 s [ i, s.len-1 ]，
	 * 也就是 s 从 i 开始到结尾的字符串的解码方式。
	 * 这样和递归完全一样的递推式。
	 * 如果 s [ i ] 和 s [ i + 1 ] 组成的数字小于等于 26，那么
	 * dp [ i ] = dp[ i + 1 ] + dp [ i + 2 ]
	*/
	public int numDecodings3(String s) {
		int len = s.length();
		int[] dp = new int[len + 1];
		dp[len] = 1; //将递归法的结束条件初始化为 1
		//最后一个数字不等于 0 就初始化为 1
		if (s.charAt(len - 1) != '0') {
			dp[len - 1] = 1;
		}
		for (int i = len - 2; i >= 0; i--) {
			//当前数字时 0 ，直接跳过，0 不代表任何字母
			if (s.charAt(i) == '0') {
				continue;
			}
			int ans1 = dp[i + 1];
			//判断两个字母组成的数字是否小于等于 26
			int ans2 = 0;
			int ten = (s.charAt(i) - '0') * 10;
			int one = s.charAt(i + 1) - '0';
			if (ten + one <= 26) {
				ans2 = dp[i + 2];
			}
			dp[i] = ans1 + ans2;

		}
		return dp[0];
	}


	public static void main(String[] args) {
		Test91_经典 test = new Test91_经典();
		String s = "24267225";
		int num1 = test.numDecodings(s);
		System.out.println(num1);
	}
}
