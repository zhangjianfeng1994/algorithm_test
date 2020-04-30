package com.zjf.algorithm.linkedlist;

/**
 * description: Test86 <br>
 * date: 2020/4/27 14:58 <br>
 * author: 张建峰 <br>
 */
public class Test86 {


	/**
	 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
	 * 你应当保留两个分区中每个节点的初始相对位置。
	 * 示例:
	 * 输入: head = 1-2->4->3->2->2, x = 3
	 * 输出: 1->2->2->4->3->5
	 */
	public ListNode partition(ListNode head, int x) {
		if (head == null){
			return head;
		}
		//记录最后一个小于x的ListNode
		ListNode lastSmall = null;
		ListNode curr = head;
		while (curr.next != null){
			ListNode next = curr.next;
			int val = curr.val;
			int nextVal = next.val;
			if (val < x ){
				lastSmall = curr;
			}
			if (val >= x && nextVal < x){
				curr.next = next.next;
				if (lastSmall == null){
					next.next = head;
					head = next;
				}else {
					ListNode next1 = lastSmall.next;
					lastSmall.next = next;
					next.next = next1;
				}
				lastSmall = next;
				curr = curr;
			}else{
				curr = curr.next;
			}
		}
		return head;
	}

	/**
	 * description: 官方解答
	 * 创建两个哑ListNode
	*/
	public ListNode partition1(ListNode head, int x) {

		// before and after are the two pointers used to create the two list
		// before_head and after_head are used to save the heads of the two lists.
		// All of these are initialized with the dummy nodes created.
		ListNode before_head = new ListNode(0);
		ListNode before = before_head;
		ListNode after_head = new ListNode(0);
		ListNode after = after_head;

		while (head != null) {

			// If the original list node is lesser than the given x,
			// assign it to the before list.
			if (head.val < x) {
				before.next = head;
				before = before.next;
			} else {
				// If the original list node is greater or equal to the given x,
				// assign it to the after list.
				after.next = head;
				after = after.next;
			}

			// move ahead in the original list
			head = head.next;
		}

		// Last node of "after" list would also be ending node of the reformed list
		after.next = null;

		// Once all the nodes are correctly assigned to the two lists,
		// combine them to form a single list which would be returned.
		before.next = after_head.next;

		return before_head.next;
	}

	public static void main(String[] args) {
		ListNode ListNode1 = new ListNode(1);
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

		Test86 test = new Test86();
		ListNode head = ListNode4;
		while (head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("");
		ListNode4 = test.partition(ListNode4,3);
		head = ListNode4;
		while (head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
	}
}
