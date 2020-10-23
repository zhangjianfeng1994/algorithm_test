package com.zjf.algorithm.array;

import java.util.Arrays;
import java.util.List;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-10-23 22:24  //时间
 */
public class FindIntersection {

	static int getIntersection(int[] array_1, int[] array_2, List<Integer> c) {
		int[] long_ = null;
		int[] short_ = null;
		if(array_1.length <= array_2.length) {
			short_ = array_1;
			long_ = array_2;
		}else {
			short_ = array_2;
			long_ = array_1;
		}
		int len = long_.length;
		for(int i = 0;i < short_.length; i++) {
			int result = binarySearch(long_,0,len,short_[i]);
			if(result > 0) {
				c.add(long_[result]);
			}
		}
		return 0;
	}

	private static int binarySearch(int[] a, int fromIndex, int toIndex,
	                                 int key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];

			if (midVal < key) {
				low = mid + 1;
			} else if (midVal > key) {
				high = mid - 1;
			} else {
				return mid; // key found
			}
		}
		return -(low + 1);  // key not found.
	}

}



