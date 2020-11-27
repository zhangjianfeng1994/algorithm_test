package com.zjf.algorithm.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: Offer31_2 <br>
 * date: 2020/11/27 15:52 <br>
 * author: 张建峰 <br>
 */
public class Offer32_3 {
	
	/**
	 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
	 *
	 *  
	 *
	 * 例如:
	 * 给定二叉树: [3,9,20,null,null,15,7],
	 *
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * 返回其层次遍历结果：
	 *
	 * [
	 *   [3],
	 *   [20,9],
	 *   [15,7]
	 * ]
	*/
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null){
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int deep = 0;
		while (!queue.isEmpty()){
			int size = queue.size();
			deep++;
			List<Integer> list = new ArrayList<>(size);
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null){
					queue.offer(node.left);
				}
				if (node.right != null){
					queue.offer(node.right);
				}
			}
			result.add(list);
		}
	}
}
