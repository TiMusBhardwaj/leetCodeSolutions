package com.sumit.array;

public class HouseRobber {
	
	public static void main(String[] args) {
		
		int []nums = {1,2,3,1};
		
		
		
		System.out.println(new Solution().rob(nums));
	}

	static class Solution{
		public int rob(int[] nums) {
			
			if (nums.length==1) {
				return nums[0];
			}
	    	
			return Math.max(solve(nums, 0, nums.length-2), solve(nums, 1, nums.length-1));
	        
	    }
		
		int solve(int [] nums, int start, int end) {
			
			
			
			int prev1 = 0;
	        int prev2 = 0;
			
	        for (int i=start; i<=end;i++) {
	        	
	        	int curr = nums[i];
	        	
	        	curr = Math.max(prev2+curr, prev1);
	        	
	        	prev2=prev1;
	        	prev1=curr;
	        	
	        }
			return prev1;
		}
	}
}
