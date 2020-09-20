package com.zjf.algorithm.dynamicprogramming;

import sun.applet.Main;

import java.util.Arrays;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-09-20 21:50  //时间
 */
public class Test279 {

	/**
	 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
	 * 你需要让组成和的完全平方数的个数最少。
	 * 示例 1:
	 * 输入: n = 12
	 * 输出: 3
	 * 解释: 12 = 4 + 4 + 4.
	 * 示例 2:
	 * 输入: n = 13
	 * 输出: 2
	 * 解释: 13 = 4 + 9.
	 */
	public int numSquares(int n) {


		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		// pre-calculate the square numbers.
		int max_square_index = (int) Math.sqrt(n) + 1;
		int square_nums[] = new int[max_square_index];
		for (int i = 1; i < max_square_index; ++i) {
			square_nums[i] = i * i;
		}
		for (int i = 1; i <= n; ++i) {
			for (int s = 1; s < max_square_index; ++s) {
				if (i < square_nums[s]) {
					break;
				}
				dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
			}
		}
		return dp[n];
	}

	public int numSquares1(int n) {


		// pre-calculate the square numbers.
		int max_square_index = (int) Math.sqrt(n)+1 ;
		int square_nums[] = new int[max_square_index];
		for (int i = 0; i < max_square_index; ++i) {
			square_nums[i] = i * i;
		}
		int dp[] = new int[n + 1];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = n+1;
		}
		dp[0] = 0;
		for (int i = 1; i <=max_square_index; i++) {
			for (int j = square_nums[i-1]; j <= n; j++) {
				dp[j] = Math.min(dp[j],dp[j-square_nums[i-1]]+1);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Test279 test = new Test279();
		System.out.println(test.numSquares1(13));
	}
}
