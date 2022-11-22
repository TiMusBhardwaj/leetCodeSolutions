package com.sumit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabel {
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
	}
	
	static class Solution {
	    public List<Integer> partitionLabels(String s) {
	    	
	    	int[] last = new int[26];
	        for (int i = 0; i < s.length(); ++i)
	            last[s.charAt(i) - 'a'] = i;
	        
	        int start =0;
	        int end = 0 ;
	        List<Integer> ans = new ArrayList<>();
	        for (int i=0; i< s.length();i++) {
	        	end = Math.max(last[s.charAt(i) - 'a'], end);
	        	if( end== i) {
	        		 ans.add(i - start + 1);
	                 start = i + 1;
	        	}
	        	
	        }
	        return ans;
	    }
	}

}
