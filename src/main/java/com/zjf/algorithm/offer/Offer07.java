package com.zjf.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-10-19 22:28  //时间
 */
public class Offer07 {

	/**
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
	 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 *限制：
	 * 0 <= 节点个数 <= 5000
	 * 例如，给出
	 * 前序遍历 preorder = [3,9,20,15,7]
	 * 中序遍历 inorder = [9,3,15,20,7]
	 * 返回如下的二叉树：
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 */
	/**
	 * Test105
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length == 0){
			return null;
		}
		inorderMap = new HashMap<>(inorder.length);
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i],i);
		}
		return buildTree1(preorder,inorder,0,preorder.length-1,0,inorder.length);
	}

	Map<Integer,Integer> inorderMap ;
	public TreeNode buildTree1(int[] preorder,int[] inorder,
	                           int preL,int preR,int inL,int inR){
		if (preL > preR){
			return null;
		}
		int root = preorder[preL];
		int inorderIndex = inorderMap.get(root);
		TreeNode rootNode = new TreeNode(root);
		//根据中序遍历计算左树节点的数量
		int left_tree_size =  inorderIndex - inL;
		//左子树构建
		rootNode.left = buildTree1(preorder,inorder,preL+1,
				preL+left_tree_size,inL,inorderIndex-1);
		//右子树构建
		rootNode.right = buildTree1(preorder,inorder,preL+left_tree_size+1,
				preR,inorderIndex+1,inR);
		return rootNode;
	}



}
