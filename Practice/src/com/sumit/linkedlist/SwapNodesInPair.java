package com.sumit.linkedlist;

import com.sumit.linkedlist.RemoveDuplicatesFromSortedList.ListNode;

public class SwapNodesInPair {
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(6);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(9);
		//node.next.next.next.next.next = new ListNode(3);

		ListNode res = new Solution().swapPairs(node);
		System.out.println(res);
	}
	
	
	static class Solution {
	    public ListNode swapPairs(ListNode head) {
	       
	    	ListNode dummy = new ListNode();
	    	dummy.next = head;
	    	ListNode cur = dummy;
	    	
	    	while(cur.next !=null && cur.next.next !=null) {
	    		
	    		ListNode temp = cur.next;
	    		cur.next = cur.next.next;
	    		temp.next= temp.next.next;
	    		cur.next.next = temp;
	    		
	    		cur = cur.next.next;
	    	}
	    	
	    	return dummy.next;
	    }
	}

}
