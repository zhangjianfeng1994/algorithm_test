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
}
