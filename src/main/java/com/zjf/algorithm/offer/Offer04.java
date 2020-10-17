package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-10-13 22:56  //时间
 */
public class Offer04 {

	/**
	 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
	 * 每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 *示例:
	 * 现有矩阵 matrix 如下：
	 *
	 * [
	 *   [1,   4,  7, 11, 15],
	 *   [2,   5,  8, 12, 19],
	 *   [3,   6,  9, 16, 22],
	 *   [10, 13, 14, 17, 24],
	 *   [18, 21, 23, 26, 30]
	 * ]
	 * 12 2,2
	 * 给定 target = 5，返回 true。
	 * 给定 target = 20，返回 false
	 */
	/**
	 * 暴力
	 * @date 2020/10/14 23:35
	 */
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == target){
					return true;
				}
			}

		}
		return false;
	}


	/**
	 * 官方解答
	 */
	public boolean findNumberIn2DArray1(int[][] matrix, int target) {
		int i = matrix.length - 1, j = 0;
		while(i >= 0 && j < matrix[0].length)
		{
			if(matrix[i][j] > target) {
				i--;
			} else if(matrix[i][j] < target) {
				j++;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Offer04 test = new Offer04();
		int[][] matrix = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		int[][] matrix1 = {
				{-1,3}
		};
		//System.out.println(test.findNumberIn2DArray(matrix,5));
		System.out.println(test.findNumberIn2DArray(matrix1,-1));
	}

}
