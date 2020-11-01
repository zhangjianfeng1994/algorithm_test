package com.zjf.algorithm.offer;

/**
 * description: Offer14_1 <br>
 * date: 2020/10/28 16:49 <br>
 * author: 张建峰 <br>
 */
public class Offer14_1 {

	/**
	 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
	 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
	 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
	 * 此时得到的最大乘积是18。
	 * 8: 2    1 7; 2 6; 3 5; 4 4;  4段, 5段
	 * 示例 1：
	 *
	 * 输入: 2
	 * 输出: 1
	 * 解释: 2 = 1 + 1, 1 × 1 = 1
	 * 示例 2:
	 *
	 * 输入: 10
	 * 输出: 36
	 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
	 * 提示：
	 *
	 * 2 <= n <= 58
	 *
	*/
	public int cuttingRope(int n) {

		if (n<4){
			return n-1;
		}
		int m = n/2;//切割的最大段数
		int maxRope = 0;
		int tmp = 0;
		for (int i = 2; i <= m; i++) {
			int len = n/i; //每段的长度 3段
			int remainder = n%i;
			tmp = len; //2*3*3
			for (int j = 0; j < i-1; j++) {
				if (remainder > 0){
					tmp =  tmp*(len+1);
					remainder--;
				}else {
					tmp = tmp*len;
				}
			}
			maxRope = Math.max(tmp,maxRope);
		}
		return maxRope;
	}

	public int cuttingRope1(int n) {
		int[] dp = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i]= Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Offer14_1 test = new Offer14_1();
		System.out.println(test.cuttingRope(2));
	}
}
