package com.sumit.array;

public class AddStrings {
	
	public static void main(String[] args) {
		
		
		System.out.println(new Solution().addStrings("11", "123"));
	}
	
	static class Solution {
	    public String addStrings(String num1, String num2) {
	    	
	    	int len1 = num1.length()-1;
	    	int len2 = num2.length()-1;
	    	int carry =0;
	    	StringBuilder res = new StringBuilder();
	    	
	    	while (len1>=0 || len2>=0) {
	    		
	    		int a = len1>=0 ? num1.charAt(len1)-'0':0;
	    		int b = len2>=0 ? num2.charAt(len2)-'0':0;
	    		
	    		res = res.append((char) ('0' + (a+b+carry)%10));// (char) ('0' + (a+b+carry)%10);
	    		carry = (a+b+carry)/10;
	    		
	    				
	    		len1--;
	    		len2--;
	    	}
	    	if (carry >0)
	    		res.append( (char) ('0' + carry));
	        return res.reverse().toString();
	    }
	}

}
