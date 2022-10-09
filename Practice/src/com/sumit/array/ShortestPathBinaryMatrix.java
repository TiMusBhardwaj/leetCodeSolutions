package com.sumit.array;

import java.util.HashMap;
import java.util.Map;

public class ShortestPathBinaryMatrix {
	
	public static void main(String[] args) {
		
		int [][] grid ={{0,0,0,0,1,1},
						{0,1,0,0,1,0},
						{1,1,0,1,0,0},
						{0,1,0,0,1,1},
						{0,1,0,0,0,1},
						{0,0,1,0,0,0}};
		
		System.out.println(new Solution().shortestPathBinaryMatrix(grid));
	}
	
	static class Solution {
	    public int shortestPathBinaryMatrix(int[][] grid) {
	       if (grid [0][0]==1)
	    	   return -1;
	       int res= path(grid, 0, 0);
	       return solved? res:-1; 
	    }
	    boolean solved = false;
	    Map<Integer, Integer> mem = new HashMap<>();
	    int [][] dir = {{1,1},{0,1},{1,0},{-1,0},{0,-1}, {-1,1},{1,-1},{-1,-1}};
	    
	    private int path(int[][] grid, int r, int c) {
	    	
	    	if (r == grid.length-1 && c==grid.length-1) {
	    		solved = true;
	    		return 1;
	    	}
	    	
	    	if (mem.containsKey(r*grid.length+c)) {
	    		return mem.get(r*grid.length+c);
	    	}
	    	int res = Integer.MAX_VALUE-1;
	    	System.out.println(" --- " + r+ "-"+ c);
	    	grid[r][c]=1;
	    	for (int i=0; i<dir.length ; i++) {
	    		int rT = r+dir[i][0];
	    		int cT = c+dir[i][1];
	    		 if (rT>=0 & cT >=0 && rT<grid.length && cT < grid.length && grid[rT][cT] ==0 ) 
	    			res = Math.min(res, 	path(grid, rT, cT)+1);
	    		
	    		
	    	}
	    	grid[r][c]=0;
    		System.out.println(res +" --- " + r+ "-"+ c);
    		
	    	mem.put(r*grid.length+c, res);
	    	
	    	return res;
	    	
	    	
	    }
	}

}
