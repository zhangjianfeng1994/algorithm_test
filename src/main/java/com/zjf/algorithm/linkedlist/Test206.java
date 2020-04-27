package com.zjf.algorithm.linkedlist;

/**
 * @author ZJF
 */
public class Test206 {




	/**
	 * 反转一个单链表。
	 * 示例:
	 * 输入: 1->2->3->4->5->NULL
	 * 输出: 5->4->3->2->1->NULL
	 * 进阶:
	 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
	 */
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		//前一个节点
		ListNode prev  = null;
		//当前节点
		ListNode curr  = head;
		while(curr != null){
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return head;
	}


	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}


	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		head1.next = head2;
		Test206 test206 = new Test206();
		ListNode head = head1;
		while (head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("");
		head = test206.reverseList(head1);
		while (head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
	}
}
