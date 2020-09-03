package com.zjf.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * description: 完全背包问题  物品无限制;
 *  0-1背包问题  物品只能拿一次
 * date: 2020/9/1 16:29 <br>
 * author: 张建峰 <br>
 */
public class Test518 {


	/**
	 * dp[i][j]的定义如下：
	 *  若只使用coins中的前i个硬币的面值，若想凑出金额j，有dp[i][j]种凑法。
	 * base case 为dp[0][..] = 0， dp[..][0] = 1
	 * 状态转移方程:
	 *  如果你不把这第i个物品装入背包，
	 *  也就是说你不使用coins[i]这个面值的硬币，
	 *  那么凑出面额j的方法数dp[i][j]应该等于dp[i-1][j]，继承之前的结果。
	 *  如果你把这第i个物品装入了背包，也就是说你使用coins[i]这个面值的硬币，
	 *  那么dp[i][j]应该等于dp[i][j-coins[i-1]]。
	*/
	public int change(int amount, int[] coins) {
		int n = coins.length;
		int[][] dp = new int[n + 1][amount + 1];
		// base case
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= amount; j++){
				if (j - coins[i-1] >= 0) {
					dp[i][j] = dp[i - 1][j]
							+ dp[i][j - coins[i-1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][amount];
	}

	/**
	 * 状态压缩
	*/
	public int change1(int amount, int[] coins) {
		int[] dp = new int[amount+1];
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++){
				if (j - coins[i] >= 0){
					dp[j] = dp[j] + dp[j - coins[i]];
				}
			}
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		Test518 test = new Test518();
		int[] coins = {1,2,5};
		System.out.println(test.change1(5,coins));
	}

}
