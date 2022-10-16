package com.sumit.array;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverLappingIntervals {
	
	public static void main(String[] args) {
		int [][] matrix  = {{1,2},{1,2},{3,4},{1,3}};
		
		int res = new Solution().eraseOverlapIntervals(matrix);
		System.out.println(res);
		
	}
	
	static class Solution {
	    public int eraseOverlapIntervals(int[][] intervals) {
	        
	    	Comparator<int[]> com = (o1, o2) -> (o1[0]-	 o2[0]);
	    	com = com.thenComparing((o1, o2) -> (o2[1]-	 o1[1]));
	    	
	    	Arrays.sort(intervals, com);
	    	System.out.println(Arrays.deepToString(intervals));
	    	int current =0;
	    	int next =1;
	    	
	    	int res =0;
	    	
	    	while (next < intervals.length) {
	    		
	    		if (intervals[current][1] > intervals[next][0]) {
	    			if (intervals[current][1] > intervals[next][1]) {
	    				
	    				current = next;
	    				next++;
	    			}else {
	    				next++;
	    			}
	    			res++;
	    		}else {
	    		
	    			current = next;
	    			next++;
	    		}
	    	}
	    	
	    	return res;
	    }
	}

}
