package com.sumit.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	
	
	public static void main(String[] args) {
		int [] nums = {1,2,3};
		
		System.out.println(new Solution().subarraySum(nums, 3));
	}
	
	static class Solution {
	    public int subarraySum(int[] nums, int k) {
	    	
	    	int sumSoFar = 0;
	    	int res =0;
	    	
	    	Map<Integer, Integer> preHash = new HashMap<>();
	    	preHash.put(0, 1);
	    	
	    	for (int i=0; i<nums.length;i++) {
	    		
	    		sumSoFar+=nums[i];
	    		
	    		if (preHash.containsKey(sumSoFar-k)){
	    			res+=preHash.get(sumSoFar-k);
	    		}
	    		preHash.putIfAbsent(sumSoFar, 0);
	    		preHash.computeIfPresent(sumSoFar, (key, val) -> val + 1);
	    	}
	    	
			return res;
	        
	    }
	}
	
	

}
