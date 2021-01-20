package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2021-01-14 23:29  //时间
 */
public class Offer54 {
	/**
	 * 给定一棵二叉搜索树，请找出其中第k大的节点。
	 * 示例 1:
	 *
	 * 输入: root = [3,1,4,null,2], k = 1
	 *    3
	 *   / \
	 *  1   4
	 *   \
	 *    2
	 * 输出: 4
	 *
	 * 示例 2:
	 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
	 * 2n+1 2n+2
	 *        5
	 *       / \
	 *      3   6
	 *     / \
	 *    2   4
	 *   /
	 *  1
	 * 输出: 4
	 *
	 * 左中右 升序排序  中序遍历
	 * 右中左  降序排序
	 * 把中序排序改一下,计算k-- = 0值
	 */
	int res, k;
	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if (root == null){
			return;
		}
		dfs(root.right);
		if (k == 0){
			return;
		}
		if(--k == 0) res = root.val;
		dfs(root.left);
	}
}
