package com.zjf.algorithm.offer;

/**
 * description: Offer16 <br>
 * date: 2020/10/28 16:54 <br>
 * author: 张建峰 <br>
 */
public class Offer16 {
	/**
	 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
	 * 不得使用库函数，同时不需要考虑大数问题。
	 *
	 *
	 * 示例 1:
	 * 输入: 2.00000, 10
	 * 输出: 1024.00000
	 * 示例 2:
	 * 输入: 2.10000, 3
	 * 输出: 9.26100
	 * 示例 3:
	 * 输入: 2.00000, -2
	 * 输出: 0.25000
	 * 解释: 2-2 = 1/22 = 1/4 = 0.25
	 *
	 * 说明:
	 * -100.0 < x < 100.0
	 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
	 *
	*/
	public double myPow(double x, int n) {
		boolean flag = false;//是不是负数
		if(n<0){
			flag = true;
			n = n* -1;
		}
		double res = x;
		for (int i = 0; i < n-1; i++) {
			res = res*x;
		}
	    if (flag){
		    res = 1/res;
	    }
		return res;
	}

	public double myPow1(double x, int n) {
		if(x == 0) {
			return 0;
		}
		long b = n;
		double res = 1.0;
		if(b < 0) {
			x = 1 / x;
			b = -b;
		}
		while(b > 0) {
			if((b & 1) == 1) {
				res *= x;
			}
			x *= x;
			b >>= 1;
		}
		return res;
	}



	/**
	 * 至于求负幂次方，比如 2^{-10}，可以先求出 2^{10}，然后取倒数，1/2^{10}，就可以了
	 * 问题出在 n = - n 上，因为最小负数 -2^{31}取相反数的话，按照计算机的规则，
	 * 依旧是-2^{31}，所以这种情况需要单独讨论一下。
	 *当然，这样做的话 -1 ，和 1 也需要单独讨论下，因为他们的任意次方都是 1 或者 -1 。
	 */
	public double myPow2(double x, int n) {
		if (x == -1) {
			if ((n & 1) != 0) {
				return -1;
			} else {
				return 1;
			}
		}
		if (x == 1.0f) {
			return 1;
		}

		if (n == -2147483648) {
			return 0;
		}
		double mul = 1;
		if (n > 0) {
			mul = powRecursion(x, n);
		} else {
			n = -n;
			mul = powRecursion(x, n);
			mul = 1 / mul;
		}
		return mul;
	}

	public double powRecursion(double x, int n) {
		if (n == 0) {
			return 1;
		}
		//偶数的情况
		if ((n & 1) == 0) {
			return powRecursion(x * x, n / 2);
		} else { //奇数的情况
			return powRecursion(x * x, n / 2) * x;
		}
	}


	public static void main(String[] args) {
		Offer16 test = new Offer16();
		System.out.println(test.myPow(2.10000,3));
		System.out.println(test.myPow(2.0000,-2));
	}
}
