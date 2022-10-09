package com.sumit.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/count-number-of-bad-pairs/
public class BadPairs {
	
	public static void main(String[] args) {
		
		int [] nums = {1,2,3,4,5};
		System.out.println(nums.length*(nums.length-1)/2);
		//new Solution().countBadPairs(nums);
	}
	
	static class Solution {
	    public long countBadPairs(int[] nums) {
	    	long goodPairs = 0;
	    	long totalPairs = nums.length*(nums.length-1)/2;
	    	Map<Long,Long> pairsCount= new HashMap<>();
	    	for (Long i=0l; i< nums.length;i++) {
	    		
	    		long prev= pairsCount.getOrDefault(i-nums[i.intValue()] , 0l);
	    		goodPairs += prev;
	            pairsCount.put(i-nums[i.intValue()] , prev+1l);
	    	}
	    	
	        
	        return totalPairs-goodPairs;
	    }
	}
	
}
