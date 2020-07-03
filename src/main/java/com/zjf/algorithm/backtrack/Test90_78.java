package com.zjf.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test90_78 {

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
		dfs(nums,0,new ArrayList<Integer>());
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


	public List<List<Integer>> subsetsWithDup1(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(new ArrayList<Integer>());// 初始化空数组
		Arrays.sort(nums);
		int start = 1; //保存新解的开始位置
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> ans_tmp = new ArrayList<>();
			// 遍历之前的所有结果
			for (int j = 0; j < ans.size(); j++) {
				List<Integer> list = ans.get(j);
				//如果出现重复数字，就跳过所有旧解
				if (i > 0 && nums[i] == nums[i - 1] && j < start) {
					continue;
				}
				List<Integer> tmp = new ArrayList<>(list);
				// 加入新增数字
				tmp.add(nums[i]);
				ans_tmp.add(tmp);
			}

			//更新新解的开始位置
			start = ans.size();
			ans.addAll(ans_tmp);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,2};
		Test90_78 test = new Test90_78();
		List<List<Integer>> res1 = test.subsetsWithDup(nums);
		for (List<Integer> list:res1) {
			System.out.print(list.toString());
		}
	}
}
