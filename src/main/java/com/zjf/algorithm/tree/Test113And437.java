package com.zjf.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class Test113And437 {

	/**
	 *
	 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
	 * 说明: 叶子节点是指没有子节点的节点。
	 * 示例:
	 * 给定如下二叉树，以及目标和 sum = 22，
	 *               5
	 *              / \
	 *             4   8
	 *            /   / \
	 *           11  13  4
	 *          /  \    / \
	 *         7    2  5   1
	 * 返回:
	 * [
	 *    [5,4,11,2],
	 *    [5,8,4,5]
	 * ]
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> listAll = new ArrayList<List<Integer>>();
		if (root == null){
			return listAll;
		}
		List<Integer> list = new ArrayList<Integer>();
		preTraversal(root,listAll,list,sum,0);
		return listAll;
	}

	public void preTraversal(TreeNode root,List<List<Integer>> listAll,List<Integer> list,int finalSum,int sum){
		sum = sum + root.val;
		list.add(root.val);
		if (root.left == null && root.right == null){
			if (sum == finalSum){
				listAll.add(new ArrayList<Integer>(list));
			}
			list.remove(list.size()-1);
			return;
		}
		if (root.left != null){
			preTraversal(root.left,listAll,list,finalSum,sum);
		}
		if (root.right != null){
			preTraversal(root.right,listAll,list,finalSum,sum);
		}
		list.remove(list.size()-1);
	}


	/**
	 * 给定一个二叉树，它的每个结点都存放着一个整数值。
	 * 找出路径和等于给定数值的路径总数。
	 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
	 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
	 * 示例：
	 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
	 *
	 *       10
	 *      /  \
	 *     5   -3
	 *    / \    \
	 *   3   8   11
	 *  / \   \
	 * 3  -2   1
	 *
	 * 返回 3。和等于 8 的路径有:
	 *
	 * 1.  5 -> 3
	 * 2.  5 -> 2 -> 1
	 * 3.  -3 -> 11
	 */
	public int pathSum1(TreeNode root, int sum) {
		if (root == null){
			return 0;
		}
		return preTraversal1(root,sum,new int[1000],0);
	}

	public int preTraversal1(TreeNode x,int finalSum,int[] xList,int p){
		if(x ==null){
			return 0;
		}
		int tmp = x.val;
		int n = tmp == finalSum ? 1 : 0;
		for (int i =  p - 1; i >=0; i--) {
			tmp += xList[i];
			if (tmp == finalSum){
				n++;
			}
		}
		xList[p] =  x.val;
		int n1 = preTraversal1(x.left,finalSum,xList,p+1);
		int n2 = preTraversal1(x.right,finalSum,xList,p+1);
		return n+n1+n2;
	}

	public static void main(String[] args) {
		Test113And437 practice = new Test113And437();
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);*/
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		System.out.println(practice.pathSum1(root, 22));
	}
}
