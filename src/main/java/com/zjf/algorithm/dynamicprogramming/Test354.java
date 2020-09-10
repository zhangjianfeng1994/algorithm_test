package com.zjf.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * description: Test354 <br>
 * date: 2020/9/10 16:57 <br>
 * author: 张建峰 <br>
 */
public class Test354 {

	/**
	 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
	 * 当另一个信封的宽度和高度都比这个信封大的时候，
	 * 这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
	 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封
	 * （即可以把一个信封放到另一个信封里面）。
	 * 说明:
	 * 不允许旋转信封。
	 *
	 * 示例:
	 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
	 * 输出: 3
	 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
	*/
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length == 0){
			return 0;
		}
		int n = envelopes.length;
		// 按宽度升序排列，如果宽度一样，则按高度降序排列
		Arrays.sort(envelopes, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ?
						b[1] - a[1] : a[0] - b[0];
			}
		});
		// 对高度数组寻找 LIS
		int[] height = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = envelopes[i][1];
		}

		//前n个信封可以套接的个数
		int[] dp = new int[n];
		Arrays.fill(dp,1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (height[j] < height[i]){
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max,dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		Test354 test = new Test354();
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(test.maxEnvelopes(envelopes));
	}
}
