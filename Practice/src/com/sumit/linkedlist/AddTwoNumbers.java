package com.sumit.linkedlist;

public class AddTwoNumbers {
	
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
	    	
	    	int carry = 0;
	    	ListNode head = new ListNode(0);
	    	ListNode curr = head;
	    	
	    	while (carry ==1 || l1 !=null || l2 !=null) {
				
	    		
	    		int first =0;
	    		int second = 0;
	    		if (l1 != null) {
	    			first = l1.val;
	    			l1 = l1.next;
	    		}
	    		
	    		if (l2 != null) {
	    			second = l2.val;
	    			l2 = l2.next;
	    		}
	    		
	    		int sum = first+second+carry;
	    		curr.next = new ListNode(sum%10);
	    		curr = curr.next;
	    		carry = sum/10;
	    		
	    		
			}
	    	
	    	return head.next;
	    	
	    	
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
