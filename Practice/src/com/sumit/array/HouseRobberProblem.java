package com.sumit.array;

import java.util.stream.IntStream;

//https://leetcode.com/problems/house-robber/
public class HouseRobberProblem {
	public static void main(String[] args) {
		int [] arr = {2,7,9,3,1};
		System.out.println(new Solution().rob(arr));
	}
}
class Solution {
	int [] mem;
    public int rob(int[] nums) {
    	mem = new int[nums.length];
    	IntStream.range(0, nums.length).forEach(x-> mem[x]=-1);
		return getMaxOfArray2(0, nums);
        
    }
    
    int getMaxOfArray(int startIndex, int[] nums) {
    	if (startIndex >= nums.length) {
    		return 0;
    	}
    	if (mem[startIndex] !=-1) return mem[startIndex];
    	int res = Math.max(nums[startIndex]+ getMaxOfArray(startIndex + 2,nums),getMaxOfArray(startIndex + 1,nums));
    	mem[startIndex] = res;
    	return res;
    }
    int getMaxOfArray2(int startIndex, int[] nums) {
    	
    	mem[0] = nums[0];
    	for (int i=1 ; i<nums.length;i++) {
    		int current = nums[i];
    		if (i>1) {
    			current += mem[i-2]; 
    		}
    		mem[i] = Math.max(mem[i-1], current);
    		
    	}
    	
    	
    	
    	return mem[nums.length-1];
    }
    
}