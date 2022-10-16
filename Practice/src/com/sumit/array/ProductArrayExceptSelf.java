package com.sumit.array;

import java.util.Arrays;

public class ProductArrayExceptSelf {
	
	public static void main(String[] args) {
		
		int [] nums = {1,2,3,4};
		
		int [] res = new Solution().productExceptSelf(nums);
		
		System.out.println(Arrays.toString(res));
	}
	
	static class Solution {
	    public int[] productExceptSelf(int[] nums) {
	    	
	    	int [] left =  new int [nums.length];
	    	int [] right = new int [nums.length];
	    	int [] res = new int [nums.length];
	    	int le =1;
	    	int ri =1;
	    	
	    	for (int i = 0; i< nums.length; i++) {
	    		left[i] = le*nums[i];
	    		le = left[i];
	    		
	    		right[nums.length-1-i] = ri*nums[nums.length-1-i];
	    		ri = right[nums.length-1-i];
	    		
	    	}
	    	for (int i = 0; i< nums.length; i++) {
	    		
	    		int re =1;
	    		if (i>0) {
	    			re = re* left[i-1];
	    		}
	    		if (i < nums.length-1) {
	    			re*=right[i+1];
	    		}
	    		res[i] = re;
	    	}
	    	
	        return res;
	    }
	}

}
