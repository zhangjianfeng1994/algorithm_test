package com.zjf.algorithm.tree;



import javafx.util.Pair;

import java.util.LinkedList;

public class Test104 {

	/**
	 * 给定一个二叉树，找出其最大深度。
	 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
	 * 说明: 叶子节点是指没有子节点的节点。
	 * 示例：
	 * 给定二叉树 [3,9,20,null,null,15,7]，
	 *
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15  7
	 * 返回它的最大深度 3 。
	 */
	public int maxDepth(TreeNode root) {
		int max = 0;
        return traverse( root, max);
	}

	public int traverse(TreeNode root,int dept){
		if (root == null){
			return dept;
		}
		dept++;
		int left = traverse(root.left,dept);
		int right = traverse(root.right,dept);
		return left>right?left:right;
	}


	/**
	 * 递归实现二叉树最大深度
	 * 时间复杂度O(n)
	 * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
	 *
	 * @param root 根节点
	 * @return 最大深度
	 */
	private static int maxDepth0(TreeNode root) {
		//递归退出条件，到叶子节点
		if (root == null) {
			return 0;
		}
		//计算左子树最大深度
		int leftMaxDepth = maxDepth0(root.left);
		//计算右子树最大深度
		int rightMaxDepth = maxDepth0(root.right);
		//以某个节点为根节点的数的最大深度为max
		//max=max(leftMaxDepth,rightMaxDepth)+1
		return Math.max(leftMaxDepth, rightMaxDepth) + 1;
	}


	/**
	 * BFS迭代实现二叉树最大深度 广度优先遍历
	 * 时间复杂度O(n)
	 * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
	 *          3
	 * 	 *    / \
	 * 	 *   9  7
	 * 	 *
	 * @param root 根节点
	 * @return 最大深度
	 */
	private static int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		//BFS的层次遍历思想，记录二叉树的层数，
		//遍历完，层数即为最大深度
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int maxDepth = 0;
		while (!queue.isEmpty()) {
			maxDepth++;
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.pollFirst();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return maxDepth;
	}


}
