package com.zjf.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Test77 {


	/**
	 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
	 *
	 * 示例:
	 *
	 * 输入: n = 4, k = 2
	 * 输出:
	 * [
	 *   [2,4],
	 *   [3,4],
	 *   [2,3],
	 *   [1,2],
	 *   [1,3],
	 *   [1,4],
	 * ]
	 */
	List<List<Integer>> res;
	public List<List<Integer>> combine(int n, int k) {
		if(n<=0 || k<=0){
			return null;
		}
		res = new ArrayList<>();
		dfs(n,k,1,new ArrayList<>());
		return res;
	}


	public void dfs(int n,int k,int start,List<Integer> list){
		if (list.size() == k){
			List<Integer> copy = new ArrayList<>();
			copy.addAll(list);
			res.add(copy);
			return;
		}
		for (int i = start; i <= n; i++) {
			list.add(i);
			dfs(n,k, i+1, list);
			list.remove(list.size()-1);
		}
	}
	// p 可以声明成一个栈
	// i 的极限值满足： n - i + 1 = (k - list.size())。
	// 【关键】n - i + 1 是闭区间 [i,n] 的长度。
	// k - pre.size() 是剩下还要寻找的数的个数。
	public void dfs1(int n,int k,int start,List<Integer> list){
		if (list.size() == k){
			List<Integer> copy = new ArrayList<>();
			copy.addAll(list);
			res.add(copy);
			return;
		}
		for (int i = start; i <= n - (k - list.size()) + 1; i++) {
			list.add(i);
			dfs1(n,k, i+1, list);
			list.remove(list.size()-1);
		}
	}
}
