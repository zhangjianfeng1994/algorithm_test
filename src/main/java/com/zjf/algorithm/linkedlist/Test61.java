package com.zjf.algorithm.linkedlist;

import javax.swing.tree.TreeNode;

/**
 * description: Test61 <br>
 * date: 2020/4/30 15:22 <br>
 * author: 张建峰 <br>
 */
public class Test61 {

	/**
	 * description:
	 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
	 * 示例 1:
	 * 输入: 1->2->3->4->5->NULL, k = 2
	 * 输出: 4->5->1->2->3->NULL
	 * 解释:
	 * 向右旋转 1 步: 5->1->2->3->4->NULL
	 * 向右旋转 2 步: 4->5->1->2->3->NULL
	 *
	 * 示例 2:
	 * 输入: 0->1->2->NULL, k = 4
	 * 输出: 2->0->1->NULL
	 * 解释:
	 * 向右旋转 1 步: 2->0->1->NULL
	 * 向右旋转 2 步: 1->2->0->NULL
	 * 向右旋转 3 步: 0->1->2->NULL
	 * 向右旋转 4 步: 2->0->1->NULL
	*/
	public ListNode rotateRight(ListNode head, int k) {
		if (k <= 0 || head == null || head.next == null){
			return head;
		}
		/*
		 * description: 两种方案:
		 * 第一种: 先遍历一遍head,记录总的head个数 total,以及最底层的lastHead;
		 *         cut = total-(total%k取余数)  第二次遍历到cut取分割点的cutHead;
		 *         startHead = head ;head =  cutHead.next ;lastHead.next = startHead;
		 * 第二种: 两层while,第一层 条件为(k>0) k--;
		 *        第二层每次向右移动一个位置; 记录要分割的点为倒数第二个cutHead
		 * 		  startHead = head ;head = cutHead.next ;lastHead.next = startHead;
		 *
		*/
		int total = 1;
		ListNode lastHead = head;
		while (lastHead.next != null){
			total ++;
			lastHead = lastHead.next;
		}
		int cut = total-(k%total);
		if (cut == total){
			return head;
		}
		ListNode cutHead = head;
		while (cutHead != null){
			if (cut == 1){
				break;
			}
			cut --;
			cutHead = cutHead.next;
		}
		ListNode startHead = head;
		head = cutHead.next ;
		cutHead.next = null;
		lastHead.next = startHead;

		return head;
	}
	/**
	 * description: 官方解答
	 * 主要区别是 官方先将链表闭合成环,不需要判断 k是否是总数的整数倍
	*/
	public ListNode rotateRight1(ListNode head, int k) {
		// base cases
		if (head == null) return null;
		if (head.next == null) return head;

		// close the linked list into the ring
		ListNode old_tail = head;
		int n;
		for(n = 1; old_tail.next != null; n++)
			old_tail = old_tail.next;
		old_tail.next = head;

		// find new tail : (n - k % n - 1)th node
		// and new head : (n - k % n)th node
		ListNode new_tail = head;
		for (int i = 0; i < n - k % n - 1; i++)
			new_tail = new_tail.next;
		ListNode new_head = new_tail.next;

		// break the ring
		new_tail.next = null;

		return new_head;
	}

	public static void main(String[] args) {
		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode ListNode3 = new ListNode(3);
		ListNode ListNode4 = new ListNode(4);
		ListNode ListNode5 = new ListNode(5);
		ListNode1.next = ListNode2;
		ListNode2.next = ListNode3;
		ListNode3.next = ListNode4;
		ListNode4.next = ListNode5;

		Test61 test = new Test61();
		ListNode head = ListNode1;
		while (head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("");
		ListNode1 = test.rotateRight(ListNode1,6);
		head = ListNode1;
		while (head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
	}

	public boolean isSymmetric1(TreeNode root) {
		if (root == null) {
			return true;
		}
		return same(root.left,root.right);
	}

	public boolean same(TreeNode left,TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val ) {
			return false;
		}
		return same(left.left,right.right)&&same(left.right,right.left);
	}
}
