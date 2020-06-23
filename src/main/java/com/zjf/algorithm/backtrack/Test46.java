package com.zjf.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Test46 {

	List<List<Integer>> res ;

	/**
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
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
		for (int i = from; i <= to; i++) {
			swap(nums,i,from);
			permutation(nums,from+1,to);
			swap(nums,i,from);
		}
	}
	private void swap(int[] a, int left, int right) {
		if (left == right){
			return;
		}
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
}
