package com.zjf.algorithm.linkedlist;

import java.util.Stack;

/**
 * description: Test445 <br>
 * date: 2020/5/6 9:58 <br>
 * author: 张建峰 <br>
 */
public class Test445 {

	/**
	 * description:
	 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
	 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
	 * 进阶：
	 *  如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
	 * 示例：
	 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * 输出：7 -> 8 -> 0 -> 7
	 *
	*/
	/**
	 *
	 */

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode node1 = reverse(l1);
		ListNode node2 = reverse(l2);
		int carry = 0;
		ListNode newHead = null;
		while (node1 != null || node2 != null){
			int x = node1 != null ? node1.val : 0;
			int y = node2 != null ? node2.val : 0;
			int num = (x + y + carry) % 10;
			ListNode node = new ListNode(num);
			node.next = newHead;
			newHead = node;
			carry = (x + y + carry) / 10;
			if (node1 != null) {
				node1 = node1.next;
			}
			if (node2 != null) {
				node2 = node2.next;
			}
		}
		// 最后加上 carry
		if (carry > 0) {
			ListNode node = new ListNode(carry);
			node.next = newHead;
			newHead = node;
		}
		return newHead;
	}

	// 链表反转
	public ListNode reverse(ListNode head){
		if (head == null) {
			return null;
		}
		ListNode pre = null;
		while (head != null){
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
