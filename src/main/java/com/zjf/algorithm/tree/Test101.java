package com.zjf.algorithm.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

/**
 * 检查它是否是镜像对称
 */
public class Test101 {
	/**
	 * 给定一个二叉树，检查它是否是镜像对称的。
	 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	 *     1
	 *    / \
	 *   2   2
	 *  / \ / \
	 * 3  4 4  3
	 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	 *     1
	 *    / \
	 *   2   2
	 *    \   \
	 *    3    3
	 *  
	 * 进阶：
	 * 你可以运用递归和迭代两种方法解决这个问题吗？
	 */
	/**
	 * 迭代方式
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root.left);
		queue.offer(root.right);
		while (!queue.isEmpty()){
			int size = queue.size();
			int cen = size/2;
			for(int i=0; i<cen; i++){
				TreeNode left = queue.poll();
				TreeNode right = queue.poll();
				if (left == null && right != null){
					return false;
				}
				if (left != null && right == null){
					return false;
				}
				if (left != null && right != null){
					if (left.val != right.val){
						return false;
					}
					queue.offer(left.left);
					queue.offer(right.right);
					queue.offer(left.right);
					queue.offer(right.left);
				}
			}
		}
		return true;
	}

	/**
	 * 递归方式
	 * @param root
	 * @return
	 */
	public boolean isSymmetric1(TreeNode root) {
		if (root == null) {
			return true;
		}
		return same(root.left,root.right);
	}

	public boolean same(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val ) {
			return false;
		}
		return same(left.left,right.right)&&same(left.right,right.left);
	}

}
