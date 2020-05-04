package com.zjf.algorithm.linkedlist;

public class Test148 {


	/**
	 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
	 *
	 * 示例 1:
	 * 输入: 4->2->1->3
	 * 输出: 1->2->3->4
	 *
	 * 示例 2:
	 * 输入: -1->5->3->4->0
	 * 输出: -1->0->3->4->5
	 *
	 */

	/**
	 * 归并排序（快慢双指针）
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode tag = slow.next;
		slow.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(tag);
		return mergeTwoLists(left, right);
	}

	/**
	 * 归并排序（迭代）
	 * @param head
	 * @return
	 */
	public ListNode sortList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		int len = 1;
		while (cur.next != null) {
			len++;
			cur = cur.next;
		}
		ListNode sentry = new ListNode(-1);
		sentry.next = head;
		for (int i = 1; i < len; i *= 2) {
			ListNode tag = sentry;
			cur = sentry.next;
			while (cur != null) {
				ListNode left = cur;
				ListNode right = split(left, i);
				cur = split(right, i);
				tag.next = mergeTwoLists(left, right);
				while (tag.next != null) {
					tag = tag.next;
				}
			}
		}
		return sentry.next;
	}

	/**
	 * 合并2个有序链表
	 * @param l1
	 * @param l2
	 * @return
	 */
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == l2) {
			return l1;
		}
		ListNode prehead = new ListNode(-1);
		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		prev.next = l1 == null ? l2 : l1;
		return prehead.next;
	}


	/**
	 * 切割链表为2个链表，返回后一个链表的头节点
	 * @param head
	 * @param step
	 * @return
	 */
	private ListNode split(ListNode head, int step) {
		if (head == null) {
			return head;
		}
		for (int i = 1; head.next != null && i < step; i++) {
			head = head.next;
		}
		ListNode next = head.next;
		head.next = null;
		return next;
	}


	/**
	 * 快速排序（指针交换）
	 * @param head
	 * @return
	 */
	public ListNode sortList2(ListNode head) {
		return quickSort1(head);
	}

	public ListNode quickSort1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode before = new ListNode(0);
		ListNode beforeHead = before;
		ListNode after = new ListNode(0);
		ListNode afterHead = after;
		ListNode cur = head;
		int pivot = head.val;
		while (cur != null) {
			if (cur.val < pivot) {
				before.next = cur;
				before = before.next;
			} else {
				after.next = cur;
				after = after.next;
			}
			cur = cur.next;
		}
		before.next = afterHead.next;
		after.next = null;
		ListNode right = quickSort1(head.next);
		head.next = null;
		ListNode left = quickSort1(beforeHead.next);
		cur = left;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = right;
		return left;
	}


	/**
	 * 解决方案: 二分法
	 * 快速排序 值交换
	 */
	public static void quickSort(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		quickSort(head, null);
	}

	private static void quickSort(ListNode begin, ListNode end) {
		if (begin != end && begin.next != end) {
			ListNode p = partition(begin, end);
			quickSort(begin, p);
			quickSort(p.next, end);
		}
	}

	private static ListNode partition(ListNode begin, ListNode end) {
		int baseVal = begin.val;
		ListNode base = begin;
		ListNode cur = begin.next;
		// 快速排序之单向划分方式
		while (cur != end) {
			if (cur.val < baseVal) {
				base = base.next;
				int temp = base.val;
				base.val = cur.val;
				cur.val = temp;
			}
			cur = cur.next;
		}
		int temp = base.val;
		base.val = begin.val;
		begin.val = temp;
		return base;
	}


	public static void main(String[] args) {
		ListNode ListNode1 = new ListNode(3);
		ListNode ListNode4 = new ListNode(4);
		ListNode ListNode3 = new ListNode(3);
		ListNode ListNode2 = new ListNode(2);
		ListNode ListNode5 = new ListNode(5);
		ListNode ListNode2_1 = new ListNode(2);
		ListNode1.next = ListNode4;
		ListNode4.next = ListNode3;
		ListNode3.next = ListNode2;
		ListNode2.next = ListNode5;
		ListNode5.next = ListNode2_1;

		Test148 test = new Test148();
		ListNode head = ListNode1;
		while (head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("");
		ListNode listNodeTest = test.sortList(ListNode1);
		head = listNodeTest;
		while (head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
	}
}
