package com.sumit.array;


//https://leetcode.com/problems/find-peak-element/?envType=study-plan&id=algorithm-ii
public class FindPeakElement {
	
	public static void main(String[] args) {
		
		//int [] nums = {1,2,3,1}; 
		int [] nums = {1,2,3,1,2,5,2}; 
		System.out.println(new Solution().findPeakElement(nums));
	}

	
	static class Solution {
	    public int findPeakElement(int[] nums) {
	    	
	    	
	    	int start =0;
	    	int end = nums.length-1;
	    	int mid =-1;
	    	while(start < end) {
	    		
	    		 mid= start + (end-start)/2;
	    		
	    		if ( nums [mid] > nums[mid+1] && (mid==0 || nums[mid] > nums[mid-1])) {
	    			return mid;
	    		}
	    		if (nums [mid] < nums[mid+1]) {
	    			start = mid+1;
	    		}else {
	    			end = mid-1;
	    		}
	    	}
	    	
	    	return start;
	        
	    }
	}
}
