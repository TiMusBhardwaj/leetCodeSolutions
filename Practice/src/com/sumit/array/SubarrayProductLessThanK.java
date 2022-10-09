package com.sumit.array;

public class SubarrayProductLessThanK {
	
	public static void main(String[] args) {
		
	}
	
	static class Solution {
	    public int numSubarrayProductLessThanK(int[] nums, int k) {
	    	if(k <=1 )
	            return 0;
	    	
	    	int result =0;
	    	int prod = 1;
	    	int end =0;
	    	int start = 0;
	    	
	    	while (end < nums.length) {
	    		
	    		prod = prod*nums[end];
	    		while (prod >= k) {
	    			prod = prod/nums[start];
	    			start++;
	    		}
	    		
	    		
	    		result = result + end - start +1;
	    		end++;
	    		
	    	}
	    	return result;
	    	
	    }
	}

}
