package com.sumit.array;

import java.util.Stack;

public class NumberOfIslands {
	
	
	
	public static void main(String[] args) {
		
		
		char [][]grid = {
		               {'1','1','0','0','0'},
		               {'1','1','0','0','0'},
		               {'0','0','1','0','0'},
		               {'0','0','0','1','1'}
		             };
		
		
		System.out.println(new Solution().numIslands(grid));
	}

	
	
	static class Solution {
		
		static int [][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
		
	    public int numIslands(char[][] grid) {
	    	Stack<Integer> st = new Stack<>();
	        int res=0;
	        int index =0;
	        int len = grid.length;
	         
	        if (len ==0) {
	        	return 0;
	        }
	        int col = grid[0].length;
	        
	        
	        while (index <len* col) {
	        	
	        	int m = index/col;
	        	int n = index%col;
	        	
	        	if (grid[m][n] != '1') {
	        		index++;
	        		continue;
	        		
	        	}
	        	
	        	res++;
	        	
	        	
	        	
	        	
	        	st.push(index);
	        	while (!st.isEmpty()) {
	        		
	        		int indexT = st.pop();
	        		
	        		int mT = indexT/col;
		        	int nT = indexT%col;
		        	
	        		if (grid[mT][nT] == '0') {
	        			continue;
	        		}
	        		grid[mT][nT] = '0';
	        		for (int i =0; i < dir.length ;i++) {
	        			int r = mT+dir[i][0];
	        			int c = nT+ dir[i][1];
	        			if (r >=0 && r < len && c >=0 && c < col  ) {
	        				int temp = r*col+ c;
	        				st.push(temp);
	        			}
	        			
	        		}
	        		
	        		
	        		
	        	}
	        	
	        }
	        
	        
	        return res;
	    	
	    	
	    }
	}
}
