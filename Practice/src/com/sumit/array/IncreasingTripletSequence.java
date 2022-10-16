package com.sumit.array;

public class IncreasingTripletSequence {
	
	public static void main(String[] args) {
		int[] nums = {10,9,8,5,4,7,12};
		
		System.out.println(new Solution().increasingTriplet(nums));
	}
	
	static class Solution {
		
		
	    public boolean increasingTriplet(int[] nums) {
	    	
	    	int a = Integer.MAX_VALUE;
	    	int b = Integer.MAX_VALUE;
	    	
	    	
	    	for (int num : nums) {
	    		if (num <= a)
	    			a = num;
	    		else if (num <= b)
	    			b = num;
	    		else 
	    			return true;
	    	}
	    	return false;
	    }
	}
	

}
