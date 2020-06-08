package com.zjf.algorithm.tree;

import java.util.*;

public class Test199 {

	/**
	 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
	 *
	 * 示例:
	 *
	 * 输入: [1,2,3,null,5,null,4]
	 * 输出: [1, 3, 4]
	 * 解释:
	 *
	 *    1            <---
	 *  /   \
	 * 2     3         <---
	 *  \     \
	 *   5     4       <---
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null){
			return list;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int length = queue.size();
			list.add(queue.getLast().val);
			for (int i = 0; i < length; i++) {
				TreeNode node = queue.poll();
				if (node.left !=null){
					queue.offer(node.left);
				}
				if (node.right !=null){
					queue.offer(node.right);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

	}
}
