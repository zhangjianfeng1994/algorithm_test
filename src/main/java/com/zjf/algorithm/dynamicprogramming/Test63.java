package com.zjf.algorithm.dynamicprogramming;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-07-25 11:47  //时间
 */
public class Test63 {


	/**
	 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
	 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
	 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid[0].length;
		int n = obstacleGrid.length;
		int[][] dp = new int[n][m];
		int start = obstacleGrid[0][0];
		if (start == 1){
			return 0;
		}
		dp[0][0] = 1;
		for (int i = 1; i < m; i++) {
			int num = obstacleGrid[0][i];
			if (num == 1 || dp[0][i-1] ==0){
				dp[0][i] = 0;
			}else {
				//无障碍物且前面的位置也没有障碍物
				dp[0][i] = 1;
			}
		}
		for (int i = 1; i < n; i++) {
			int num = obstacleGrid[i][0];
			if (num == 0 && dp[i-1][0] !=0){
				dp[i][0] = 1;
			}else {
				dp[i][0] = 0;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int num = obstacleGrid[i][j];
				//当前位置无障碍物
				if (num == 0){
					dp[i][j] = dp[i-1][j]+dp[i][j-1];
				}else {
					dp[i][j] = 0;
				}
			}
		}
		return dp[n-1][m-1];
	}

	public static void main(String[] args) {
		Test63 test = new Test63();
		int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
		int num = test.uniquePathsWithObstacles(obstacleGrid);
		System.out.println(num);
	}

}
