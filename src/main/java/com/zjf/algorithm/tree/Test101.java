package com.zjf.algorithm.tree;


/**
 * @author ZJF
 */
public class Test101 {

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
