package com.sumit.array;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestPalindromeSize {
	
	public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome(""));
	}
	
	static class Solution {
	    public int longestPalindrome(String s) {
	    	
	    	Map<Integer, Long > map = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    	int res =0;
	        
	    	for (Map.Entry<Integer, Long > e: map.entrySet()) {
	    		
	    		res+=(e.getValue()/2)*2;
	    		if (res%2 == 0 && e.getValue()%2==1)
	    			res++;
	    	}
	    	
	    	
	    return res;	
	    	
	    }
	}

}
