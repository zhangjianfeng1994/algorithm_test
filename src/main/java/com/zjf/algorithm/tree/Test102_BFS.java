package com.zjf.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test102_BFS {
	/**
	 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
	 *
	 * 示例：
	 * 二叉树：[3,9,20,null,null,15,7],
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *     15  7
	 * 返回其层次遍历结果：
	 * [
	 *   [3],
	 *   [9,20],
	 *   [15,7]
	 * ]
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null){
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			List<Integer> levelList = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				levelList.add(node.val);
				if (node.left != null){
					queue.add(node.left);
				}
				if (node.right != null){
					queue.add(node.right);
				}
			}
			list.add(levelList);
		}
		return list;
	}


}
