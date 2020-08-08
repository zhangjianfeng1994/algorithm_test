package com.zjf.algorithm.dynamicprogramming;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-08-08 17:11  //时间
 */
public class Test121_122_123_188_309_714 {

	/**
	 *
	 */
	/**
	 *   dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
	 dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
	 = max(dp[i-1][1][1], -prices[i])
	 解释：k = 0 的 base case，所以 dp[i-1][0][0] = 0。

	 现在发现 k 都是 1，不会改变，即 k 对状态转移已经没有影响了。
	 可以进行进一步化简去掉所有 k：
	 dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
	 dp[i][1] = max(dp[i-1][1], -prices[i])
	 */
	// k == 1  121题
	int maxProfit_k_1(int[] prices) {
		int n = prices.length;
		// base case: dp[-1][0] = 0, dp[-1][1] = -infinity
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			// dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			// dp[i][1] = max(dp[i-1][1], -prices[i])
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}
		return dp_i_0;
	}

	/**
	 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
	 * 如果你最多只允许完成一笔或者多笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
	 * 注意：你不能在买入股票前卖出股票。
	 */

	/**
	   穷举框架
		 for 状态1 in 状态1的所有取值：
		    for 状态2 in 状态2的所有取值：
		        for ...
		            dp[状态1][状态2][...] = 择优(选择1，选择2...)

         「状态」有三个 第一个是天数，第二个是允许交易的最大次数，
           第三个是当前的持有状态（即之前说的 rest 的状态，我们不妨用 1 表示持有，0 表示没有持有）
          dp[i][k][0 or 1]
		  0 <= i <= n-1, 1 <= k <= K
		  n 为天数，大 K 为最多交易数
		  此问题共 n × K × 2 种状态，全部穷举就能搞定。
		  for 0 <= i < n:
		    for 1 <= k <= K:
		        for s in {0, 1}:
		            dp[i][k][s] = max(buy, sell, rest)

        *状态转移框架
          dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
              max(   选择 rest  ,             选择 sell      )
			解释：今天我没有持有股票，有两种可能：
			要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
			要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。

			dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
			              max(   选择 rest  ,           选择 buy         )

			解释：今天我持有着股票，有两种可能：
			要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
			要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
	 */
	//k为正无穷

	/**
	 *122题
	 * 如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。可以这样改写框架：
	 */
	int maxProfit_k_inf(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
		}
		return dp_i_0;
	}
	/**
	 *  k 为正无穷 加冷冻期 309
	 * 每次 sell 之后要等一天才能继续交易。只要把这个特点融入上一题的状态转移方程即可：
	 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
	 * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
	 * 解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
	 */
	int maxProfit_with_cool(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		int dp_pre_0 = 0; // 代表 dp[i-2][0]
		for (int i = 0; i < n; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
			dp_pre_0 = temp;
		}
		return dp_i_0;
	}
	/**
	 * 手续费  714题
	 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
	 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
	 * 解释：相当于买入股票的价格升高了。
	 * 在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
	 */
	int maxProfit_with_fee(int[] prices, int fee) {
		int n = prices.length;
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
		}
		return dp_i_0;
	}


	/**
	 * k=2  123题
	 */
	int maxProfit_k_2(int[] prices) {
		int n = prices.length;
		int max_k = 2;
		int[][][] dp = new int[n][max_k + 1][2];
		for (int i = 0; i < n; i++) {
			for (int k = max_k; k >= 1; k--) {
				if (i - 1 == -1) {
					/*处理 base case */
					dp[i][k][0] = 0;
					dp[i][k][1] = -prices[i];
					continue;
				}
				dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
			}
		}
		// 穷举了 n × max_k × 2 个状态，正确。
		return dp[n - 1][max_k][0];
	}
	/**
	 * k不确定  188题
	 */
	int maxProfit_k_any(int max_k, int[] prices) {
		int n = prices.length;
		if (max_k > n / 2) {
			return maxProfit_k_inf(prices);
		}

		int[][][] dp = new int[n][max_k + 1][2];
		for (int i = 0; i < n; i++) {
			for (int k = max_k; k >= 1; k--) {
				if (i - 1 == -1) {
					/* 处理 base case */
					dp[i][k][0] = 0;
					dp[i][k][1] = -prices[i];
					continue;
				}
				dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
			}
		}
		return dp[n - 1][max_k][0];
	}

	public static void main(String[] args) {
		Test121_122_123_188_309_714 test = new Test121_122_123_188_309_714();
		int[] prices = {1,2};
		int k=1;
		System.out.println(test.maxProfit_k_any(k,prices));
	}
}
