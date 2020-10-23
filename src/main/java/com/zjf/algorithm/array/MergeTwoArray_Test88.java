package com.zjf.algorithm.array;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-10-23 21:59  //时间
 */
public class MergeTwoArray_Test88 {

	/**
	 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
	 *
	 *  
	 *
	 * 说明：
	 *
	 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
	 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
	 *  
	 *
	 * 示例：
	 *
	 * 输入：
	 * nums1 = [1,2,3,0,0,0], m = 3
	 * nums2 = [2,5,6],       n = 3
	 *
	 * 输出：[1,2,2,3,5,6]
	 *  
	 *
	 * 提示：
	 *
	 * -10^9 <= nums1[i], nums2[i] <= 10^9
	 * nums1.length == m + n
	 * nums2.length == n
	 *
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int len1 = m - 1;
		int len2 = n - 1;
		int len = m + n - 1;
		while(len1 >= 0 && len2 >= 0) {
			// 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
			nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
		}
		// 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
		System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
	}

}
