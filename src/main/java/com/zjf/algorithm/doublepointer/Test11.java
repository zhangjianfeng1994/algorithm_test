package com.zjf.algorithm.doublepointer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-09-26 22:19  //时间
 */
public class Test11 {

	/**
	 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
	 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
	 * 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
	 * 说明：你不能倾斜容器，且 n 的值至少为 2。
	 */
	public int maxArea(int[] height) {
		int max = 0;
		int n = height.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				max = Math.max(max,(j-i)*(Math.min(height[i],height[j])));
			}

		}
		return max;
	}
	/**
	 * 比较高度,移动低的那端
	 */
	public int maxArea1(int[] height) {

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
		return max;
	}





	public static void main(String[] args) {
		Test11 test = new Test11();
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(test.maxArea1(height));
	}
}
