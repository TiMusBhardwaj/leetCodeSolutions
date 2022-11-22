package com.sumit.stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().minRemoveToMakeValid("a)b(c)d"));
	}
	
	static class Solution {
	    public String minRemoveToMakeValid(String s) {
	    	
	    	Stack<Integer> st = new Stack<>();
	    	Stack<Integer> st2 = new Stack<>();
	    	for (int i=0; i < s.length(); i++) {
	    		
	    		if ('(' == s.charAt(i)) {
	    			st.push(i);
	    		}
	    		if (')' == s.charAt(i)) {
	    			if (!st.isEmpty())
	    				st.pop();
	    			else 
	    				st2.push(i);
	    				
	    		}
	    		
	    	}
	    	StringBuilder str = new StringBuilder();
	    	for (int i=0; i < s.length(); i++) {
	    		if (st.contains(i) || st2.contains(i))
	    			continue;
	    		str.append(s.charAt(i));
	    		
	    	}
	    	
	    	return str.toString();
	        
	    }
	}

}
