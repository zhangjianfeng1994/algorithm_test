package com.zjf.algorithm.dynamicprogramming;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-08-01 23:09  //时间
 */
public class Test120 {


	/**
	 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
	 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
	 * 例如，给定三角形：
	 * [
	 *      [2],
	 *     [3,4],
	 *    [5,5,7],
	 *   [4,1,8,3]
	 * ]
	 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
	 * dp[n] = dp[n+1]+n;
	 */
	/**
	 *dp[row][col] = Min(dp[row - 1][col - 1],dp[row-1][col]), triangle[row][col]
	 * 注意的地方就是把左边界和右边界的情况单独考虑，因为到达左边界和右边界只有一个位置可选。
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int rows = triangle.size();
		int cols = triangle.get(rows - 1).size();
		int[][] dp = new int[rows][cols];
		dp[0][0] = triangle.get(0).get(0);
		for (int row = 1; row < rows; row++) {
			List<Integer> curRow = triangle.get(row);
			int col = 0;
			dp[row][col] = dp[row - 1][col] + curRow.get(col);
			col++;
			for (; col < curRow.size() - 1; col++) {
				dp[row][col] = Math.min(dp[row - 1][col - 1], dp[row - 1][col]) + curRow.get(col);
			}
			dp[row][col] = dp[row - 1][col - 1] + curRow.get(col);
		}
		int min = Integer.MAX_VALUE;
		for (int col = 0; col < cols; col++) {
			min = Math.min(min, dp[rows - 1][col]);
		}
		return min;
	}
	/**
	 * 接下来，注意到我们是一层一层的更新，更新当前层只需要上一层的信息，
	 * 所以我们不需要二维数组，只需要一维数组就可以了。
	 */
	public int minimumTotal1(List<List<Integer>> triangle) {
		int rows = triangle.size();
		int cols = triangle.get(rows - 1).size();
		int[] dp = new int[cols];
		dp[0] = triangle.get(0).get(0);
		for (int row = 1; row < rows; row++) {
			List<Integer> curRow = triangle.get(row);
			int col = curRow.size() - 1;
			dp[col] = dp[col - 1] + curRow.get(col);
			col--;
			for (; col > 0; col--) {
				dp[col] = Math.min(dp[col - 1], dp[col]) + curRow.get(col);
			}

			dp[col] = dp[col] + curRow.get(col);
		}
		int min = Integer.MAX_VALUE;
		for (int col = 0; col < cols; col++) {
			min = Math.min(min, dp[col]);
		}
		return min;
	}

	public static void main(String[] args) {
		Test120 test = new Test120();
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> list1 =  new ArrayList<>();
		List<Integer> list2 =  new ArrayList<>();
		List<Integer> list3 =  new ArrayList<>();
		List<Integer> list4 =  new ArrayList<>();
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);
		list1.add(2);
		list2.add(3);
		list2.add(4);
		list3.add(6);
		list3.add(5);
		list3.add(7);
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		System.out.println(test.minimumTotal(triangle));
	}
}
