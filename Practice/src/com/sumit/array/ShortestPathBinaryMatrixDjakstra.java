package com.sumit.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class ShortestPathBinaryMatrixDjakstra {
	
	public static void main(String[] args) {
		
		int [][] grid1 ={{0,0,0,0,1,1},
						{0,1,0,0,1,0},
						{1,1,0,1,0,0},
						{0,1,0,0,1,1},
						{0,1,0,0,0,1},
						{0,0,1,0,0,0}};
		int [][] grid ={{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}};
		
		System.out.println(new Solution().shortestPathBinaryMatrix(grid));
	}
	
	static class Solution {
	    public int shortestPathBinaryMatrix(int[][] grid) {
	       if (grid [0][0]==1 || grid [grid.length-1][grid.length-1]==1)
	    	   return -1;
	       return  path(grid);
	       //return solved? res:-1; 
	    }
	    boolean solved = false;
	    //Map<Integer, Integer> mem = new HashMap<>();
	    int [][] dir = {{1,1},{0,1},{1,0},{-1,0},{0,-1}, {-1,1},{1,-1},{-1,-1}};
	    
	    private int path(int[][] grid) {
	    	
	    	int n=grid.length;
	    	int[][]mem=new int[n][n];
	    	for(int row[]:mem)
	            Arrays.fill(row, (int)1e9);
	    	Queue<Pair> q = new LinkedList<Pair>();
	    	Pair p = new Pair(0,0, 0);
	    	mem[0][0]=0;
	    	q.add(p);
	    	while (!q.isEmpty()) {
	    		
	    		Pair pT = q.poll();
	    		
	    		int r = pT.x;
	    		int c = pT.y;
	    		if (r == grid.length-1 && c == grid.length-1) {
	    			return pT.cost+1;
	    		}
	    		grid[r][c] = 2;
	    		for (int i=0; i<dir.length ; i++) {
		    		int rT = r+dir[i][0];
		    		int cT = c+dir[i][1];
		    		
		    		
		    		 if (rT>=0 & cT >=0 && rT<grid.length && cT < grid.length && grid[rT][cT] ==0 && pT.cost+1 < mem[rT][cT]) {
		    			 Pair pTT = new Pair(rT, cT, -1);
		    			 pTT.cost = pT.cost+1 ;
		    			 mem[rT][cT] = pT.cost+1;
		    			 q.add(pTT);
		    			 
		    		 }
		    	}
	    	}
	    	
	    	return -1;
	    	
	    	
	    }
	    static class Pair implements Comparable<Pair>{
			
			int x;
			int y;
			int cost;
			
			public Pair(int r,int c, int cost) {
				super();
				this.x = r;
				this.y = c;
				this.cost = cost;
			}
			@Override
			public int hashCode() {
				return Objects.hash(cost);
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
				return cost == other.cost;
			}
			
			
			@Override
			public String toString() {
				return "Pair [r=" + x + ", c=" + y + ", cost=" + cost + "]";
			}
			@Override
			public int compareTo(Pair o) {
				
				return this.cost-o.cost;
			}
			
			
		}
	}
	
	

}
