package com.sumit.linkedlist;

import java.util.Stack;

public class ReOrderList {
	
	public static void main(String[] args) {
		
		ListNode node2 = new ListNode(0);
		node2.next =  new ListNode(1);
		node2.next.next =  new ListNode(2);
		node2.next.next.next =  new ListNode(3);
		node2.next.next.next.next =  new ListNode(4);
		node2.next.next.next.next.next =  new ListNode(5);
		
		new Solution().reorderList(node2);
		print(node2);
		
	}
	
	static class Solution {
	    public void reorderList(ListNode head) {
	    	
	    	
	    	Stack<ListNode> st = new Stack<>();
	    	ListNode curr = head;
	    	int len =0;
	    	while (curr !=null) {
	    		st.push(curr);
	    		curr = curr.next;
	    		len++;
	    	}
	    	
	    	ListNode cur = new ListNode();
	    	ListNode next = head;
	    	while (len >0) {
	    		
	    		cur.next = next;
	    		next = cur.next.next;
	    		cur = cur.next;
	    		len--;
	    		if (len == 0) {
	    			break;
	    		}
	    		
	    		cur.next = st.pop();
	    		cur = cur.next;
	    		len--;
	    	}
	    	cur.next =null;
	        
	    }
	    
	    
	}
	private static void print(ListNode head) {
		
		while(head !=null) {
			System.out.print(head.val + " - ");
			head = head.next;
		}
		System.out.println();
	}

}
