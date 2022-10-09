package com.sumit.linkedlist;

public class Add2Numbers {
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(9);
		node1.next =  new ListNode(9);
		node1.next.next =  new ListNode(9);
		
		
		ListNode node2 = new ListNode(9);
		node2.next =  new ListNode(9);
		node2.next.next =  new ListNode(9);
		node2.next.next.next =  new ListNode(9);
		ListNode res = new Solution().addTwoNumbers(node1, node2);
		
		while (res !=null) {
			System.out.print(res.val);
			res = res.next;
		}
	}
	
	static class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	
	    	ListNode head = null;
	    	ListNode curNode = null;
	    	boolean carry = false;
	    	while(l1 !=null && l2 !=null) {
	    		if (head == null) {
	    			curNode = new ListNode(l1.val+l2.val + (carry ? 1:0));
		    		head = curNode;
	    		}else {
		    		curNode.next = new ListNode(l1.val+l2.val+(carry ? 1:0));
		    		curNode = curNode.next;
		    	}
		    	l1 = l1.next;
		    	l2 = l2.next;
		    	carry = curNode.val >9;
		    	if (carry)
		    		curNode.val = curNode.val%10;
	    		
	    	}
	    	while (l1 != null) {
	    		curNode.next = new ListNode(l1.val + (carry ? 1:0));
	    		curNode = curNode.next;
	    		carry = curNode.val >9;
		    	if (carry)
		    		curNode.val = curNode.val%10;
	    		l1 = l1.next;
	    	}
	    	while (l2 != null) {
	    		curNode.next = new ListNode(l2.val + (carry ? 1:0));
	    		curNode = curNode.next;
	    		carry = curNode.val >9;
		    	if (carry)
		    		curNode.val = curNode.val%10;
	    		l2 = l2.next;
	    	}
	    	if (carry) {
	    		curNode.next = new ListNode(1);
	    		
	    	}
	    	
	    	
	    	return head;
	    }
	}
	
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
}
