package com.zjf.algorithm.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		if(root == null) {
			return "[]";
		}
		StringBuilder  str = new StringBuilder("[");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			TreeNode curr = queue.poll();
			if (curr == null){
				str.append("null,");
			}else {
				str.append(curr.val+",");
				queue.offer(curr.left);
				queue.offer(curr.right);
			}

		}
		str.deleteCharAt(str.length() - 1);
		str.append("]");
		return str.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals("[]")){
			return null;
		}
		String[] nodeVal = data.substring(1,data.length()-1).split(",");
		TreeNode root = new TreeNode(Integer.parseInt(nodeVal[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int i = 1;
		while (!queue.isEmpty()){
			TreeNode curr = queue.poll();
			if (!nodeVal[i].equals("null")){
				curr.left = new TreeNode(Integer.parseInt(nodeVal[i]));
				queue.offer(curr.left);
			}
			i++;
			if (!nodeVal[i].equals("null")){
				curr.right = new TreeNode(Integer.parseInt(nodeVal[i]));
				queue.offer(curr.right);
			}
			i++;
		}
		return root;
	}
}
