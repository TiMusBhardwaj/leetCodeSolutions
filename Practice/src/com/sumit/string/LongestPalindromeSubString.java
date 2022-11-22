package com.sumit.string;

public class LongestPalindromeSubString {
	
	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		
		System.out.println(new Solution().longestPalindrome(str));
	}

	
	static class Solution {
	    public String longestPalindrome(String s) {
	    	
	    	int start =0;
	    	int end =1;
	    	mem = new Boolean[s.length()][s.length()];
	    	for (int i=0;i<s.length();i++) {
	    		
	    		for (int j=i; j<s.length();j++) {
	    			boolean b = isPalendrom(i,j, s);
	    			if (b && end-start < j-i+1) {
	    				start =i;
	    				end=j+1;
	    			}
	    			
	    		}
	    		
	    		
	    		
	    	}
	    	
	         return s.substring(start,end);
	    }
	    
	    Boolean [][]mem;

		private boolean isPalendrom(int i, int j, String s) {
			
			if (mem[i][j] != null) {
				return mem[i][j];
			}
			
			System.out.println(i + " -- "+j);
			if (j-i==0)
				return true;
			if (j-i==1 && s.charAt(i)==s.charAt(j))
				return true;
			if (j-i >1 && s.charAt(i)==s.charAt(j) ) {
				
				boolean b = isPalendrom(i+1, j-1, s);
				mem[i][j] = b;
				i++;j--;
				return b;
			}
				
			return false;
		}
	    
	     
	}
}
