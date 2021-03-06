package com.zjf.algorithm.dynamicprogramming;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-08-04 00:13  //时间
 */
public class Test121 {

	/**
	 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
	 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
	 * 注意：你不能在买入股票前卖出股票。
	 * 示例 1:
	 * 输入: [7,1,5,3,6,4]
	 * 输出: 5
	 *  4 -2 3 = 5    6-1 = 5-1 + 3-5 + 6-3
	 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
	 * 示例 2:
	 * 输入: [7,6,4,3,1]
	 * 输出: 0
	 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
	 * dp[n] =
	 */
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0 ||prices.length == 1){
			return 0;
		}
		int[] dp = new int[prices.length];
		for (int i = 0; i < prices.length-1; i++) {
			dp[i] = prices[i+1]-prices[i];
		}
		//记录当前值的总和
		int currSum = dp[0];
		//记录最大值
		int maxSum = dp[0];
		for (int i = 1; i < dp.length; i++) {
			int num = dp[i];
			//状态转移方程
			if (currSum >= 0){
				currSum += num;
			}else {
				currSum = num;
			}
			maxSum = Math.max(currSum,maxSum);
		}
		return maxSum;
	}

	public int maxProfit1(int[] prices) {
		int n = prices.length;
		int dp = 0;
		int max = 0;
		for (int i = 1; i < n; i++) {
			int num = prices[i] - prices[i - 1];
			dp = Math.max(dp + num, num);
			max = Math.max(max, dp);
		}
		return max;
	}

	public int maxProfit2(int[] prices) {
		int maxProfit = 0;
		int buy = 0;
		int sell = 0;
		for (; sell < prices.length; sell++) {
			//当前价格更小了，更新 buy
			if (prices[sell] < prices[buy]) {
				buy = sell;
			} else {
				maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);

			}
		}
		return maxProfit;
	}


	public static void main(String[] args) {
		Test121 test = new Test121();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(test.maxProfit(prices));
	}
}
