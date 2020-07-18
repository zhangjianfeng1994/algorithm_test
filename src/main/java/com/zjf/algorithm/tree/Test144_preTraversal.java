package com.zjf.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 树的前序遍历
 */
public class Test144_preTraversal {
	/**
	 *树的前序遍历
	 *
	 */
	//递归
	public List<Integer> preOrderIteration(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		preTraversal(root,list);
		return list;
	}
	public void preTraversal(TreeNode root,List<Integer> list){
		if (root != null){
			list.add(root.val);
			preTraversal(root.left,list);
			preTraversal(root.right,list);
		}
	}

	//迭代
	/**
	 * 首先我们应该创建一个Stack用来存放节点，首先我们想要打印根节点的数据，
	 * 此时Stack里面的内容为空，所以我们优先将头结点加入Stack，然后打印。
	 * 之后我们应该先打印左子树，然后右子树。所以先加入Stack的就是右子树，然后左子树。
	 */
	public List<Integer> preOrderIteration1(TreeNode head) {
		List<Integer> list = new ArrayList<Integer>();
		if (head == null) {
			return list;
		}
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(head);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return list;
	}

	/**
	 * 前序遍历迭代通用写法
	 */
	public List <Integer> preOrderIteration2(TreeNode root) {
		List <Integer> res = new ArrayList <Integer> ();
		if (root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack <TreeNode> ();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()){
			while (curr != null) {
				res.add(curr.val);
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			curr = curr.right;
		}
		return res;
	}
	/**
	 * 前序遍历-莫里斯遍历-通用写法
	 */
	public List <Integer> preOrderMoLiSi(TreeNode root) {
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
					res.add(curr.val);
					curr = curr.left;
				}else {
					pre.right = null;
					curr = curr.right;
				}
			}
		}
		return res;
	}
}
