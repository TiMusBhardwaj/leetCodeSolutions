package com.sumit.linkedlist;

import java.util.Stack;

public class ReverseKGroup {
	
	public static void main(String[] args) {
		ListNode node2 = new ListNode(0);
		node2.next =  new ListNode(1);
		node2.next.next =  new ListNode(2);
		node2.next.next.next =  new ListNode(3);
		node2.next.next.next.next =  new ListNode(4);
		node2.next.next.next.next.next =  new ListNode(5);
		
		new Solution().reverseKGroup(node2, 6);
	}
	
	static class Solution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	    	
	    	ListNode dummy = new ListNode(-1);
	    	dummy.next = head;
	    	
	    	ListNode cuNode = dummy;
	    	ListNode prev = dummy;
	    	
	    	while (cuNode.next != null) {
				int temp =k;
				Stack<ListNode> st = new Stack<>();
				while(temp-- >0 && cuNode.next !=null) {
					
					st.add(cuNode.next);
					cuNode = cuNode.next;
				}
				if (st.size() < k) {
					break;
				}
				System.out.println(prev);
				System.out.println(st);
				
				ListNode start = cuNode.next;
				
				while (!st.isEmpty()) {
					
					prev.next = st.pop();
					prev = prev.next;
				}
				prev.next = start;
				cuNode = prev;
				
				print(dummy);
	    		
			}
	    	
	        
	    	print(dummy);
	    	return dummy.next;
	    }

		private void print(ListNode head) {
			
			while(head !=null) {
				System.out.print(head.val + " - ");
				head = head.next;
			}
			System.out.println();
		}
	}

}
