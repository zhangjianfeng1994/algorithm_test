package com.zjf.algorithm.offer;

import java.util.ArrayList;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2021-02-01 15:39  //时间
 */
public class Offer62 {

	/**
	 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字
	 * （删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
	 *
	 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
	 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
	 *示例 1：
	 *
	 * 输入: n = 5, m = 3
	 * 输出: 3
	 * 示例 2：
	 *
	 * 输入: n = 10, m = 17
	 * 6 1
	 * 输出: 2
	 */
	//暴力解法,利用list每次remove复杂度是 O(n^2)
	public int lastRemaining(int n, int m) {
		ArrayList<Integer> list = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int idx = 0;
		while (n > 1){
			idx = (idx+m-1)%n;//?
			list.remove(idx);
			n--;
		}
		return list.get(0);
	}

	/**
	 * 最后剩下的 3 的下标是 0。
	 * 第四轮反推，补上 mm 个位置，然后模上当时的数组大小 22，位置是(0 + 3) % 2 = 1。
	 * 第三轮反推，补上 mm 个位置，然后模上当时的数组大小 33，位置是(1 + 3) % 3 = 1。
	 * 第二轮反推，补上 mm 个位置，然后模上当时的数组大小 44，位置是(1 + 3) % 4 = 0。
	 * 第一轮反推，补上 mm 个位置，然后模上当时的数组大小 55，位置是(0 + 3) % 5 = 3。
	 * 所以最终剩下的数字的下标就是3。因为数组是从0开始的，所以最终的答案就是3。
	 */
	public int lastRemaining1(int n, int m) {
		int ans = 0;
		// 最后一轮剩下2个人，所以从2开始反推
		for (int i = 2; i <= n; i++) {
			ans = (ans + m) % i;
		}
		return ans;
	}


	public static void main(String[] args) {
		Offer62 test = new Offer62();
		System.out.println(test.lastRemaining(5,3));
	}
}
