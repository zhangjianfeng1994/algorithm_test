package com.zjf.algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test95 {

	/**
	 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
	 *
	 * 示例:
	 * 输入: 3
	 * 输出:
	 *[
	 *  [2,1,null],
	 *  [1,null,2]
	 * ]
	 * [
	 *   [1,null,3,2],
	 *   [3,2,null,1],
	 *   [3,1,null,null,2],
	 *   [2,1,3],
	 *   [1,null,2,null,3]
	 * ]
	 * 解释:
	 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
	 * 1
	 *   2   1
	 *  /      \
	 * 1        2
	 *    1         3     3      2      1
	 *     \       /     /      / \      \
	 *      3     2     1      1   3      2
	 *     /     /       \                 \
	 *    2     1         2                 3
	 */
	/**
	 * 1 1种
	 * 2 子节点:左右  1+0 0+1 2种
	 * 3 子节点: 2+0 1+1: 0+2 5种
	 * 4 3+0 0+3 2+1 1+2  10+2+2
	 */
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> ans = new ArrayList<TreeNode>();
		if (n == 0) {
			return ans;
		}
		return getAns(1, n);

	}

	private List<TreeNode> getAns(int start, int end) {
		List<TreeNode> ans = new ArrayList<TreeNode>();
		//此时没有数字，将 null 加入结果中
		if (start > end) {
			ans.add(null);
			return ans;
		}
		//只有一个数字，当前数字作为一棵树加入结果中
		if (start == end) {
			TreeNode tree = new TreeNode(start);
			ans.add(tree);
			return ans;
		}
		//尝试每个数字作为根节点
		for (int i = start; i <= end; i++) {
			//得到所有可能的左子树
			List<TreeNode> leftTrees = getAns(start, i - 1);
			//得到所有可能的右子树
			List<TreeNode> rightTrees = getAns(i + 1, end);
			//左子树右子树两两组合
			for (TreeNode leftTree : leftTrees) {
				for (TreeNode rightTree : rightTrees) {
					TreeNode root = new TreeNode(i);
					root.left = leftTree;
					root.right = rightTree;
					//加入到最终结果中
					ans.add(root);
				}
			}
		}
		return ans;
	}


	public List<TreeNode> generateTrees1(int n) {
		ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
		dp[0] = new ArrayList<TreeNode>();
		if (n == 0) {
			return dp[0];
		}
		dp[0].add(null);
		//长度为 1 到 n
		for (int len = 1; len <= n; len++) {
			dp[len] = new ArrayList<TreeNode>();
			//将不同的数字作为根节点，只需要考虑到 len
			for (int root = 1; root <= len; root++) {
				int left = root - 1;  //左子树的长度
				int right = len - root; //右子树的长度
				for (TreeNode leftTree : dp[left]) {
					for (TreeNode rightTree : dp[right]) {
						TreeNode treeRoot = new TreeNode(root);
						treeRoot.left = leftTree;
						//克隆右子树并且加上偏差
						treeRoot.right = clone(rightTree, root);
						dp[len].add(treeRoot);
					}
				}
			}
		}
		return dp[n];
	}

	private TreeNode clone(TreeNode n, int offset) {
		if (n == null) {
			return null;
		}
		TreeNode node = new TreeNode(n.val + offset);
		node.left = clone(n.left, offset);
		node.right = clone(n.right, offset);
		return node;
	}

}
