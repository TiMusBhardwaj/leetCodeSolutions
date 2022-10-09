package com.sumit.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundingRegions {
	
	public static void main(String[] args) {
		
		char [][] board = {{'X'}};//{{'X','X','X','X'},{'X','O','X','X'},{'O','X','X','O'},{'X','X','O','X'}};
		
		new Solution().solve(board);
		
		System.out.println(Arrays.deepToString(board));
		
	}
	
	
	static class Solution {
		
		int [] [] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
		
	    public void solve(char[][] board) {
	    	
	    	bfs(board);
	    }
	    int dx[] = new int[]{-1, 1, 0, 0}; 
	    int dy[] = new int[]{0, 0, 1, -1}; 
	    public void bfs(char[][] board)
	    {
	    	
	    	 int n = board.length, m = board[0].length; 
	    	 if (n <3 && m <3)  {
	    		 return;
	    	 }
	    	 Queue<int[]> queue = new LinkedList<>();
	    	 for(int i=0; i<n; i += n-1)
	         {
	             for(int j=0; j<m; j++)
	             {
	                 if(i == 0 || j == 0 || i == n-1 || j == m-1)
	                 {
	                     if(board[i][j] == 'O')
	                     {
	                         queue.add(new int[]{i, j});
	                         board[i][j] = '*';
	                     }
	                 }
	             }
	         }
	    	 
	    	 for(int i=0; i<n; i++)
	         {
	             for(int j=0; j<m; j+= m-1)
	             {
	                 if(i == 0 || j == 0 || i == n-1 || j == m-1)
	                 {
	                     if(board[i][j] == 'O')
	                     {
	                         queue.add(new int[]{i, j});
	                         board[i][j] = '*';
	                     }
	                 }
	             }
	         }
	         
	         while(!queue.isEmpty())
	         {
	             int curr[] = queue.poll();
	             for(int i=0; i<4; i++)
	             {
	                 int newX = curr[0] + dx[i]; 
	                 int newY = curr[1] + dy[i];
	                 
	                 if(newX >= 0 && newY >= 0 && newX < n && newY < m && board[newX][newY] == 'O')
	                 {
	                     queue.add(new int[]{newX, newY}); 
	                     board[newX][newY] = '*'; 
	                 }
	             }
	         }
	         
	         for(int i=0; i<n; i++)
	         {
	             for(int j=0; j<m; j++)
	             {
	                 if(board[i][j] == '*')
	                     board[i][j] = 'O'; 
	                 
	                 else
	                     board[i][j] = 'X';
	             }
	         }
	    	 
	    }
	    
	}
	

}
