package com.zjf.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: Test107 <br>
 * date: 2020/5/22 10:51 <br>
 * author: 张建峰 <br>
 */
public class Test107 {

	/**
	 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
	 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
	 * 例如：
	 * 给定二叉树 [3,9,20,null,null,15,7],
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * 返回其自底向上的层次遍历为：
	 * [
	 *   [15,7],
	 *   [9,20],
	 *   [3]
	 * ]
	*/
	/**
	 执行用时 :1 ms, 在所有 Java 提交中击败了99.19%的用户
	 内存消耗 :40.1 MB, 在所有 Java 提交中击败了7.41%的用户
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		if (root == null){
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>(size);
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null){
					queue.offer(node.left);
				}
				if (node.right != null){
					queue.offer(node.right);
				}
			}
			res.addFirst(list);
		}
		return  res;
	}
}
