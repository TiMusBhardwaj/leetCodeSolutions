package com.sumit.array;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
public class FindMinimumInRotatedArray {
	
	public static void main(String[] args) {
		
		int [] nums = {4,3};
		System.out.println(new Solution().findMin(nums));
	}
	
	static class Solution {
	    public int findMin(int[] nums) {
	    	
	    	int start =0;
	    	int end = nums.length-1;
	    	
	    	if (nums.length == 1) {
	            return nums[0];
	        }
	    	if (nums[end] > nums[0]) {
                return nums[0];
            }
	    	
	    	while (end >= start) {
	    		
	    		int mid = start+(end-start)/2;
	    		
	    		if ( nums[mid] > nums[mid+1]) {
	    			return nums[mid+1];
	    		}
	    		if ( nums[mid] < nums[mid-1]) {
	    			return nums[mid];
	    		}
	    		
	    		
	    		
	    		if (nums[mid] > nums[start] ) {
	    			start = mid+1;
	    		}else {
	    			end = mid-1;
	    		}
	    	}
	    	
	    	return Integer.MAX_VALUE;
			
	        
	    }
	}

}
