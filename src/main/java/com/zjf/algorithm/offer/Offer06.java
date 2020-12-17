package com.zjf.algorithm.offer;

import java.util.Arrays;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-10-17 17:35  //时间
 */
public class Offer06 {

	/**
	 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
	 * 示例 1：
	 * 输入：head = [1,3,2]
	 * 输出：[2,3,1]
	 *
	 */
	public int[] reversePrint(ListNode head) {

		int lenght = 0;
		ListNode pre = null;
		ListNode curr = head;
		//反转链表
		while (curr !=null){
			lenght++;
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		int[] nums = new int[lenght];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = pre.val;
			pre = pre.next;

		}
		return nums;
	}

	public int[] reversePrint1(ListNode head) {
		if (head == null) {
			return new int[]{};
		}
		return getAns(head, 0);
	}
	public int[] getAns(ListNode head,int len){
		if (head == null){
			return new int[len];
		}
		int[] aa = getAns(head.next,len+1);
		aa[aa.length-len-1] = head.val;
		return aa;
	}

	public static void main(String[] args) {
		Offer06 test = new Offer06();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println(Arrays.toString(test.reversePrint(node1)));
	}

}
