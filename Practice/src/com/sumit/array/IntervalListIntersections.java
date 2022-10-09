package com.sumit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
	
	public static void main(String[] args) {
		
		int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
		int[][]secondList = {{1,5},{8,12},{15,24},{25,26}};
		
		System.out.println(Arrays.deepToString(new Solution().intervalIntersection(firstList, secondList)));
		
	}
	static class Solution {
	    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
	    	if (firstList.length == 0 || secondList.length==0) {
	    		return new int[0][0];
	    	}
	    	
	    	List<int[]> res = new ArrayList<>();
	    	int i=0, j=0;
	    	while (i< firstList.length && j< secondList.length) {
	    
		    	int start = Math.max(firstList[i][0], secondList[j][0]);
		    	int end = Math.min(firstList[i][1], secondList[j][1]);
		    	
		    	if (start <=end) {
		    		int [] temp= {start,end};
		    		res.add(temp);
		    	}
		    	if (firstList[i][1]<= secondList[j][1]) {
		    		i++;
		    	}else {
		    		j++;
		    	}
	    	}  
	    	
	    	return res.toArray(new int[res.size()][2]);
	    }
	}
	
	
	
}
