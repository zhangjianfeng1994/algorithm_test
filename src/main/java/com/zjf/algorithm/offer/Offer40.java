package com.zjf.algorithm.offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-12-23 23:03  //时间
 */
public class Offer40 {

	/**
	 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
	 * 示例 1：
	 *
	 * 输入：arr = [3,2,1], k = 2
	 * 输出：[1,2] 或者 [2,1]
	 * 示例 2：
	 *
	 * 输入：arr = [0,1,2,1], k = 1
	 * 输出：[0]
	 *
	 */

	public int[] getLeastNumbers(int[] arr, int k) {

		int[] res = new int[k];
		Arrays.sort(arr);
		for (int i = 0; i < k; ++i) {
			res[i] = arr[i];
		}
		return res;
	}

	public int[] getLeastNumbers1(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		return quickSearch(arr,0,arr.length-1,k-1);

	}

	private int[] quickSearch(int[] nums, int l, int r, int k) {

		int j = partition(nums, l, r);
		if (j == k) {
			return Arrays.copyOf(nums, j + 1);
		}
		return j > k?quickSearch(nums,l,j-1,l):quickSearch(nums,j+1,r,k);
	}

	private int partition(int[] nums, int l, int r) {
		int v = nums[l];
		int i = l, j = r + 1;
		while (true) {
			while (++i <= r && nums[i] < v) {
				;
			}
			while (--j >= l && nums[j] > v) {
				;
			}
			if (i >= j) {
				break;
			}
			int t = nums[j];
			nums[j] = nums[i];
			nums[i] = t;
		}
		nums[l] = nums[j];
		nums[j] = v;
		return j;
	}

	public int[] getLeastNumbers2(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		// 默认是小根堆，实现大根堆需要重写一下比较器。
		Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
		for (int num: arr) {
			if (pq.size() < k) {
				pq.offer(num);
			} else if (num < pq.peek()) {
				pq.poll();
				pq.offer(num);
			}
		}

		// 返回堆中的元素
		int[] res = new int[pq.size()];
		int idx = 0;
		for(int num: pq) {
			res[idx++] = num;
		}
		return res;
	}

	/**
	 *两种方法的优劣性比较
	 * 在面试中，另一个常常问的问题就是这两种方法有何优劣。看起来分治法的快速选择算法的时间、空间复杂度都优于使用堆的方法，但是要注意到快速选择算法的几点局限性：
	 *
	 * 第一，算法需要修改原数组，如果原数组不能修改的话，还需要拷贝一份数组，空间复杂度就上去了。
	 *
	 * 第二，算法需要保存所有的数据。如果把数据看成输入流的话，使用堆的方法是来一个处理一个，不需要保存数据，只需要保存 k
	 * 个元素的最大堆。而快速选择的方法需要先保存下来所有的数据，再运行算法。当数据量非常大的时候，甚至内存都放不下的时候，就麻烦了。所以当数据量大的时候还是用基于堆的方法比较好。
	 */

}
