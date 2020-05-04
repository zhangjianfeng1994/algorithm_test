package com.zjf.algorithm.array;

import java.util.Arrays;


public class MergeSort {

	//将arr[l...mid] 和arr[mid+1....r] 两部分进行归并
	private static void merge(int[] arr, int l, int mid, int r,int[] tmp) {
		int i= l;
		int j = mid+1;
		int k=0;
		// 把较小的数先移到新数组中
		while(i<=mid && j<=r){
			if(arr[i]<arr[j]){
				tmp[k++] = arr[i++];
			}else{
				tmp[k++] = arr[j++];
			}
		}
		// 把左边剩余的数移入数组
		while(i<=mid){
			tmp[k++] = arr[i++];
		}
		// 把右边边剩余的数移入数组
		while(j<=r){
			tmp[k++] = arr[j++];
		}
		// 把新数组中的数覆盖nums数组
		for(int x=0;x<tmp.length;x++){
			arr[x+l] = tmp[x];
		}
	}

	private static void sort(int[] arr, int l, int r,int[] tmp) {
		int mid = (l+r)/2;
		if(l<r){
			sort(arr,l,mid,tmp);
			sort(arr,mid+1,r,tmp);
			//左右归并
			merge(arr,l,mid,r,tmp);
		}
	}


	public static void mergeSort(int[] arr) {
		int n = arr.length;
		int[] tmp = new int[n];
		sort(arr, 0, n - 1,tmp);
	}

	public static void main(String[] args) {
		// Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
		// 可以在1秒之内轻松处理100万数量级的数据
		// 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
		// 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
		int N = 10;
		int[] arr = SortTestHelper.generateRandomArray(N, 0, 100);
		//SortTestHelper.testSort(MergeSort.class, arr,"sort1");

		return;
	}
}
