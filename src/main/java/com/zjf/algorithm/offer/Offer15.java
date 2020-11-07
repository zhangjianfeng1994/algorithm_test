package com.zjf.algorithm.offer;

import java.util.BitSet;

/**
 * description: Offer15 <br>
 * date: 2020/10/28 16:51 <br>
 * author: 张建峰 <br>
 */
public class Offer15 {

	/**
	 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，
	 * 把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
	 *
	 * 示例 1：
	 *
	 * 输入：00000000000000000000000000001011
	 * 输出：3
	 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
	 * 示例 2：
	 *
	 * 输入：00000000000000000000000010000000
	 * 输出：1
	 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
	 * 示例 3：
	 *
	 * 输入：11111111111111111111111111111101
	 * 输出：31
	 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
	 *
	*/
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {

		int sum = 0;
		while (n!=0){
			sum += (n&1);
			n = n>>>1;
		}
		return sum;
	}

	/**
	 * api bitset用法
	 *
	 * bitCount方法返回二进制位为1的数量;
	 * BigInteger,Long
	 */
	public int hammingWeight1(int n) {
		return Long.bitCount(new Long(n));
	}


	public static void main(String[] args) {
		//源码 ,补码
		System.out.println(Integer.toBinaryString(3)); //11
		//负数是已补码的形式存在的 取反加一
		System.out.println(Integer.toBinaryString(-3)); //11111111111111111111111111111101

		//算术左移和算术右移主要用来进行符号位的倍增,减半
		//算术左移
		System.out.println(3<<1); //6
		System.out.println(Integer.toBinaryString(3<<1)); // 110
		System.out.println(-3<<1); // -6
		System.out.println(Integer.toBinaryString(-3<<1));//11111111111111111111111111111010
		//算术右移 >>
		System.out.println(3>>1); //1
		System.out.println(Integer.toBinaryString(3>>1)); // 1
		System.out.println(-3>>1); // -2
		System.out.println(Integer.toBinaryString(-3>>1)); //11111111111111111111111111111110

		//逻辑左移和右移主要进行无符号位的倍增,减半
		//逻辑右移
		System.out.println(3>>>1); //1
		System.out.println(Integer.toBinaryString(3>>>1)); //1
		System.out.println(-3>>>1); //2147483646
		System.out.println(Integer.toBinaryString(-3>>>1)); //01111111111111111111111111111110





	}
}
