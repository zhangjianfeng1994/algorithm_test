package com.zjf.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test94 {

	/**
	 * 给定一个二叉树，返回它的中序 遍历。
	 *
	 * 示例:
	 *
	 * 输入: [1,null,2,3]
	 *    1
	 *     \
	 *      2
	 *     /
	 *    3
	 * 输出: [1,3,2]
	 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
	 *
	 */
	/**
	 * 递归方法
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> treeList = new ArrayList<Integer>();
		inOrder(root,treeList);
		return treeList;
	}


	public void inOrder(TreeNode root,List<Integer> treeList){
		if (root != null){
			inOrder(root.left,treeList);
			treeList.add(root.val);
			inOrder(root.right,treeList);
		}
	}


	/**
	 * 基于栈的遍历
	 * 1.创建一个Stack，然后按 左 中 右的顺序输出节点。
	 * 2.尽可能的将这个节点的左子树压入Stack，此时栈顶的元素是最左侧的元素，
	 *  其目的是找到一个最小单位的子树(也就是最左侧的一个节点)，并且在寻找的过程中记录了来源，
	 *  才能返回上层,同时在返回上层的时候已经处理完毕左子树了。。
	 * 3.当处理完最小单位的子树时，返回到上层处理了中间节点。
	 *  （如果把整个左中右的遍历都理解成子树的话，就是处理完 左子树->中间(就是一个节点)->右子树）
	 * 4.如果有右节点，其也要进行中序遍历。
	 *
	 */
	public List < Integer > inorderTraversal1(TreeNode root) {
		List <Integer> res = new ArrayList <Integer> ();
		if (root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack <TreeNode> ();
		TreeNode curr = root;
		while (!stack.isEmpty() || curr != null) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			TreeNode node = stack.pop();
			res.add(node.val);
			if (node.right != null){
				curr = node.right;
			}
		}
		return res;
	}



}
