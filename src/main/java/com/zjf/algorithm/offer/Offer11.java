package com.zjf.algorithm.offer;

/**
 * description: Offer11 <br>
 * date: 2020/10/22 10:51 <br>
 * author: 张建峰 <br>
 */
public class Offer11 {
	/**
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
	 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
	 *
	 * 示例 1：
	 *
	 * 输入：[3,4,5,1,2]
	 * 输出：1
	 * 示例 2：
	 *
	 * 输入：[2,2,2,0,1]
	 * 输出：0
	 *
	*/
	public int minArray(int[] numbers) {
		int minNum = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < minNum){
				return numbers[i];
			}
		}
		return minNum;
	}

	/**
	 * 在二分查找的每一步中，左边界为  low，右边界为 high，区间的中点为 pivot，最小值就在该区间内。
	 * 我们将中轴元素 numbers[pivot] 与右边界元素 numbers[high] 进行比较，可能会有以下的三种情况
	 * 因为数组中有两段升区间,我们要判断出最小元素出现在那个区间范围内
	 * 第一种情况是 [pivot]<numbers[high]。这说明
	 * numbers[pivot]是最小值右侧的元素，因此我们可以忽略二分查找区间的右半部分。
	 *第二种情况是 numbers[pivot] > numbers[high]。如下图所示，这说明
	 * numbers[pivot] 是最小值左侧的元素，因此我们可以忽略二分查找区间的左半部分
	 * 第三种情况是 numbers[pivot]==numbers[high] 由于重复元素的存在，我们并不能确定 numbers[pivot]
	 * 究竟在最小值的左侧还是右侧，因此我们不能莽撞地忽略某一部分的元素。
	 * 我们唯一可以知道的是，由于它们的值相同，所以无论 numbers[high]
	 * 是不是最小值，都有一个它的「替代品」numbers[pivot]，因此我们可以忽略二分查找区间的右端点。
	 *
	 *
	 *
	 */
	public int minArray1(int[] numbers) {
		int low = 0;
		int high = numbers.length - 1;
		while (low < high) {
			int pivot = low + (high - low) / 2;
			if (numbers[pivot] < numbers[high]) {
				high = pivot;
			} else if (numbers[pivot] > numbers[high]) {
				low = pivot + 1;
			} else {
				high -= 1;
			}
		}
		return numbers[low];
	}

	public int minArray2(int[] numbers) {
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int m = (i + j) / 2;
			if (numbers[m] > numbers[j]) {
				i = m + 1;
			} else if (numbers[m] < numbers[j]) {
				j = m;
			} else {
				j--;
			}
		}
		return numbers[i];
	}

}
