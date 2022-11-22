package com.sumit.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().findRepeatedDnaSequences("AAAAAAAAAAAAA"));
	}
	
	static class Solution {
	    public List<String> findRepeatedDnaSequences(String s) {
	    	
	    	Set<String> set = new HashSet<>();
	    	Set<String> list = new HashSet<>();
	    	int start =0;
	    	int end =10;
	    	while (end <= s.length()) {
	    		String str = s.substring(start++, end++);
	    		if (!set.add(str)) {
	    			list.add(str);
	    		}
	    	}
	    	
	        return new ArrayList<>(list);
	    }
	}

}
