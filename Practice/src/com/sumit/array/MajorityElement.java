package com.sumit.array;

public class MajorityElement {
	
	public static void main(String[] args) {
		
		int [] nums = {2,2,1,1,1,2,2};
		
		System.out.println(new Solution().majorityElement(nums));
	}
	
	static class Solution {
	    public int majorityElement(int[] nums) {
	    	
	    	//#find candidate for majority element using moore's voting algo (check description)
	        int count = 0;
	        int candidate = nums[0];
	        for (int num : nums) {
	        	if (num == candidate){   
	        		count += 1;
	        	}else {
	    	                count -= 1;
	    	                if (count == 0 ){
	    	                    candidate = num;
	    	                    count = 1;
	    	                }
	    	            }
	        }
	            
	        //no need to verify candidate since problem assures there is a majority element
	        return candidate;
	        
	    }
	}
	

}
