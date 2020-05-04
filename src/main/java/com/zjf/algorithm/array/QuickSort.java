package com.zjf.algorithm.array;

import java.util.Arrays;

/**
 *快速排序
 */
public class QuickSort {





	/**
	 * 快速排序
	 * @param array
	 */
	public static void quickSort(int[] array) {
		int len;
		if(array == null
				|| (len = array.length) == 0
				|| len == 1) {
			return ;
		}
		sort4(array, 0, len - 1);
	}

	/**
	 * 快排核心算法，左右指针法
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void sort(int[] array, int left, int right) {
		if(left >= right) {
			return;
		}
		// base中存放基准数
		int base = array[left];
		int i = left, j = right;
		while(i != j) {
			// 顺序很重要，先从右边开始往左找，直到找到比base值小的数
			while(array[j] >= base && i < j) {
				j--;
			}

			// 再从左往右边找，直到找到比base值大的数
			while(array[i] <= base && i < j) {
				i++;
			}

			// 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
			if(i < j) {
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
			}
		}

		// 将基准数放到中间的位置（基准数归位）
		array[left] = array[i];
		array[i] = base;

		// 递归，继续向基准的左右两边执行和上面同样的操作
		// i的索引处为上面已确定好的基准值的位置，无需再处理
		sort(array, left, i - 1);
		sort(array, i + 1, right);
	}



	/**
	 *快排核心算法，挖坑法
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void sort1(int[] array, int left, int right) {
		if(left >= right) {
			return;
		}
		// base中存放基准数
		int base = array[left];
		int i = left, j = right;
		while (i < j){
			while (i < j && array[j] >= base){
				j--;
			}
			array[i] = array[j];
			while (i < j && array[i] <= base){
				i++;
			}
			array[j] = array[i];
		}
		//基数归位
		array[i] = base;
		sort1(array, left, i - 1);
		sort1(array, j + 1, right);
	}

	private static void sort4(int[] array, int left, int right) {
		int l = left - 1;
		int r = right + 1;
		int pivot = array[(left + right) / 2];
		while (l < r) {
			l++;
			r--;
			while (array[l] < pivot) {
				l++;
			}
			while (array[r] > pivot) {
				r--;
			}
			if (l >= r) {
				break;
			}
			int tmp = array[l];
			array[l] = array[r];
			array[r] = tmp;
		}
		if (l - 1 > left) {
			sort4(array, left, l - 1);
		}
		if (r + 1 < right) {
			sort4(array,r + 1, right);
		}
	}


	public static void main(String[] args) {
		int N = 10;
		int[] arr = SortTestHelper.generateRandomArray(N, 0, 10);
		int[] arr1 = {1, 2, 1, 5, 2, 6, 7, 10, 5, 7};
		//System.out.println(Arrays.toString(arr1));
		//quickSort(arr1);
		//System.out.println(Arrays.toString(arr1));
		SortTestHelper.testSort(QuickSort.class,arr1,"quickSort");
	}


}
