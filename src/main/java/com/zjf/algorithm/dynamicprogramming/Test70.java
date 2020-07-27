package com.zjf.algorithm.dynamicprogramming;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-07-26 23:58  //时间
 */
public class Test70 {

	/**
	 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	 * 注意：给定 n 是一个正整数。
	 * 示例 1：
	 * 输入： 2
	 * 输出： 2
	 * 解释： 有两种方法可以爬到楼顶。
	 * 1.  1 阶 + 1 阶
	 * 2.  2 阶
	 *
	 * 1 1
	 * 2 2
	 * 3 3 1+1+1  2+1 1+2
	 * 4  1+1+1+1 2+1+1 1+2+1  1+1+2 2+2
	 * 5  1+1+1+1+1 2+1+1+1 1+2+1+1 1+1+2+1 1+1+1+2
	 */
	public int climbStairs(int n) {
		if (n == 0){
			return 0;
		}
		if (n == 1){
			return 1;
		}
		int int1 = 1;
		int int2 = 2;
		for (int i = 2; i < n; i++) {
			int dmp = int2;
			int2 = int2+int1;
			int1 = dmp;
		}
		return int2;
	}

	public int climbStairs1(int n) {
		return backtrack(n,0);
	}

	public int backtrack(int n,int sum){
		if (sum > n){
			return 0;
		}
		if (sum == n){
			return 1;
		}
		int num1 = backtrack(n,sum+1);
		int num2 = backtrack(n,sum+2);
		return num1+num2;
	}

	public static void main(String[] args) {
		Test70 test = new Test70();
		int num = test.climbStairs(44);
		int num1 = test.climbStairs1(44);
		System.out.println(num);
		System.out.println(num1);
	}
}
