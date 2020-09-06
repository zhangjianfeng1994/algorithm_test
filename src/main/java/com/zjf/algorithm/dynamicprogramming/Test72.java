package com.zjf.algorithm.dynamicprogramming;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-09-06 11:56  //时间
 */
public class Test72 {

	/**
	 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
	 * 你可以对一个单词进行如下三种操作：
	 * 插入一个字符
	 * 删除一个字符
	 * 替换一个字符
	 *  
	 * 示例 1：
	 * 输入：word1 = "horse", word2 = "ros"
	 * 输出：3
	 * 解释：
	 * horse -> rorse (将 'h' 替换为 'r')
	 * rorse -> rose (删除 'r')
	 * rose -> ros (删除 'e')
	 * 示例 2：
	 * 输入：word1 = "intention", word2 = "execution"
	 * 输出：5
	 * 解释：
	 * intention -> inention (删除 't')
	 * inention -> enention (将 'i' 替换为 'e')
	 * enention -> exention (将 'n' 替换为 'x')
	 * exention -> exection (将 'n' 替换为 'c')
	 * exection -> execution (插入 'u')
	 *
	 * 详细过程请看:
	 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484484&idx=1&sn=74594297022c84952162a68b7f739133&chksm=9bd7fa4caca0735a1364dd13901311ecd6ec4913c8db05a1ff6cae8f069627eebe8d651bbeb1&scene=21#wechat_redirect
	 */
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <=m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i-1)==word2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
				}

			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		Test72 test = new Test72();
		String word1 = "horse";
		String word2 = "ros";
		System.out.println(test.minDistance(word1,word2));
	}
}
