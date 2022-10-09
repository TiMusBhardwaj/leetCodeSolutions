package com.sumit.array;

public class MinSizeSubArraySum {

	
	public static void main(String[] args) {
		
		int target = 1000;int[] nums = {2,3,1,2,4,3} ;
		System.out.println(new Solution().minSubArrayLen(target, nums));
	}
	static class Solution {
	    public int minSubArrayLen(int target, int[] nums) {
	        
	    	int sum =0;
	    	int start =0;
	    	int end =0;
	    	
	    	int res = Integer.MAX_VALUE;
	    	boolean flag = false;
	    	
	    	while (end < nums.length) {
	    		
	    		 sum +=nums[end];
	    		 while (sum-nums[start] >= target) {
	    			 
	    			 sum -= nums[start];
	    			 start++;
	    		 }
	    		 
	    		 if (sum>=target)
	    		 {
	    			 flag =true;
	    			 res = Math.min(end-start+1, res);
	    			 
	    		 }
	    			 
	    			 
	    		 end++;
	    		
	    	}
	    	
	    	return (flag ? res:0);
	    }
	}
}
