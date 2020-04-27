package com.zjf.algorithm.array;

/**
 * description: ArrayTest74 <br>
 * date: 2020/4/24 16:18 <br>
 * author: 张建峰 <br>
 */
public class ArrayTest74 {

	/**
	 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
	 *
	 * 每行中的整数从左到右按升序排列。
	 * 每行的第一个整数大于前一行的最后一个整数。
	 * 示例 1:
	 *
	 * 输入:
	 * matrix = [
	 *   [1,   3,  5,  7],
	 *   [10, 11, 16, 20],
	 *   [23, 30, 34, 50]
	 * ]
	 * target = 3
	 * 输出: true
	 * target = 13
	 * 输出: false
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if( matrix.length == 0 ){
			return false;
		}
		int m = matrix.length-1;
		if( matrix[0].length == 0 ){
			return false;
		}
		int n = matrix[0].length-1;
		if(target < matrix[0][0] || target > matrix[m][n]){
			return false;
		}
		//定位数组
		int low=0;
		int high= m;
		int mid = 0;
		while(low <= high) {
			mid=(low+high)/2;
			if(target >= matrix[mid][0] && target <=matrix[mid][n]) {
				break;
			}
			if(target > matrix[mid][n]) {
				low=mid+1;
			}
			if(target <matrix[mid][0]) {
				high=mid-1;
			}
		}
		int[] ints = matrix[mid];
		int i = 0;
		int j = n;
		while(i <= j) {
			mid=(i+j)/2;
			if(target==ints[mid]) {
				return true;
			}
			if(target>ints[mid]) {
				i=mid+1;
			}
			if(target<ints[mid]) {
				j=mid-1;
			}

		}

		return false;
	}

	/**
	 * 官方解答
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrixStandard(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0){ return false;}
		int n = matrix[0].length;

		// 二分查找
		int left = 0, right = m * n - 1;
		int pivotIdx, pivotElement;
		while (left <= right) {
			pivotIdx = (left + right) / 2;
			pivotElement = matrix[pivotIdx / n][pivotIdx % n];
			if (target == pivotElement) {
				return true;
			} else {
				if (target < pivotElement){
					right = pivotIdx - 1;
				} else {
					left = pivotIdx + 1;
				}
			}
		}
		return false;
	}


	public static void main(String[] args) {
		int[][] matrix = {{1, 3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		ArrayTest74 practice = new ArrayTest74();
		System.out.println(practice.searchMatrix(matrix,31));
	}
}
