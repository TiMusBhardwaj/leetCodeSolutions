package com.sumit.array;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().generateParenthesis(3));
	}
	
	static class Solution {
		
		private List<String> res = new ArrayList<>();
	    public List<String> generateParenthesis(int n) {
	        dfs(n, new String(), 0);
	        
	        return res;
	    }
	    
	    private void dfs(int n, String s, int counter ) {
	    	
	    	if (2*n == s.length()) {
	    		res.add(s);
	    		return;
	    	}
	    	if (counter < n) {
	    		dfs(n, s.concat("("), counter+1);
	    	}
	    	if (counter> s.length()-counter) {
	    		dfs(n, s.concat(")"), counter);
	    	}
	    	
	    }
	}

}
