package com.zjf.algorithm.tree;

/**
 * description: 二叉搜索树总结
 * 二叉树相关题目最核心的思路是明确当前节点需要做的事情是什么。
 * <p>
 * 特性:
 * 1、对于 BST 的每一个节点node，左子树节点的值都比node的值要小，右子树节点的值都比node的值大。
 * 2、对于 BST 的每一个节点node，它的左侧子树和右侧子树都是 BST。
 * 一个重要的性质：BST 的中序遍历结果是有序的（升序）。
 * void traverse(TreeNode root) {
 * if (root == null) return;
 * traverse(root.left);
 * // 中序遍历代码位置
 * print(root.val);
 * traverse(root.right);
 * }
 * BST 相关的问题，
 * 要么利用 BST 左小右大的特性提升算法效率，
 * 要么利用中序遍历的特性满足题目的要求
 */
public class BinarySearchTree {

	/**
	 * 根据中序遍历有序特性
	 */
	//寻找第 K 小的元素

	/**
	 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
	 * 说明：
	 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
	 */
	int kthSmallest(TreeNode root, int k) {
		// 利用 BST 的中序遍历特性
		traverse(root, k);
		return res;
	}

	// 记录结果
	int res = 0;
	// 记录当前元素的排名
	int rank = 0;
	void traverse(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		traverse(root.left, k);
		/* 中序遍历代码位置 */
		rank++;
		if (k == rank) {
			// 找到第 k 小的元素
			res = root.val;
			return;
		}
		/*****************/
		traverse(root.right, k);
	}
	/**
	 * 上述问题的优化思路
	 * 每次寻找第k小的元素都要中序遍历一次，最坏的时间复杂度是O(N)，N是 BST 的节点个数。
	 * 查找排名为k的元素，当前节点知道自己排名第m，那么我可以比较m和k的大小：
	 * 1、如果m == k，显然就是找到了第k个元素，返回当前节点就行了。
	 * 2、如果k < m，那说明排名第k的元素在左子树，所以可以去左子树搜索第k个元素。
	 * 3、如果k > m，那说明排名第k的元素在右子树，所以可以去右子树搜索第k - m - 1个元素。
	 * 这样就可以将时间复杂度降到O(logN)了。
	 * 那么，如何让每一个节点知道自己的排名呢？
	 * 这就是我们之前说的，需要在二叉树节点中维护额外信息。每个节点需要记录，以自己为根的这棵二叉树有多少个节点。
	 * class TreeNode {
	 *     int val;
	 *     // 以该节点为根的树的节点总数
	 *     int size;
	 *     TreeNode left;
	 *     TreeNode right;
	 * }
	 * 有了size字段，外加 BST 节点左小右大的性质，
	 * 对于每个节点node就可以通过node.left推导出node的排名，从而做到我们刚才说到的对数级算法。
	 *
	 */

	//BST 转化累加树
	/**
	 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
	 * 提醒一下，二叉搜索树满足下列约束条件：
	 * 节点的左子树仅包含键 小于 节点键的节点。
	 * 节点的右子树仅包含键 大于 节点键的节点。
	 * 左右子树也必须是二叉搜索树。
	*/
	/**
	 * 降序打印节点
	 * 维护一个外部累加变量sum，然后把sum赋值给 BST 中的每一个节点，不就将 BST 转化成累加树了吗？
	 * void traverse(TreeNode root) {
	 *     if (root == null) return;
	 *     // 先递归遍历右子树
	 *     traverse(root.right);
	 *     // 中序遍历代码位置
	 *     print(root.val);
	 *     // 后递归遍历左子树
	 *     traverse(root.left);
	 * }
	*/
	TreeNode convertBST(TreeNode root) {
		traverse(root);
		return root;
	}

	// 记录累加和
	int sum = 0;
	void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(root.right);
		// 维护累加和
		sum += root.val;
		// 将 BST 转化成累加树
		root.val = sum;
		traverse(root.left);
	}

	/**
	 * 实现 BST 的基础操作：判断 BST 的合法性、增、删、查。
	*/
	//判断 BST 的合法性
	/**
	 * 我们按照刚才的思路，每个节点自己要做的事不就是比较自己和左右孩子吗？看起来应该这样写代码：
	 * boolean isValidBST(TreeNode root) {
	 *     if (root == null) return true;
	 *     if (root.left != null && root.val <= root.left.val)
	 *         return false;
	 *     if (root.right != null && root.val >= root.right.val)
	 *         return false;
	 *
	 *     return isValidBST(root.left)
	 *         && isValidBST(root.right);
	 * }
	 * 这个算法出现了错误，BST 的每个节点应该要小于右边子树的所有节点
	 * 出现问题的原因在于，对于每一个节点root，代码值检查了它的左右孩子节点是否符合左小右大的原则；
	 * 但是根据 BST 的定义，root的整个左子树都要小于root.val，整个右子树都要大于root.val。
	 * 问题是，对于某一个节点root，他只能管得了自己的左右子节点，怎么把root的约束传递给左右子树呢？
	 *
	*/
	boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}
	/* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
	boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
		// base case
		if (root == null) return true;
		// 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
		if (min != null && root.val <= min.val) return false;
		if (max != null && root.val >= max.val) return false;
		// 限定左子树的最大值是 root.val，右子树的最小值是 root.val
		return isValidBST(root.left, min, root)
				&& isValidBST(root.right, root, max);
	}

	//在 BST 中搜索一个数
	//如果是在二叉树中寻找元素，可以这样写代码：
	boolean isInBST(TreeNode root, int target) {
		if (root == null) return false;
		if (root.val == target) return true;
		// 当前节点没找到就递归地去左右子树寻找
		return isInBST(root.left, target)
				|| isInBST(root.right, target);
	}
	/**
	 * 二分查找思想，根据target和root.val的大小比较，就能排除一边。我们把上面的思路稍稍改动：
	*/
	boolean isInBST1(TreeNode root, int target) {
		if (root == null) return false;
		if (root.val == target)
			return true;
		if (root.val < target)
			return isInBST1(root.right, target);
		if (root.val > target)
			return isInBST1(root.left, target);
		// root 该做的事做完了，顺带把框架也完成了，妙
		return false;
	}
	/**
	 * 抽象出一套针对 BST 的遍历框架
	 * 这个代码框架其实和二叉树的遍历框架差不多，无非就是利用了 BST 左小右大的特性而已
	*/
	void BST(TreeNode root, int target) {
		if (root.val == target)
			// 找到目标，做点什么
			if (root.val < target)
				BST(root.right, target);
		if (root.val > target)
			BST(root.left, target);
	}

	//在 BST 中插入一个数
	/**
	 * BST 中的遍历框架，就是「找」的问题。直接套框架，加上「改」的操作即可。
	 * 一旦涉及「改」，函数就要返回TreeNode类型，并且对递归调用的返回值进行接收。
	*/
	TreeNode insertIntoBST(TreeNode root, int val) {
		// 找到空位置插入新节点
		if (root == null) return new TreeNode(val);
		// if (root.val == val)
		//     BST 中一般不会插入已存在元素
		if (root.val < val)
			root.right = insertIntoBST(root.right, val);
		if (root.val > val)
			root.left = insertIntoBST(root.left, val);
		return root;
	}

	//在 BST 中删除一个数,跟插入操作类似，先「找」再「改」,先把框架写出来
	TreeNode deleteNode(TreeNode root, int key) {
		if (root.val == key) {
			// 找到啦，进行删除
		} else if (root.val > key) {
			// 去左子树找
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			// 去右子树找
			root.right = deleteNode(root.right, key);
		}
		return root;
	}
	/**
	 * 情况 1：A恰好是末端节点，两个子节点都为空，那么它可以当场去世了。
	 * 情况 2：A只有一个非空子节点，那么它要让这个孩子接替自己的位置。
	 * 情况 3：A有两个子节点，麻烦了，为了不破坏 BST 的性质，
	 * A必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己。
	 * 我们以第二种方式讲解。
	*/
	TreeNode deleteNode1(TreeNode root, int key) {
		if (root == null) return null;
		if (root.val == key) {
			// 这两个 if 把情况 1 和 2 都正确处理了
			if (root.left == null) return root.right;
			if (root.right == null) return root.left;
			// 处理情况 3
			TreeNode minNode = getMin(root.right);
			root.val = minNode.val;
			root.right = deleteNode1(root.right, minNode.val);
		} else if (root.val > key) {
			root.left = deleteNode1(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode1(root.right, key);
		}
		return root;
	}

	TreeNode getMin(TreeNode node) {
		// BST 最左边的就是最小的
		while (node.left != null) node = node.left;
		return node;
	}
	/**
	 * 删除操作就完成了。注意一下，这个删除操作并不完美，因为我们一般不会通过root.val = minNode.val修改节点内部的值来交换节点，
	 * 而是通过一系列略微复杂的链表操作交换root和minNode两个节点。
	 *
	 * 因为具体应用中，val域可能会是一个复杂的数据结构，修改起来非常麻烦；而链表操作无非改一改指针，而不会去碰内部数据。
	*/

	//如果当前节点要做的事情需要通过左右子树的计算结果推导出来，就要用到后序遍历。
	/**
	 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
	 *
	 * leetcode 1037题
	*/
	/**
	 * 二叉树相关题目最核心的思路是明确当前节点需要做的事情是什么。
	 *
	 * 现在我们想计算子树中 BST 的最大和，站在当前节点的视角，需要做什么呢？
	 *
	 * 1、首先我想知道以我为根的这棵树是不是 BST，所以我肯定得知道左右子树是不是合法的 BST。因为如果这俩儿子有一个不是 BST，以我为根的这棵树肯定不会是 BST 的，对吧。
	 *
	 * 2、如果左右子树都是合法的 BST，我得瞅瞅左右子树加上自己还是不是合法的 BST 了。因为按照 BST 的定义，当前节点的值应该大于左子树的最大值，小于右子树的最小值，否则就破坏了 BST 的性质。
	 *
	 * 3、因为题目要计算最大的节点之和，如果左右子树加上我自己还是一棵合法的 BST，也就是说以我为根的整棵树是一棵 BST，那我需要知道我们这棵 BST 的所有节点值之和是多少，方便和别的 BST 子树争个高下，对吧。
	 *
	 * 根据以上三点，站在当前节点的视角，需要知道以下具体信息：
	 *
	 * 1、左右子树是否是 BST。
	 *
	 * 2、左子树的最大值和右子树的最小值。
	 *
	 * 3、左右子树的节点值之和。
	 *
	 * 只有知道了这几个值，我们才能满足题目的要求，后面我们会想方设法计算这些值。
	 *
	 * 现在可以尝试用伪码写出算法的大致逻辑：
	*/
	/*// 全局变量，记录最终结果
	int maxSum = 0;

	*//* 主函数 *//*
	public int maxSumBST(TreeNode root) {
		traverse(root);
		return maxSum;
	}

	*//* 遍历二叉树 *//*
	void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		//前序遍历位置
		// 判断左右子树是不是 BST
		if (!isBST(root.left) || !isBST(root.right)) {
        goto next;
		}
		// 计算左子树的最大值和右子树的最小值
		int leftMax = findMax(root.left);
		int rightMin = findMin(root.right);
		// 判断以 root 节点为根的树是不是 BST
		if (root.val <= leftMax || root.val >= rightMin) {
        goto next;
		}
		// 如果条件都符合，计算当前 BST 的节点之和
		int leftSum = findSum(root.left);
		int rightSum = findSum(root.right);
		int rootSum = leftSum + rightSum + root.val;
		// 计算 BST 节点的最大和
		this.maxSum = Math.max(maxSum, rootSum);
		*//*

		// 递归左右子树
		next:
		traverse(root.left);
		traverse(root.right);
	}

	*//* 计算以 root 为根的二叉树的最大值 *//*
	int findMax(TreeNode root) {}

	*//* 计算以 root 为根的二叉树的最小值 *//*
	int findMin(TreeNode root) {}

	*//* 计算以 root 为根的二叉树的节点和 *//*
	int findSum(TreeNode root) {}

	*//* 判断以 root 为根的二叉树是否是 BST *//*
	boolean isBST(TreeNode root) {}*/

	//稍作分析就会发现，这几个辅助函数都是递归函数，都要遍历输入的二叉树，外加traverse函数本身的递归，可以说是递归上加递归，所以这个解法的复杂度是非常高的。
	//只要把前序遍历变成后序遍历，让traverse函数把辅助函数做的事情顺便做掉。
	// 全局变量，记录 BST 最大节点之和
	int maxSum = 0;

	/* 主函数 */
	public int maxSumBST(TreeNode root) {
		traverse3(root);
		return maxSum;
	}

	// 函数返回 int[]{ isBST, min, max, sum}
	int[] traverse3(TreeNode root) {

		int[] left = traverse3(root.left);
		int[] right = traverse3(root.right);

		/******* 后序遍历位置 *******/
		// 通过 left 和 right 推导返回值
		// 并且正确更新 maxSum 变量
		/**************************/
		return new int[4];
	}
	/**
	 * traverse(root)返回一个大小为 4 的 int 数组，我们暂且称它为res，其中：
	 *
	 * res[0]记录以root为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
	 *
	 * res[1]记录以root为根的二叉树所有节点中的最小值；
	 *
	 * res[2]记录以root为根的二叉树所有节点中的最大值；
	 *
	 * res[3]记录以root为根的二叉树所有节点值之和。
	 *
	 * 其实这就是把之前分析中说到的几个值放到了res数组中，最重要的是，我们要试图通过left和right正确推导出res数组。
	*/
	int[] traverse4(TreeNode root) {
		// base case
		if (root == null) {
			return new int[] {
					1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
			};
		}

		// 递归计算左右子树
		int[] left = traverse4(root.left);
		int[] right = traverse4(root.right);

		/******* 后序遍历位置 *******/
		int[] res = new int[4];
		// 这个 if 在判断以 root 为根的二叉树是不是 BST
		if (left[0] == 1 && right[0] == 1 &&
				root.val > left[2] && root.val < right[1]) {
			// 以 root 为根的二叉树是 BST
			res[0] = 1;
			// 计算以 root 为根的这棵 BST 的最小值
			res[1] = Math.min(left[1], root.val);
			// 计算以 root 为根的这棵 BST 的最大值
			res[2] = Math.max(right[2], root.val);
			// 计算以 root 为根的这棵 BST 所有节点之和
			res[3] = left[3] + right[3] + root.val;
			// 更新全局变量
			maxSum = Math.max(maxSum, res[3]);
		} else {
			// 以 root 为根的二叉树不是 BST
			res[0] = 0;
			// 其他的值都没必要计算了，因为用不到
		}
		/**************************/

		return res;
	}

	/**
	 * 如果当前节点要做的事情需要通过左右子树的计算结果推导出来，就要用到后序遍历。
	 * 另外，我们要尽可能避免递归函数中调用其他递归函数，如果出现这种情况，大概率是代码实现有瑕疵
	*/

}

