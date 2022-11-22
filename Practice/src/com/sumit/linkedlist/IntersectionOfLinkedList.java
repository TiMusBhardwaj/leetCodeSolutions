package com.sumit.linkedlist;

import java.util.Stack;

public class IntersectionOfLinkedList {
	
	public static void main(String[] args) {
		
		ListNode node2 = new ListNode(10);
		node2.next =  new ListNode(11);
		node2.next.next =  new ListNode(12);
		node2.next.next.next =  new ListNode(13);
		node2.next.next.next.next =  new ListNode(3);
		node2.next.next.next.next.next =  new ListNode(4);
		node2.next.next.next.next.next.next =  new ListNode(5);
		node2.next.next.next.next.next.next.next =  new ListNode(6);
		
		
		ListNode node1 = new ListNode(0);
		node1.next =  new ListNode(1);
		node1.next.next =  new ListNode(2);
		node1.next.next.next = node2.next.next.next.next;
		
		System.out.println(new Solution().getIntersectionNode2(node2, node1));
		
	}

	static class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

			Stack<ListNode> l1 = new Stack<>();
			while (headA != null) {
				l1.add(headA);
				headA = headA.next;
			}
			Stack<ListNode> l2 = new Stack<>();
			while (headB != null) {
				l2.add(headB);
				headB = headB.next;
			}

			ListNode node = null;

			while (!l1.isEmpty() && !l2.isEmpty()) {

				ListNode node1 = l1.pop();
				ListNode node2 = l2.pop();
				if (node1 == node2) {
					node = node1;
				} else {
					break;
				}

			}

			return node;

		}
		
		public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		    ListNode ptrA = headA, ptrB = headB;
		    while (ptrA != ptrB) { // loop until we found the first common node
		        ptrA = ptrA == null ? headB : ptrA.next; // once we're done with A, move to B
		        ptrB = ptrB == null ? headA : ptrB.next; // once we're done with B, move to A
			}
			return ptrA;
		}

	}

}
