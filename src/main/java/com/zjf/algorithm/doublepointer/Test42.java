package com.zjf.algorithm.doublepointer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-09-28 21:20  //时间
 */
public class Test42 {

	/**
	 *给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
	 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
	 * 可以接 6 个单位的雨水（蓝色部分表示雨水）。 
	 *示例:
	 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
	 * 输出: 6
	 *
	 */
	public int trap(int[] height) {
		int max = 0;
		int n = height.length;
		int i = 0;
		int j = n-1;
		while (i<j){
			max = Math.max(max,(j-i)*(Math.min(height[i],height[j])));
			if (height[i]>height[j]){
				j--;
			}else {
				i++;
			}
		}
		return 1;
	}
}
