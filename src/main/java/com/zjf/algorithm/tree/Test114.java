package com.zjf.algorithm.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test114 {

	/**
	 * 给定一个二叉树，原地将它展开为一个单链表。
	 * 例如，给定二叉树
	 *
	 *     1
	 *    / \
	 *   2   5
	 *  / \   \
	 * 3   4   6
	 * 将其展开为：
	 * 1
	 *  \
	 *   2
	 *    \
	 *     3
	 *      \
	 *       4
	 *        \
	 *         5
	 *          \
	 *           6
	 */
	public void flatten(TreeNode root) {
		List<TreeNode> list = new LinkedList<TreeNode>();
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode curr = root;
		TreeNode pre = null;
		while (curr !=null || !stack.isEmpty()){
			while (curr !=null){
				list.add(curr);
				stack.push(curr);
				curr = curr.left;
			}
			TreeNode node = stack.pop();

			curr = node.right;
		}
		curr = root;
		for (int i = 1; i < list.size(); i++) {
			TreeNode node = list.get(i);
			curr.left=null;
			curr.right = node;
			curr = node;
		}
	}

}
