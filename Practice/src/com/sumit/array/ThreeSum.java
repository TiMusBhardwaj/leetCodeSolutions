package com.sumit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/3sum/
public class ThreeSum {
	
	public static void main(String[] args) {
		int [] nums = {-1,0,1,2,-1,-4};
		System.out.println(new Solution().threeSum(nums));
	}
	
	static class Solution {
	    public List<List<Integer>> threeSum(int[] nums) {
	    	List<List<Integer>> sumList = new ArrayList<>();
	    	Arrays.sort(nums);
	    	for(int pos=0; pos< nums.length-2;pos++) {
	    		if (pos !=0  && nums[pos] == nums[pos-1]) {
	    			continue;
	    		}
	    		sumList.addAll(twoSum(nums, pos));
	    	}
	    	
	    	return sumList;
	    }
	    
	    public List<List<Integer>> twoSum(int[] nums, int pos) {
	    	List<List<Integer>> sumList = new ArrayList<>();
	        int start =pos+1;
	    	int end = nums.length-1;
	    	while(start< end) {
	    		int sum = nums[start]+nums[end]+nums[pos];
	    		if(sum == 0) {
	    			
	    			sumList.add(Arrays.asList(nums[pos], nums[start],nums[end]));
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
	    	
	    	return sumList;
	    }
	}

}
