package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-10 00:03  //时间
 */
public class Offer24 {

	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		while (curr != null){
			ListNode node = curr.next;
			curr.next = pre;
			pre = curr;
			curr = node;
		}
		return pre;
	}
	/**
	 *不是反转列表
	 * 1->2->3->4->5
	 * 结果 2->1->4->3->5
	*/
	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		//5 = 4.next
		ListNode newHead = head.next;
		head.next = reverseList1(newHead.next);
		newHead.next = head;
		return newHead;
	}
	/**
	 * 递归反转链表
	*/
	ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode ret = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return ret;
	}

	public static void main(String[] args) {
		ListNode node1= new ListNode(1);
		ListNode node2= new ListNode(2);
		ListNode node3= new ListNode(3);
		ListNode node4= new ListNode(4);
		ListNode node5= new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		Offer24 test = new Offer24();
		ListNode newhead = test.reverseList1(node1);
	}
}
