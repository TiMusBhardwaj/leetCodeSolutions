package com.sumit.array;

public class RotatedSortedArray {
	
	public static void main(String[] args) {
		int [] nums = {4,5,6,7,0,1,2};
		System.out.println(new Solution().search(nums, 0));
	}

	static class Solution {
	    public int search(int[] nums, int target) {
	        
	    	
	    	if (nums.length ==0) return -1;
	    	int l =0;
	    	int r = nums.length-1;
	    	
	    	while(l<=r) {
	    		
	    		int mid = (l+r)/2;
	    		if (target == nums[mid]) return mid;
	    		
	    		if (nums[l]<= nums[mid]) {
	    			
	    			if (nums[l] <= target && target <= nums[mid]) {
	    				r =mid-1;
	    			}else {
	    				l = mid+1;
	    			}
	    		} else {
	    			if (nums[mid]<= target && target <= nums[r]) {
	    				l=mid+1;
	    			}else {
	    				r=mid-1;
	    			}
	    		}
	    		
	    	}
	    	return -1;
	    }
	}
	
}
