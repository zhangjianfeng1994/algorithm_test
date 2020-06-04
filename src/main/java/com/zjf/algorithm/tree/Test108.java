package com.zjf.algorithm.tree;

import javafx.concurrent.Worker;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test108 {

	/**
	 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
	 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
	 * 示例:
	 * 给定有序数组: [-10,-3,5,9],
	 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
	 *       0
	 *      / \
	 *    -3   9
	 *    /   /
	 *  -10  5
	 */
	/**
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		int length = nums.length;
		if (length == 0){
			return null;
		}
		if (length == 1){
			return new TreeNode(nums[0]);
		}
		return sortedArray(nums,0,length-1);
	}

	public TreeNode sortedArray(int[] nums,int left,int right){
		if (left>right){
			return null;
		}
		if (left==right){
			return new TreeNode(nums[left]);
		}
		int mid = (left+right+1)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArray(nums,left,mid-1);
		root.right = sortedArray(nums,mid+1,right);
		return root;
	}

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5};
		Test108 test = new Test108();
		TreeNode root = test.sortedArrayToBST(nums);
		System.out.println(root.val);
	}
}
