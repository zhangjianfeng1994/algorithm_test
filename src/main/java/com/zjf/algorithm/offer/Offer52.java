package com.zjf.algorithm.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2021-01-14 23:29  //时间
 */
public class Offer52 {

	/**
	 *输入两个链表，找出它们的第一个公共节点。
	 *
	 * 如下面的两个链表：
	 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
	 * 输出：Reference of the node with value = 8
	 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B
	 * 中，相交节点前有 3 个节点。
	 *注意：
	 *
	 * 如果两个链表没有交点，返回 null.
	 * 在返回结果后，两个链表仍须保持原有的结构。
	 * 可假定整个链表结构中没有循环。
	 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> nodeSet = new HashSet<>();
		ListNode node1 = headA;
		while (node1 !=null){
			nodeSet.add(node1);
			node1 = node1.next;
		}
		ListNode node2 = headB;
		while (node2 !=null){
			if (nodeSet.contains(node2)){
				return node1;
			}
			node2 = node2.next;
		}
		return null;
	}

	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		int lenA = nodeLen(headA);
		int lenB = nodeLen(headB);
		ListNode head1 = headA;
		ListNode head2 = headB;
		if (lenA>lenB){
			for (int i = 0; i < lenA-lenB; i++) {
				head1 = head1.next;
			}
		}else {
			for (int i = 0; i < lenB-lenA; i++) {
				head2 = head2.next;
			}
		}
		while (head1!=null){
			if (head1 == head2){
				return head1;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return null;
	}

	private int nodeLen(ListNode head) {
		int len = 0;
		while (head!=null){
			len++;
			head = head.next;
		}
		return len;
	}


}
