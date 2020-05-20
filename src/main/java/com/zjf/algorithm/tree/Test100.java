package com.zjf.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Test100 {

	/**
	 * 给定两个二叉树，编写一个函数来检验它们是否相同。
	 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
	 *
	 * 示例 1:
	 * 输入:       1         1
	 *           / \       / \
	 *          2   3     2   3
	 *
	 *         [1,2,3],   [1,2,3]
	 * 输出: true
	 * 示例 2:
	 * 输入:      1          1
	 *           /           \
	 *          2             2
	 *
	 *         [1,2],     [1,null,2]
	 * 输出: false
	 */
	/**
	 * 层序遍历
	 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
	 * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了5.55%的用户
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {

		Queue<TreeNode> queueP = new LinkedList<TreeNode>();
		Queue<TreeNode> queueQ = new LinkedList<TreeNode>();
		queueP.offer(p);
		queueQ.offer(q);
		while (!queueP.isEmpty() || !queueQ.isEmpty()){
			int sizeP = queueP.size();
			int sizeQ = queueQ.size();
			if (sizeP != sizeQ){
				return false;
			}
			for (int i = 0; i < sizeP; i++) {
				TreeNode treeP = queueP.poll();
				TreeNode treeQ = queueQ.poll();
				if (treeP == null && treeQ == null){
					continue;
				}
				if (treeP == null || treeQ == null){
					return false;
				}
				if (treeP.val != treeQ.val){
					return false;
				}
				queueP.offer(treeP.left);
				queueP.offer(treeP.right);
				queueQ.offer(treeQ.left);
				queueQ.offer(treeQ.right);
			}
		}
		return true;
	}
}
