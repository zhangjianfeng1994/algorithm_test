package com.zjf.algorithm.backtrack;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test39 {

	/**
	 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
	 * 找出 candidates 中所有可以使数字和为 target 的组合。
	 * candidates 中的数字可以无限制重复被选取。
	 * 说明：
	 * 所有数字（包括 target）都是正整数。
	 * 解集不能包含重复的组合。 
	 * 示例 1:
	 * 输入: candidates = [2,3,6,7], target = 7,
	 * 所求解集为:
	 * [
	 *   [7],
	 *   [2,2,3]
	 * ]
	 * 示例 2:
	 * 输入: candidates = [2,3,5], target = 8,
	 * 所求解集为:
	 * [
	 *   [2,2,2,2],
	 *   [2,3,3],
	 *   [3,5]
	 * ]
	 */
	List<List<Integer>> res;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0){
			return new ArrayList<>();
		}
		res = new ArrayList<List<Integer>>();
		backtrack(candidates,target,0,new ArrayList<Integer>(),0);
		return res;
	}

	public void backtrack(int[] candidates, int target,int sum,
	                       List<Integer> list,int start){
		if (sum > target){
			return ;
		}
		if(sum == target){
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			int candidate = candidates[i];
			list.add(candidate);
			backtrack(candidates,target,sum+candidate,list,i);
			list.remove(list.size()-1);
		}
	}


	public static void main(String[] args) {
		Test39 test = new Test39();
		int[] candidates = {30,50,100};
		int target = 70;
//		for (int i = 0; i < resu.size(); i++) {
//			List<Integer> list1 = resu.get(i);
//		}


	}
}
