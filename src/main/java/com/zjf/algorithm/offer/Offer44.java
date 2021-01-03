package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-12-30 00:17  //时间
 */
public class Offer44 {

	/**
	 *数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，
	 * 第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
	 *
	 * 请写一个函数，求任意第n位对应的数字。
	 *示例 1：
	 *
	 * 输入：n = 3
	 * 输出：3
	 * 示例 2：
	 *
	 * 输入：n = 11
	 * 输出：0
	 */
	/**
	 * 1.各 digitdigit 下的数位数量 count 的计算公式：
	 *
	 *   count=9×start(位数开始)×digit(位数)
	 * 2. 确定所求数位所在的数字
	 * 如下图所示，所求数位 在从数字 start
	 * 开始的第 [(n - 1) / digit]个 数字 中（ start为第 0 个数字）。
	 *num = start + (n - 1) / digit
	 * 3.确定所求数位在 num 的哪一数位
	 * 所求数位为数字 num 的第 (n - 1) % digit
	 *
	 */
	public int findNthDigit(int n) {
		int digit = 1;
		long start = 1;
		long count = 9;
		while (n > count) { // 1.
			n -= count;
			digit += 1;
			start *= 10;
			count = digit * start * 9;
		}
		long num = start + (n - 1) / digit; // 2.
		return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
	}

	public static void main(String[] args) {
		Offer44 test = new Offer44();
		System.out.println(test.findNthDigit(15));
	}

}
