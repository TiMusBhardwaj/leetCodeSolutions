package com.sumit.array;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
	
	public static void main(String[] args) {
		int [][] arr = {{2,1,1},{0,1,1},{1,0,1}};
		System.out.println(new Solution().orangesRotting(arr));
	}
	
	static class Solution {
		
	    public int orangesRotting(int[][] grid) {
	    	int time =0;
	    	Queue<Pair>  st = getRottenInStack(grid);
	    	int fairOranges = getFair(grid);
	    	
	    	int [][] direction  = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	    	while (!st.isEmpty() && fairOranges >0) {
	    		int stLength = st.size();
	    		while(stLength-- > 0) {
	    			Pair pair = st.poll();
		    		for (int [] dir : direction)
		    		{
		    			int row = pair.i+dir[0];
		    			int col = pair.j+dir[1];
		    			if (row <0 || row == grid.length || col<0 || col == grid[0].length || grid[row][col] !=1) {
		    				continue;
		    			}
		    			grid[row][col] =2;
		    			st.add(new Pair(row, col));
		    			fairOranges--;
		    		}
	    		}
	    		
	    		time++;
	    	}
	    	return fairOranges == 0 ?time:-1 ;
	    	
	        
	    }
	    private int getFair(int[][] grid) {
	    	int rows =grid.length;
	    	int columns = grid[0].length;
	    	int count=0;
	    	for (int i = 0;
	                 i < rows * columns; i++) {
	     
	                // Find row and column index
	                int row = i / columns;
	                int col = i % columns;
	     
	                if (grid[row][col] == 1) count++;
	            }    

	    	 
			return count;
		}
		
		private Queue<Pair> getRottenInStack(int[][] grid){
	    	
			Queue<Pair> st = new LinkedList<>();
	    	IntStream.range(0, grid.length).forEach(
	    			x-> IntStream.range(0, grid[x].length).filter(y -> grid[x][y]==2).forEach(
	    					y-> {
	    						st.add(new Pair(x, y));
	    					}));
	    	return st;
	    }
	}
	
	
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
		
		
		@Override
		public int hashCode() {
			return Objects.hash(i, j);
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			return i == other.i && j == other.j;
		}



		@Override
		public String toString() {
			return "[i=" + i + ", j=" + j + "]";
		}
		
		
	}

}
