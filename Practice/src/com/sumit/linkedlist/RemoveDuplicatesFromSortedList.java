package com.sumit.linkedlist;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan&id=algorithm-ii
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {

		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(3);
		node.next.next.next.next.next = new ListNode(3);

		ListNode res = new Solution().deleteDuplicates2(node);
		System.out.println();
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	static class Solution {
		public ListNode deleteDuplicates(ListNode head) {

			ListNode dummyHead = new ListNode();
			dummyHead.next = head;
			ListNode prev = dummyHead;

			ListNode cur = head;
			while (cur != null) {
				boolean flag = false;

				while (cur.next != null && cur.next.val == cur.val) {
					flag = true;
					cur = cur.next;
				}
				if (flag) {
					prev.next = cur.next;
				} else {
					prev = prev.next;
				}
				cur = cur.next;

			}

			return dummyHead.next;

		}

		public ListNode deleteDuplicates2(ListNode head) {

			ListNode dummyHead = new ListNode();
			dummyHead.next = head;
			ListNode prev = dummyHead;
			
			ListNode cur = head;
			while (cur != null && cur.next != null) {

				if (cur.val == cur.next.val) {
					while(cur.next !=null && cur.val == cur.next.val) {
						cur.next = cur.next.next;
					}
					prev.next = cur.next;
					
				} else {
					prev = cur;
				}
				
				cur = cur.next;

			}

			return dummyHead.next;

		}

	}

}
