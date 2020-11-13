package com.zjf.algorithm.offer;

import com.zjf.algorithm.tree.Test145_postTraversal;

import java.util.Timer;
import java.util.TreeMap;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-10 00:03  //时间
 */
public class Offer26 {

	/**
	 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
	 *
	 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
	 *
	 * 例如:
	 * 给定的树 A:
	 *      3
	 *     / \
	 *    4   5
	 *   / \
	 *  1   2
	 *
	 * 给定的树 B：
	 *    4 
	 *   /
	 *  1
	 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
	 */
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if (A == null || B == null){
			return false;
		}
		return preTraversal(A,B) || isSubStructure(A.left, B) ||isSubStructure(A.right, B);
	}

	public boolean preTraversal(TreeNode A, TreeNode B){
		if ( B== null){
			return true;
		}

		if(A != null){
			if (A.val == B.val){
				return preTraversal(A.left,B.left) &&preTraversal(A.right,B.right);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node3.left = node4;
		node3.right = node5;
		node4.left = node1;
		node4.right = node2;

		TreeNode node4_1 = new TreeNode(4);
		TreeNode node1_1 = new TreeNode(1);
		node4_1.left = node1_1;
		Offer26 test = new Offer26();
		System.out.println(test.isSubStructure(node3,node4_1));
	}
}
