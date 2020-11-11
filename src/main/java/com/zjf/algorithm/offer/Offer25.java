package com.zjf.algorithm.offer;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-10 00:03  //时间
 */
public class Offer25 {

	/**
	 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
	 * 示例1：
	 * 输入：1->2->4, 1->3->4
	 * 输出：1->1->2->3->4->4
	 * 限制：
	 * 0 <= 链表长度 <= 1000
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == l2){
			return l1;
		}
		ListNode head = new ListNode(-1);
		ListNode pre = head;
		while (l1 != null && l2 != null){
			if (l1.val <= l2.val){
				pre.next = l1;
				l1 = l1.next;
			}else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		pre.next = l1==null?l2:null;
		return head.next;
	}
}
