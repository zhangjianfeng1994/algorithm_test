package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-10 00:03  //时间
 */
public class Offer27 {

	/**
	 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
	 *
	 * 例如输入：
	 *
	 *      4
	 *    /   \
	 *   2     7
	 *  / \   / \
	 * 1   3 6   9
	 * /\
	 *11 12
	 * 镜像输出：
	 *      4
	 *    /   \
	 *   7     2
	 *  / \   / \
	 * 9   6 3   1
	 *          / \
	 *         12 11
	 * 示例 1：
	 * 输入：root = [4,2,7,1,3,6,9]
	 * 输出：[4,7,2,9,6,3,1]
	 * 限制：
	 * 0 <= 节点个数 <= 1000
	 */
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null){
			return null;
		}
		exchange(root);
		return root;
	}

	public void exchange(TreeNode root){
		if (root == null){
			return;
		}
		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
		exchange(root.left);
		exchange(root.right);
	}
}
