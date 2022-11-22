package com.sumit.array;

import java.util.Arrays;

public class EarliestPossibleDayOfBloom {
	
	
	public static void main(String[] args) {
		int [] plantTime = {1,2,3,2}, growTime = {2,1,2,1};
		
		System.out.println(new Solution().earliestFullBloom(plantTime, growTime));
	}

	static class Solution {
	    public int earliestFullBloom(int[] plantTime, int[] growTime) {
	    	
	    	int [][] arr = new int[plantTime.length][2];
	    	int maxDays = 0;
	    	int plantDaysSoFar = 0;
	    	for (int i=0; i< plantTime.length;i++) {
	    		arr[i][0] = plantTime[i];
	    		arr[i][1] = growTime[i];
	    	}
	    	
	    	Arrays.sort(arr,  (x, y)-> y[1]-x[1]);
	        
	    	for (int [] ar : arr) {
	    		maxDays = Math.max(maxDays, plantDaysSoFar + ar[0]+ar[1]);
	    		plantDaysSoFar += ar[0];
	    		
	    	}
	    	return maxDays;
	    }
	}
}
