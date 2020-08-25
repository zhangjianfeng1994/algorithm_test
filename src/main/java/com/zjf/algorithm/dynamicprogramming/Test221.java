package com.zjf.algorithm.dynamicprogramming;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-08-25 00:01  //时间
 */
public class Test221 {

	/**
	 *在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
	 *
	 * 示例:
	 *
	 * 输入:
	 *
	 * 1 0 1 0 0
	 * 1 0 1 1 1
	 * 1 1 1 1 1
	 * 1 0 0 1 0
	 * 输出: 4
	 *
	 */
	int [][] dp;
	public int maximalSquare(char[][] matrix) {
		if (matrix.length ==0 ||  matrix[0].length == 0){
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		setDp(matrix);
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <= i; j++) {
				char[] chars = matrix[j];

			}
			int area = dp[i + 1][i + 1]-dp[i][i + 1] - dp[i + 1][i] + dp[i][i];
			//判断面积是不是2的整次幂,是表示是一个正方形
			if (binaryIs2Power(area)){
				max = Math.max(max,area);
			}
		}
		return max;
	}

	private void setDp(char[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		dp = new int[m+1][n+1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i+1][j+1] = dp[i+1][j]+dp[i][j+1]+-dp[i][j]+(matrix[i][j]-'0');
			}
		}
	}

	public boolean binaryIs2Power(int num) {
		if(num < 2) {
			if (num == 1){
				return true;
			}
			return false;
		}

		int temp = 1;
		while (num > temp) {
			temp <<= 1;
		}

		return temp == num ? true : false;
	}


	public static void main(String[] args) {
		char[][] matrix =
				{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		Test221 test = new Test221();
		System.out.println(test.maximalSquare(matrix));
	}
}
