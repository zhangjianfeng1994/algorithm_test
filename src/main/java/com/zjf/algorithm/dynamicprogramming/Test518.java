package com.zjf.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * description: Test518 <br>
 * date: 2020/9/1 16:29 <br>
 * author: 张建峰 <br>
 */
public class Test518 {

	public int change(int amount, int[] coins) {
		int len = coins.length;
		if (len == 0){
			return 0;
		}

		int[] dp = new int[amount+1];
		dp[0] = 1;
		for (int j = 0; j < len; j++) {
			for (int i = coins[j]; i < dp.length; i++) {
					dp[i] += dp[i-coins[j]];

			}
		}
		return dp[amount];
	}

	public int change1(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int coin : coins) {
			for (int x = coin; x < amount + 1; ++x) {
				dp[x] += dp[x - coin];
			}
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		Test518 test = new Test518();
		int[] coins = {1,2,5};
		System.out.println(test.change(5,coins));
	}

}
