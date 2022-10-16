package com.sumit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_2 {
	
	public static void main(String[] args) {
		
		int [] nums = {-1,0,1,2,-1,-4};
		System.out.println(new Solution().threeSum(nums));
	}
	
	
	static class Solution {
		
		List<List<Integer>> res = new ArrayList<>();
		
		public List<List<Integer>> threeSum(int[] nums) {
	    	Arrays.sort(nums);
	    	
	    	for (int i=0; i<nums.length-2; i++) {
	    		if (i !=0 && nums[i] == nums[i-1])
	    			continue;
	    		if (nums[i]>0) {
	    			break;
	    		}
	    		twoSum(nums, i);
	    	}
	    	return res;
	    }
		
		private void twoSum(int[] nums, int pos){
			int start =pos+1;
	    	int end = nums.length-1;
	    	
	    	while (start< end) {
	    		int sum = nums[start]+nums[end]+nums[pos];
	    		if(sum == 0) {
	    			
	    			res.add(Arrays.asList(nums[pos], nums[start],nums[end]));
	    			start++;
	    			while (nums[start] == nums[start-1] && start < end) {
		    			start++;
		    		}
	    		}else if (sum > 0) {
	    			end--;
	    		} else {
	    			start++;
	    		}
	    	}
			
			
		}
	}

}
