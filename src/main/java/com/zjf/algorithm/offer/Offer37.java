package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-12-02 23:54  //时间
 */
public class Offer37 {

	/**
	 * 请实现两个函数，分别用来序列化和反序列化二叉树。
	 * 示例: 
	 *
	 * 你可以将以下二叉树：
	 *
	 *     1
	 *    / \
	 *   2   3
	 *      / \
	 *     4   5
	 *
	 * 序列化为 "[1,2,3,null,null,4,5]"
	 *
	 */
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return "";
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return new TreeNode(1);
	}
}
