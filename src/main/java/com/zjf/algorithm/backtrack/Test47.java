package com.zjf.algorithm.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test47 {

	/**
	 *
	 *给定一个可包含重复数字的序列，返回所有不重复的全排列。
	 * 示例:
	 *
	 * 输入: [1,1,2]
	 * 输出:
	 * [
	 *   [1,1,2],
	 *   [1,2,1],
	 *   [2,1,1]
	 * ]
	 */
	List<List<Integer>> res ;
	public List<List<Integer>> permuteUnique(int[] nums) {
		if(nums.length == 0){
			return new ArrayList<>();
		}
		res = new ArrayList<List<Integer>>();
		permutation(nums,0,nums.length-1);
		return res;
	}


	public void permutation(int[] nums,int from,int to){
		if (from == to){
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];
				list.add(num);
			}
			res.add(list);
			return;
		}
		//保存当前要交换的位置已经有过哪些数字了
		HashSet<Integer> set = new HashSet<>();
		for (int i = from; i <= to; i++) {
			//如果存在了就跳过，不去交换
			if (set.contains(nums[i])) {
				continue;
			}
			set.add(nums[i]);
			swap(nums,i,from);
			permutation(nums,from+1,to);
			swap(nums,i,from);
		}
	}
	private void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
}
