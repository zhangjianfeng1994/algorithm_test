package com.zjf.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test103 {

	/**
	 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，
	 * 再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
	 *
	 * 例如：
	 * 给定二叉树 [3,9,20,null,null,15,7],
	 *
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * 返回锯齿形层次遍历如下：
	 * [
	 *   [3],
	 *   [20,9],
	 *   [15,7]
	 * ]
	 */
	/**
	 * description:
	 * 执行用时 :1 ms, 在所有 Java 提交中击败了97.74%的用户
	 * 内存消耗 :39.5 MB, 在所有 Java 提交中击败了7.41%的用户
	*/
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null){
			return  res;
		}
		Queue<TreeNode>  queue = new LinkedList<TreeNode>();
		//记录深度
		int depth = 1;
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			LinkedList<Integer> depthList = new LinkedList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				//深度(行数)是奇数时
				if (depth%2>0){
					depthList.add(node.val);
				}else{
					depthList.addFirst(node.val);
				}
				if (node.left != null){
					queue.offer(node.left);
				}
				if (node.right != null){
					queue.offer(node.right);
				}
			}
			depth++;
			res.add(depthList);
		}
		return  res;
	}
}
