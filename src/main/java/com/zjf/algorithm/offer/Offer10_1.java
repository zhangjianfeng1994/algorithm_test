package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-10-20 23:59  //时间
 */
public class Offer10_1 {

	/**
	 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
	 * F(0) = 0,   F(1) = 1
	 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
	 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
	 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
	 *
	 * 示例 1：
	 * 输入：n = 2
	 * 输出：1
	 * 示例 2：
	 * 输入：n = 5
	 * 输出：5
	 */
	public int fib(int n) {
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		int pre1 = 0;
		int pre2 = 1;
		int sum = 0;
		for (int i = 2; i <= n; i++) {
			sum = (pre1 + pre2)%1000000007;
			pre1 = pre2;
			pre2 = sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		Offer10_1 test = new Offer10_1();
		System.out.println(test.fib(100));
	}
}
