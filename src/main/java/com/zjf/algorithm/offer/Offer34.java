package com.zjf.algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-28 19:55  //时间
 */
public class Offer34 {

	/**
	 *输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
	 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
	 *
	 *  
	 *
	 * 示例:
	 * 给定如下二叉树，以及目标和 sum = 22，
	 *
	 *               5
	 *              / \
	 *             4   8
	 *            /   / \
	 *           11  13  4
	 *          /  \    / \
	 *         7    2  5   1
	 * 返回:
	 *
	 * [
	 *    [5,4,11,2],
	 *    [5,8,4,5]
	 * ]
	 *  
	 *
	 * 提示：
	 *
	 * 节点总数 <= 10000
	 */
	List<List<Integer>> resultList ;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		resultList = new ArrayList<>();
		if (root == null){
			return  resultList;
		}
		pre(root,sum,new ArrayList<>(),0);
		return resultList;
	}

	public void pre(TreeNode root, int sum,List<Integer> list,int currSum){
		if (root == null){
			return;
		}
		list.add(root.val);
		currSum +=root.val;
		if (currSum == sum && root.left == null && root.right == null){
			List<Integer> result = new ArrayList<>();
			result.addAll(list);
			resultList.add(result);
		}
		pre(root.left,sum,list,currSum);
		pre(root.right,sum,list,currSum);
		list.remove(list.size()-1);
		currSum-=root.val;
	}
}
