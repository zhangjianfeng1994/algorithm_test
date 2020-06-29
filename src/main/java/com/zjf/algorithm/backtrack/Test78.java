package com.zjf.algorithm.backtrack;

import com.sun.org.apache.bcel.internal.generic.LSUB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test78 {

	/**
	 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
	 * 说明：解集不能包含重复的子集。
	 * 示例:
	 * 输入: nums = [1,2,3]
	 * 输出:
	 * [
	 *   [3],
	 *   [1],
	 *   [2],
	 *   [1,2,3],
	 *   [1,3],
	 *   [2,3],
	 *   [1,2],
	 *   []
	 * ]
	 */
	List<List<Integer>> res;
	public List<List<Integer>> subsets(int[] nums) {
		if(nums == null ){
			return null;
		}
		res = new ArrayList<>();
		dfs(nums,0,new ArrayList<>());
		return  res;
	}

	public void dfs(int[] nums,int start,List<Integer> list){
		List<Integer> copy = new ArrayList<>();
		copy.addAll(list);
		res.add(copy);
		for (int i = start; i < nums.length; i++) {
			int num = nums[i];
			list.add(num);
			dfs(nums, i+1,list);
			list.remove(list.size()-1);
		}
	}


	public List<List<Integer>> subsets1(int[] nums) {
		if(nums == null ){
			return null;
		}
		res = new ArrayList<>();
		res.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0, size = res.size() ; j < size; j++) {
				List<Integer> list = res.get(j);
				List<Integer> list1= new ArrayList<>(list);
				list1.add(nums[i]);
				res.add(list1);
			}
		}
		return  res;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Test78 test = new Test78();
		List<List<Integer>> res1 = test.subsets(nums);
		for (List<Integer> list:res1) {
			System.out.print(list.toString());
		}
	}
}
