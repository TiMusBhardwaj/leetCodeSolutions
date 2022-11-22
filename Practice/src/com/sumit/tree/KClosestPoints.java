package com.sumit.tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
	
	public static void main(String[] args) {
		int [][] in = {{3,3},{5,-1},{-2,4}};
		
		System.out.println(Arrays.deepToString(new Solution().kClosest(in, 2)));
	}
	
	static class Solution {
	    public int[][] kClosest(int[][] points, int k) {
	    	
	    	PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
	    		
			
				@Override
				public int compare(int[] o1, int[] o2) {
					return (int) ((Math.pow(o1[0], 2)+Math.pow(o1[1], 2))-(Math.pow(o2[0], 2)+Math.pow(o2[1], 2)));
					
				}
			});
	    	queue.
	    	
	    	for (int[] point : points) {
	    		queue.add(point);
	    	}
	    	
	        
	        return queue.toArray(new int[k][]);
	    }
	}

}
