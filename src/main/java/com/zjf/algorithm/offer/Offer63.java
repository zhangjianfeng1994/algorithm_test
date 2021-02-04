package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2021-02-01 15:39  //时间
 */
public class Offer63 {

	/**
	 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
	 *
	 * 示例 1:
	 * 输入: [7,1,5,3,6,4]
	 * 输出: 5
	 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
	 * 示例 2:
	 * 输入: [7,6,4,3,1]
	 * 输出: 0
	 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
	 */
	public int maxProfit(int[] prices) {
		int dp_i_0 = 0;//前I天未持有股票的最大收益
		int dp_i_1 = Integer.MIN_VALUE;//前I天持有股票的最大收益
		for (int i = 0; i < prices.length; i++) {
			dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
			dp_i_1 = Math.max(dp_i_1,-prices[i]);

		}
		return dp_i_0;
	}
}
