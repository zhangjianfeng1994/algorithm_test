package com.zjf.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-28 19:55  //时间
 */
public class Offer35 {



	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
	/**
	 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
	 * 每个节点除了有一个 next 指针指向下一个节点，
	 * 还有一个 random 指针指向链表中的任意节点或者 null。
	 *
	 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
	 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
	 *
	 * 输入：head = [[1,1],[2,1]]
	 * 输出：[[1,1],[2,1]]
	 *
	 * 输入：head = [[3,null],[3,0],[3,null]]
	 * 输出：[[3,null],[3,0],[3,null]]
	 *
	 * 输入：head = []
	 * 输出：[]
	 * 解释：给定的链表为空（空指针），因此返回 null。
	 */
	public Node copyRandomList(Node head) {
		if(head == null) {
			return null;
		}
		Node cur = head;
		Map<Node, Node> map = new HashMap<>();
		// 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
		while(cur != null) {
			map.put(cur, new Node(cur.val));
			cur = cur.next;
		}
		cur = head;
		// 4. 构建新链表的 next 和 random 指向
		while(cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		// 5. 返回新链表的头节点
		return map.get(head);

	}
}
