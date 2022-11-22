package com.sumit.linkedlist;


public class FindLoopNode {

	
	public static void main(String[] args) {
		ListNode node2 = new ListNode(0);
		node2.next =  new ListNode(1);
		node2.next.next =  new ListNode(2);
		node2.next.next.next =  new ListNode(3);
		node2.next.next.next.next =  new ListNode(4);
		node2.next.next.next.next.next =  new ListNode(5);
		node2.next.next.next.next.next.next =  node2.next.next;
		ListNode res = new Solution().detectCycle(node2);
		
		System.out.println(res);
	}
	
	static class Solution {
	    public ListNode detectCycle(ListNode head) {
	    	
	    	ListNode fast = new ListNode(-1);
	    	fast.next = head;
	    	ListNode slow = new ListNode(-2);
	    	slow.next = head;
	    	
	    	boolean loop = false;
	    	
	    	while (fast != null) {
	    		System.out.println(fast.val + " -- "+ slow.val);
	    		if (slow == fast) {
	    			loop = true;
	    			break;
	    		}
	    		
	    		if (fast.next == null || fast.next.next == null)
	    			break;
	    		
	    		fast = fast.next.next;
	    		slow = slow.next;
	    	}
	    	
	    	if(loop) {
	    		slow = new ListNode(-2);
	    		slow.next =head;
	    		while(slow != fast) {
	    			slow = slow.next;
	    			fast = fast.next;
	    		}
	    		
	    		return fast;
	    	}
	    	
	    	return null;
	        
	    }
	}
}
