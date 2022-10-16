package com.sumit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	public static void main(String[] args) {
		
		int [][] map = {{1,5},{1,4},{2,3}, {6,9},{2,1},{2,5}};
		
		int[][] res = new Solution().merge(map);
		System.out.println(Arrays.deepToString(res));
	}
	
	static class Solution {
	    public int[][] merge(int[][] intervals) {
	    	Comparator<int[]> c = Comparator.comparing(x -> x[0]);
	    	c = c.thenComparing(x -> x[1]);
	    	Arrays.sort(intervals, c);
	    	List<int[]> list = new ArrayList<>();
	    	int[] prev = intervals[0];
	    	
	    	for (int i =1; i< intervals.length; i++)
	    	{
	    		if (intervals[i][0] <= prev[1]) {
	    			prev [1] = Math.max(prev [1], intervals[i][1]);
	    			
	    		}else {
	    			list.add(prev);
	    			prev = intervals[i];
	    		}
	    	}
	    	list.add(prev);
	    	
	    	int[] [] res = list.toArray(new int[list.size()][]);
	        return res;
	    }
	}

}
