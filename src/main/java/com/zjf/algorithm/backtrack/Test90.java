package com.zjf.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test90 {

	/**
	 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
	 * 说明：解集不能包含重复的子集。
	 * 示例:
	 * 输入: [1,2,2]
	 *  1   2    2
	 *  2 2 2
	 *  2
	 * 输出:
	 * [
	 *   [2],
	 *   [1],
	 *   [1,2,2],
	 *   [2,2],
	 *   [1,2],
	 *   []
	 * ]
	 */
	List<List<Integer>> res;
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if(nums == null ){
			return null;
		}
		Arrays.sort(nums);
		res = new ArrayList<>();
		dfs(nums,0,new ArrayList<>());
		return  res;
	}

	public void dfs(int[] nums,int start,List<Integer> list){

		List<Integer> copy = new ArrayList<>();
		copy.addAll(list);
		res.add(copy);
		for (int i = start; i < nums.length; i++) {
			if (i> start && nums[i] == nums[i-1]){
				continue;
			}
			int num = nums[i];
			list.add(num);
			dfs(nums, i+1,list);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1,2,2};
		Test90 test = new Test90();
		List<List<Integer>> res1 = test.subsetsWithDup(nums);
		for (List<Integer> list:res1) {
			System.out.print(list.toString());
		}
	}
}
