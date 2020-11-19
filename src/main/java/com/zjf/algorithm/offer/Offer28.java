package com.zjf.algorithm.offer;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-17 22:50  //时间
 */
public class Offer28 {

	/**
	 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，
	 * 那么它是对称的。
	 *
	 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	 *     1
	 *    / \
	 *   2   2
	 *  / \ / \
	 * 3  4 4  3
	 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	 *     1
	 *    / \
	 *   2   2
	 *    \   \
	 *    3    3
	 * 示例 1：
	 *
	 * 输入：root = [1,2,2,3,4,4,3]
	 * 输出：true
	 * 示例 2：
	 *
	 * 输入：root = [1,2,2,null,3,null,3]
	 * 输出：false
	 *
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null){
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size/2; i++) {
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

	public boolean isSymmetric1(TreeNode root) {
		if (root == null){
			return true;
		}
		return isSame(root.left,root.right);
	}
	public boolean isSame(TreeNode left,TreeNode right){
		if (left == null && right != null){
			return false;
		}
		if (left != null && right == null){
			return false;
		}
		if (left == null && right == null){
			return true;
		}
		if (left.val != right.val){
			return false;
		}
		return isSame(left.left,right.right) && isSame(left.right,right.left);
	}
}
