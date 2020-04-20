package com.zjf.algorithm.array;

/**
 * description: ArrayTest <br>
 * date: 2020/4/20 10:27 <br>
 * author: 张建峰 <br>
 */
public class ArrayTest64 {


	/**
	 * description:
	 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
	 * 说明：每次只能向下或者向右移动一步。
	 * 输入:
	 * [
	 *   [1,3,1],
	 *   [1,5,1],
	 *   [4,2,1]
	 * ]
	 * 输出: 7
	 * 解释: 因为路径 1→3→1→1→1 的总和最小。
	*/
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int current = grid[i][j];
				if (i == 0 && j == 0) {
					dp[i][j] = current;
					continue;
				}
				if (i == 0 ) {
					dp[i][j] = current + dp[i][j-1];
				}
				else if (j == 0 ) {
					dp[i][j] = current + dp[i-1][0];
				} else {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + current);
					dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + current);
				}
			}
		}
		return dp[m - 1][n - 1];
	}





	public static void main(String[] args) {
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		int[][] grid = {{1, 2}, {1, 1}};
		ArrayTest64 practice = new ArrayTest64();
		int minPathSum = practice.minPathSum(grid);
		System.out.println(minPathSum);
	}
}
