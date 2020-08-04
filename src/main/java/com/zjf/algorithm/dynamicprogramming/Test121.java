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
	 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
	 * 示例 2:
	 * 输入: [7,6,4,3,1]
	 * 输出: 0
	 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
	 */
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0 ||prices.length == 1){
			return 0;
		}
		int[] dp = new int[prices.length];
		for (int i = 0; i < prices.length-1; i++) {
			for (int j = i+1; j < prices.length; j++) {
				dp[i] = Math.max(dp[i],prices[j]-prices[i]);
			}
		}
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			int i1 = dp[i];
			result = Math.max(i1,result);
		}
		return result;
	}

	public static void main(String[] args) {
		Test121 test = new Test121();
		int[] prices = {7,1,5,3,7,4};
		System.out.println(test.maxProfit(prices));
	}
}
