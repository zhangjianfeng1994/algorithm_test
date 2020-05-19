package com.zjf.algorithm.tree;

import java.util.*;
/**
 * 树的后续遍历
 */
public class Test145 {

	/**
	 * 给定一个二叉树，返回它的 后序 遍历。
	 *
	 * 示例:
	 * 输入: [1,null,2,3]
	 *     1
	 *   /  \
	 *  4   2
	 *     /
	 *    3
	 * 输出: [3,2,1]
	 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
	 */
	/**
	 * 递归
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postTraversal(root,list);
		return list;
	}
	public void postTraversal(TreeNode root,List<Integer> list){
		if (root != null){
			postTraversal(root.left,list);
			postTraversal(root.right,list);
			list.add(root.val);
		}
	}

	/**
	 * 1.前序遍历的过程 是 中左右。
	 * 2.将其转化成 中右左。也就是压栈的过程中优先压入左子树，在压入右子树。
	 * 3.然后将这个结果返回来，这里是利用栈的先进后出倒序打印。
	 */
	public List<Integer> postorderTraversal1(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (root == null){
			return  list;
		}
		Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
		stack1.push(root);
		while (!stack1.isEmpty()){
			TreeNode node = stack1.pop();
			list.addFirst(node.val);
			if (node.left !=null){
				stack1.push(node.left);
			}
			if (node.right !=null){
				stack1.push(node.right);
			}
		}
		return list;
	}

	/**
	 * 基于栈的遍历
	 * 后序遍历的话，和中序遍历有些像。
	 *
	 * 开始的话，也是不停的往左子树走，然后直到为 null 。
	 * 不同之处是，之前直接把节点 pop 并且加入到 list 中，然后直接转到右子树。
	 *
	 * 这里的话，我们应该把节点 peek 出来，
	 *   然后判断一下当前根节点的右子树是否为空或者是否是从右子树回到的根节点。
	 *
	 * 判断是否是从右子树回到的根节点，这里我用了一个 set ，
	 * 当从左子树到根节点的时候，我把根节点加入到 set 中，之后我们就可以判断当前节点在不在 set
	 * 中，如果在的话就表明当前是第二次回来，也就意味着是从右子树到的根节点。
	 */
	public List<Integer> postorderTraversa2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Set<TreeNode> set = new HashSet<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null && !set.contains(cur)) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.peek();
			//右子树为空或者第二次来到这里
			if (cur.right == null || set.contains(cur)) {
				list.add(cur.val);
				set.add(cur);
				stack.pop();//将当前节点弹出
				if (stack.isEmpty()) {
					return list;
				}
				//转到右子树，这种情况对应于右子树为空的情况
				cur = stack.peek();
				cur = cur.right;
			} else {
				//从左子树过来，加到 set 中，转到右子树
				set.add(cur);
				cur = cur.right;
			}
		}
		return list;
	}

	public List<Integer> postorderTraversa3(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.peek();
			//右子树为空或者第二次来到这里
			if (cur.right == null) {
				list.add(cur.val);
				stack.pop();
				TreeNode tmp = stack.peek();
				if (tmp != null && tmp.right == cur) {
					tmp.right = null;
				}
				cur = null;
			} else {
				cur = cur.right;
			}
		}
		return list;
	}

	/**
	 * 后续遍历迭代通用写法
	 */
	public List <Integer> postorderTraversa4(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		if (root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack <TreeNode> ();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()){
			while (curr != null) {
				res.addFirst(curr.val);
				stack.push(curr);
				curr = curr.right;
			}
			curr = stack.pop();
			curr = curr.left;
		}
		return res;
	}
	/**
	 * 后序遍历-莫里斯遍历-通用写法
	 */
	public List <Integer> postOrderMoLiSi(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		if (root == null){
			return res;
		}
		TreeNode curr = root;
		while (curr != null ){
			if (curr.right == null) {
				res.addFirst(curr.val);
				curr = curr.left;
			}else {
				TreeNode pre = curr.right;
				while(pre.left != null && pre.left != curr){
					pre = pre.left;
				}
				if (pre.left == null){
					pre.left = curr;
					res.addFirst(curr.val);
					curr = curr.right;
				}else {
					pre.left = null;
					curr = curr.left;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		/**
		 *    1
		 * 	 /  \
		 * 	2   3
		 * /     \
		 * 4      5
		 */
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		Test145 test = new Test145();
		List<Integer> list = test.postorderTraversa2(node1);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
