package com.zjf.algorithm.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test105 {

	/**
	 * 根据一棵树的前序遍历与中序遍历构造二叉树。
	 * 注意:
	 * 你可以假设树中没有重复的元素。
	 * 例如，给出
	 * 前序遍历 preorder = [3,9,2,6,20,15,7]
	 * 中序遍历 inorder = [2,9,6,3,15,20,7]
	 * 后序遍历 inorder = [2,6,9,15,7,20,3]
	 * 返回如下的二叉树：
	 *     3
	 *    / \
	 *   9  20
	 *  /\  /  \
	 *  2 6 15   7
	 */
	/**
	 * 递归
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length ==0 ){
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		for (int i = 0; i < preorder.length; i++) {

			if(preorder[0] == inorder[i]){
				int[] preleft = Arrays.copyOfRange(preorder,1,i+1);
				int[] preright = Arrays.copyOfRange(preorder,i+1,preorder.length);
				int[] inleft = Arrays.copyOfRange(inorder,0,i);
				int[] inright = Arrays.copyOfRange(inorder,i+1,inorder.length);
				root.left = buildTree(preleft,inleft);
				root.right = buildTree(preright,inright);
				break;
			}
		}
		return root;
	}

	public TreeNode buildTree1(int[] preorder, int[] inorder) {
		int n = preorder.length;
		// 构造哈希映射，帮助我们快速定位根节点
		indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			indexMap.put(inorder[i], i);
		}
		return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
	}

	private Map<Integer, Integer> indexMap;

	public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
		if (preorder_left > preorder_right) {
			return null;
		}

		// 前序遍历中的第一个节点就是根节点
		int preorder_root = preorder_left;
		// 在中序遍历中定位根节点
		int inorder_root = indexMap.get(preorder[preorder_root]);

		// 先把根节点建立出来
		TreeNode root = new TreeNode(preorder[preorder_root]);
		// 得到左子树中的节点数目
		int size_left_subtree = inorder_root - inorder_left;
		// 递归地构造左子树，并连接到根节点
		// 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
		root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
		// 递归地构造右子树，并连接到根节点
		// 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
		root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
		return root;
	}



}
