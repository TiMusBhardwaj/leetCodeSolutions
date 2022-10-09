package com.sumit.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
	
	
	public static void main(String[] args) {
		System.out.println(new Solution().findAnagrams("abab", "ab"));
	}
	
	static class Solution {
	    public List<Integer> findAnagrams(String s, String p) {
	    	List<Integer> res = new ArrayList<>();
	    	int sL= s.length();
	    	int pL = p.length();
	    	
	    	if (sL < pL) return res;
	    	int [] sArray = freq(s.substring(0, pL));
	    	int [] pArray = freq(p);
	    	int index = pL; 
	    	if (areSame(sArray, pArray) )
	    		res.add(0);
	    	
	    	while (index < sL) {
	    		sArray[s.charAt(index-pL)-'a']--;
	    		sArray[s.charAt(index)-'a']++;
	    		if (areSame(sArray, pArray))
	    			res.add(index-pL+1);
	    		index++;
	    		
	    		
	    	}
	    	
	    	 
	    	return res;
	    	
	    }
	    private boolean areSame(int[] x, int[] y){
	        for(int i = 0; i < 26; i++){
	            if(x[i] != y[i]) 
	                return false;
	        }
	        
	        return true;
	    }
	  private int[] freq(String s){
	        int[] count = new int[26]; 
	        for(int i = 0; i < s.length(); i++){
	            count[s.charAt(i) - 'a']++; 
	        }
	        
	        return count; // and return count 
	    }
	}

}
