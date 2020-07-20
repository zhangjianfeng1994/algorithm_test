package com.zjf.algorithm.tree;

import java.util.Arrays;

/**
 * description: Test_offer40_getLeastNumbers <br>
 * date: 2020/7/20 15:23 <br>
 * author: 张建峰 <br>
 */
public class Test_offer40_getLeastNumbers {

	/**
	 * 输入整数数组 arr ，
	 * 找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
	 * 则最小的4个数字是1、2、3、4。
	 *
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		int[] result = new int[k];
		if (k<=0){
			return  result;
		}
		int i = 0;
		while(i < k){
			result[i] = arr[i];
			i++;
		}
		//构建堆
		for (int j = k/2-1; j >= 0; j--) {
			adjustHeap(result,j,k);
		}
		while (i<arr.length){
			if (arr[i] < result[0]){
				result[0] = arr[i];
				adjustHeap(result,0,k);
			}
			i++;
		}
		return result;
	}

	public void adjustHeap(int[] arr,int index,int l){
		int temp = arr[index];
		//左子节点
		int childL = index*2+1;
		while (childL < l){
			int childR = childL + 1;
			if (childR < l && arr[childR] > arr[childL]){
				childL = childR;
			}
			if (arr[childL] <= temp){
				break;
			}
			arr[index] = arr[childL];
			index = childL;

			childL = childL*2+1;
		}
		arr[index] = temp;
	}


	/**
	 * 用快排最最最高效解决 TopK 问题：O(N)O(N)
	 * 注意找前 K 大/前 K 小问题不需要对整个数组进行 O(NlogN)O(NlogN) 的排序！
	 * 例如本题，直接通过快排切分排好第 K 小的数（下标为 K-1），
	 * 那么它左边的数就是比它小的另外 K-1 个数啦～
	 */
	public int[] getLeastNumbers1(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		// 最后一个参数表示我们要找的是下标为k-1的数
		return quickSearch(arr, 0, arr.length - 1, k - 1);
	}

	private int[] quickSearch(int[] nums, int lo, int hi, int k) {
		// 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
		int j = partition(nums, lo, hi);
		if (j == k) {
			return Arrays.copyOf(nums, j + 1);
		}
		// 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
		return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
	}

	// 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
	private int partition(int[] nums, int lo, int hi) {
		int v = nums[lo];
		int i = lo, j = hi + 1;
		while (true) {
			while (++i <= hi && nums[i] < v) {
				;
			}
			while (--j >= lo && nums[j] > v) {
				;
			}
			if (i >= j) {
				break;
			}
			int t = nums[j];
			nums[j] = nums[i];
			nums[i] = t;
		}
		nums[lo] = nums[j];
		nums[j] = v;
		return j;
	}



	public static void main(String[] args) {
		int[] arr = {0,1,1,2,4,4,1,3,3,2};
		Test_offer40_getLeastNumbers test = new Test_offer40_getLeastNumbers();
		int[] result1 = test.getLeastNumbers(arr,6);
		System.out.println(Arrays.toString(result1));
	}
}
