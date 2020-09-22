package com.zjf.algorithm.doublepointer;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-09-22 22:55  //时间
 */
public class Test234 {

	/**
	 * 请判断一个链表是否为回文链表。
	 * 示例 1:
	 * 输入: 1->2
	 * 输出: false
	 * 示例 2:
	 * 输入: 1->2->2->1
	 * 输出: true
	 * 进阶：
	 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
	 */
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null){
			return  false;
		}
		List<Integer> vals = new ArrayList<>();
		ListNode curr = head;
		while (curr !=null){
			vals.add(curr.val);
			curr = curr.next;
		}
		int size = vals.size();
		if (size%2>0){
			return  false;
		}
		int j = size-1;
		for (int i = 0; i < size/2; i++) {
			 if (!vals.get(i).equals(vals.get(j))){
			 	return false;
			 }
			 j--;

		}
		return true;
	}

	public boolean isPalindrome1(ListNode head) {

		if (head == null) {
			return true;
		}

		// Find the end of first half and reverse second half.
		ListNode firstHalfEnd = endOfFirstHalf(head);
		ListNode secondHalfStart = reverseList(firstHalfEnd.next);

		// Check whether or not there is a palindrome.
		ListNode p1 = head;
		ListNode p2 = secondHalfStart;
		boolean result = true;
		while (result && p2 != null) {
			if (p1.val != p2.val) {
				result = false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}

		// Restore the list and return the result.
		firstHalfEnd.next = reverseList(secondHalfStart);
		return result;
	}

	// Taken from https://leetcode.com/problems/reverse-linked-list/solution/
	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	private ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		Test234 practice = new Test234();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		System.out.println(practice.isPalindrome(head));
	}

}
