package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-10-21 00:01  //时间
 */
public class Offer10_2 {

	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
	 *
	 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
	 * 示例 1：
	 * 输入：n = 2
	 * 输出：2
	 * 3 = 2+1  4 :5  5:8  6:13
	 * 示例 2：
	 * 输入：n = 7  5  6
	 * 输出：21
	 * 示例 3：
	 * 输入：n = 0
	 * 输出：1
	 */
	/**
	 * 动态规划
	 */
	public int numWays(int n) {

		/*int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n]%1000000007;*/
		if (n == 0 || n == 1){
			return  1;
		}
		int dp0 = 1;
		int dp1 = 1;
		int dpn = 0;
		for (int i = 2; i <= n; i++) {
			dpn = (dp0 + dp1)  % 1000000007;
			dp0 = dp1;
			dp1 = dpn;

		}
		return dpn;
	}

	public static void main(String[] args) {
		Offer10_2 test = new Offer10_2();
		System.out.println(test.numWays(8));
	}
}
