package com.sumit.array;

import java.util.Arrays;
import java.util.stream.IntStream;

//https://leetcode.com/problems/house-robber/
public class HouseRobberProblem2 {
	public static void main(String[] args) {
		//int [] arr = {2,7,9,3,1};
		int [] arr = {1,2,3,4,5,1,2,3,4,5};
		System.out.println(new Solution().rob(arr));
	}

static class Solution {
	int [] mem;
    public int rob(int[] nums) {
    	mem = new int[nums.length];
    	IntStream.range(0, nums.length).forEach(x-> mem[x]=-1);
    	int length = nums.length;
    	if (length <=3) {
    		Arrays.sort(nums);
    		return nums[length-1];
    	}
    	int res1 = getMaxOfArray2(0, length-2, nums);
    	mem = new int[nums.length];
    	IntStream.range(0, nums.length).forEach(x-> mem[x]=-1);
    	int res2 = getMaxOfArray2(1, length-1, nums);
		return Math.max(res1, res2);
        
    }
    
    
    int getMaxOfArray2(int startIndex, int endIndex, int[] nums) {
    	
    	mem[startIndex] = nums[startIndex];
    	for (int i=startIndex+1 ; i<= endIndex;i++) {
    		int current = nums[i];
    		if (i>startIndex+1) {
    			current += mem[i-2]; 
    		}
    		mem[i] = Math.max(mem[i-1], current);
    		
    	}
    	
    	
    	
    	return mem[endIndex];
    }
    
}
}