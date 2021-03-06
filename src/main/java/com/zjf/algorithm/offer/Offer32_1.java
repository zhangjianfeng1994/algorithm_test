package com.zjf.algorithm.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: Offer31_1 <br>
 * date: 2020/11/24 19:39 <br>
 * author: 张建峰 <br>
 */
public class Offer32_1 {

	/**
	 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
	 *
	 *  
	 *
	 * 例如:
	 * 给定二叉树: [3,9,20,null,null,15,7],
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * 返回：
	 * [3,9,20,15,7]
	*/
	public int[] levelOrder(TreeNode root) {
		if (root == null){
			return new int[0];
		}
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
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
		}
		int[] resultArray = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			resultArray[i] = list.get(i);
		}
		return resultArray;
	}
}
