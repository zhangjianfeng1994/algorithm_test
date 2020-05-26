package com.zjf.algorithm.tree;

import java.util.List;

public class Test113 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		return null;
	}

	public void preTraversal(TreeNode root,List<Integer> list){
		if (root != null){
			list.add(root.val);
			preTraversal(root.left,list);
			preTraversal(root.right,list);
		}
	}

}
