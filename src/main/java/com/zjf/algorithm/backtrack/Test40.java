package com.zjf.algorithm.backtrack;

import java.util.*;

public class Test40 {
	/**
	 * 给定一个数组 candidates 和一个目标数 target ，
	 * 找出 candidates 中所有可以使数字和为 target 的组合。
	 *
	 * candidates 中的每个数字在每个组合中只能使用一次。
	 * 说明：
	 * 所有数字（包括目标数）都是正整数。
	 * 解集不能包含重复的组合。 
	 * 示例 1:
	 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
	 * 所求解集为:
	 * [
	 *   [1, 7],
	 *   [1, 2, 5],
	 *   [2, 6],
	 *   [1, 1, 6]
	 * ]
	 * 示例 2:
	 * 输入: candidates = [2,5,2,1,2], target = 5,
	 * 所求解集为:
	 * [
	 *   [1,2,2],
	 *   [5]
	 * ]
	 */
	List<List<Integer>> res;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates.length == 0){
			return new ArrayList<>();
		}
		res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
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
			if (i > start && candidates[i] == candidates[i-1]){
				continue;
			}
			list.add(candidate);
			backtrack(candidates,target,sum+candidate,list,i+1);
			list.remove(list.size()-1);
		}
	}


	/**
	 * @param candidates 候选数组
	 * @param len
	 * @param begin      从候选数组的 begin 位置开始搜索
	 * @param residue    表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
	 * @param path       从根结点到叶子结点的路径
	 * @param res
	 */
	private void dfs(int[] candidates, int len, int begin, int residue, Deque<Integer> path, List<List<Integer>> res) {
		if (residue == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = begin; i < len; i++) {
			// 大剪枝
			if (residue - candidates[i] < 0) {
				break;
			}

			// 小剪枝
			if (i > begin && candidates[i] == candidates[i - 1]) {
				continue;
			}

			path.addLast(candidates[i]);

			// 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
			dfs(candidates, len, i + 1, residue - candidates[i], path, res);

			path.removeLast();
		}
	}

	public List<List<Integer>> combinationSum3(int[] candidates, int target) {
		int len = candidates.length;
		List<List<Integer>> res = new LinkedList<>();
		if (len == 0) {
			return res;
		}

		// 先将数组排序，这一步很关键
		Arrays.sort(candidates);
		Deque<Integer> path = new LinkedList<Integer>();
		dfs(candidates, len, 0, target, path, res);
		return res;
	}




	public static void main(String[] args) {
		Test40 test = new Test40();
		int[] candidates = {2,5,2,1,2};
		int target = 5;
		List<List<Integer>> resu = test.combinationSum2(candidates,target);
		for (int i = 0; i < resu.size(); i++) {
			List<Integer> list1 = resu.get(i);
			System.out.println(list1.toString());
		}
	}
}
