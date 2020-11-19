package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-17 22:51  //时间
 */
public class Offer29 {

	/**
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
	 * 示例 1：
	 *
	 * 输入：matrix = [[1,2,3],
	 *                [4,5,6],
	 *                [7,8,9]]
	 * 输出：[1,2,3,6,9,8,7,4,5]
	 * 示例 2：
	 * m = 4   n = 3  00 01 02 03 13 23 22 21  20 10  11 12
	 * 输入：matrix = [[1,2,3,4],
	 *                 [5,6,7,8],
	 *                 [9,10,11,12]]
	 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
	 *
	 * 限制：
	 * 0 <= matrix.length <= 100
	 * 0 <= matrix[i].length <= 100
	 */
	public int[] spiralOrder(int[][] matrix) {
		int n = matrix.length , m =  matrix[0].length;
		return new int[0];
	}
}
