package com.sumit.array;

public class SingleNumber {
	
	public static void main(String[] args) {
		
		int []nums = {4,1,2,1,2};
		System.out.println(new Solution().singleNumber(nums));
	}
	
	static class Solution {
		
		
		
	    public int singleNumber(int[] nums) {
	    	
	    	int num = 0;
	    	for (int n : nums)		
	    		num^=n;
			return num;
	        
	    }
	}

}
