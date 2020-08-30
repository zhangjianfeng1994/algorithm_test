package com.zjf.algorithm.dynamicprogramming;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description : 零钱兑换
 * @Author : ZJF
 * @Date: 2020-08-30 22:14  //时间
 */
public class Test322 {
	/**
	 * 给定不同面额的硬币 coins 和一个总金额 amount。
	 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
	 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
	 *示例 1:
	 * 输入: coins = [1, 2, 5], amount = 11
	 * 输出: 3
	 * 解释: 11 = 5 + 5 + 1
	 *   1 2 5
	 * 1 2 3 6
	 * 2
	 * 5
	 * 示例 2:
	 * 输入: coins = [2], amount = 3
	 * 输出: -1
	 */
	public int coinChange(int[] coins, int amount) {
		if (coins.length == 0){
			return -1;
		}
		List<Integer> result = new ArrayList<>();
		result.add(Integer.MAX_VALUE);
		backtrack(coins,amount,amount,0,coins.length-1,result);
		if (result.get(0) == Integer.MAX_VALUE){
			return -1;
		}
		return result.get(0);
	}

	public void backtrack(int[] coins, int amount, int residue, int size,int start, List<Integer> list){
		if (residue == 0){
			if (size<list.get(0)){
				list.clear();
				list.add(size);
			}
			return ;
		}
		if (residue < 0){
			return;
		}
		for (int i = start; i >= 0; i--) {
			backtrack(coins,amount,residue-coins[i],size+1,i,list);
		}
	}


	/**
	 * 带备忘录的回溯
	 */
	public int coinChange1(int[] coins, int amount) {
		if (amount < 1) {
			return 0;
		}
		return coinChange(coins, amount, new int[amount]);
	}

	private int coinChange(int[] coins, int rem, int[] count) {
		if (rem < 0) {
			return -1;
		}
		if (rem == 0) {
			return 0;
		}
		if (count[rem - 1] != 0) {
			return count[rem - 1];
		}
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange(coins, rem - coin, count);
			if (res >= 0 && res < min) {
				min = 1 + res;
			}
		}
		count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem - 1];
	}


	public int coinChange2(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}


	public static void main(String[] args) {
		Test322 test = new Test322();
		int[] coins = {1,2,5};
		System.out.println(test.coinChange(coins,13));
	}
}
