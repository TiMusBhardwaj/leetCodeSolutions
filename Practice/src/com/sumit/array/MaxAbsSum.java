package com.sumit.array;

public class MaxAbsSum {
	
	public static void main(String[] args) {
		int [] nums = {1,-3,2,3,-4};
		
		System.out.println(new Solution().maxAbsoluteSum(nums));
	}
	
	
	static class Solution {
	    public int maxAbsoluteSum(int[] nums) {
	    	
	    	int max_so_far = Math.abs(nums[0]);
			int curr_max_pos = nums[0] > 0 ? nums[0] : 0;
			int curr_max_neg = nums[0] < 0 ? nums[0] : 0;

			for (int i = 1; i < nums.length; i++) {
				curr_max_pos = Math.max(nums[i], curr_max_pos + nums[i]);
				curr_max_neg = Math.min(nums[i], curr_max_neg + nums[i]);
				
				max_so_far = Math.max(max_so_far, curr_max_pos);
				max_so_far = Math.max(max_so_far, Math.abs(curr_max_neg));
			}
			return max_so_far;
	    	
	        
	    }
	}

}
