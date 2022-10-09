package com.sumit.array;

import java.util.Arrays;

public class PlusOne {
	
	public static void main(String[] args) {
		int [] arr = {9,9,9,9,9};
		System.out.println(Arrays.toString( new Solution().plusOne(arr)));
	}
	
	static class Solution {
	    public int[] plusOne(int[] digits) {
	    	int index = digits.length-1;
	    	boolean carry = true;
	    	while (index >=0 && carry) {
	    		digits[index] +=1;
	    		if (digits[index] >9) {
	    			digits[index] = digits[index]%10;
	    			carry=true;
	    		}else {
	    			carry = false;
	    		}
	    		index--;
	    	}
	    	if (carry) {
	    		int [] res = new int[digits.length+1];
	    		System.arraycopy(digits,0,res,1,digits.length);
	    		res[0]=1;
	    		return res;
	    	}
	    	
			return digits;
	        
	    }
	}

}
