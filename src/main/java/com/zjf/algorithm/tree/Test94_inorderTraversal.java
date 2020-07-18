package com.zjf.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的中序遍历
 */
public class Test94_inorderTraversal {

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
	 * 迭代通用写法
	 * @param root
	 * @return
	 */
	public List < Integer > inorderTraversal1(TreeNode root) {
		List <Integer> res = new ArrayList <Integer> ();
		if (root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack <TreeNode> ();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()){
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}

	/**
	 * 莫里斯遍历 通用写法
	 */
	public List <Integer> inorderMoLiSi(TreeNode root) {
		List <Integer> res = new ArrayList <Integer> ();
		if (root == null){
			return res;
		}
		TreeNode curr = root;
		while (curr != null ){
			if (curr.left == null) {
				res.add(curr.val);
				curr = curr.right;
			}else {
				TreeNode pre = curr.left;
				while(pre.right != null && pre.right != curr){
					pre = pre.right;
				}
				if (pre.right == null){
					pre.right = curr;
					curr = curr.left;
				}else {
					res.add(curr.val);
					pre.right = null;
					curr = curr.right;
				}

			}
		}
		return res;
	}


}
