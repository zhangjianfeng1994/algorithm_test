package com.zjf.algorithm.dynamicprogramming;


public class Test304 {
	/**
	 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
	 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
	 * 示例:
	 * 给定 matrix = [
	 *   [3, 0, 1, 4, 2],
	 *   [5, 6, 3, 2, 1],
	 *   [1, 2, 0, 1, 5],
	 *   [4, 1, 0, 1, 7],
	 *   [1, 0, 3, 0, 5]
	 * ]
	 * sumRegion(2, 1, 4, 3) -> 8
	 * sumRegion(1, 1, 2, 2) -> 11
	 * sumRegion(1, 2, 2, 4) -> 12
	 */
	int[][] summatrix;
	public Test304(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		summatrix = new int[matrix.length+1][matrix[0].length+1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				summatrix[i+1][j+1] =
						summatrix[i+1][j]+summatrix[i][j+1]+matrix[i][j]-summatrix[i][j];
			}
		}
	}


	public int sumRegion(int row1, int col1, int row2, int col2) {
		// 2 1 4 3
		// 2,3;   4, 1
		return summatrix[row2 + 1][col2 + 1] - summatrix[row1][col2 + 1] - summatrix[row2 + 1][col1] + summatrix[row1][col1];

	}





	public static void main(String[] args) {
		int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
		Test304 obj = new Test304(matrix);
		System.out.println(obj.sumRegion(2,1,4,3));
	}
}
