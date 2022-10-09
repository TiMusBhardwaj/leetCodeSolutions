package com.sumit.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
	
	public static void main(String[] args) {
		
		char [][]board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
		System.out.println(new Solution().exist(board, "ABCESEEEFS"));
		System.out.println('a'^256);
	}
	
	static class Solution {
		
		
	    public boolean exist(char[][] board, String word) {
	    	
	    	
	    	
	        
	    	for (int i=0; i < board.length; i++) {
	    		
	    		for (int j =0 ; j < board[0].length; j++) {
	    			
	    			if (recursive(board, word, 0, i, j)) {
	    				return true;
	    			}
	    		}
	    		
	    	}
	    	return false;
	    }
	    List<Integer> used = new ArrayList<>();
	    int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	    
	    Set<String> mem = new HashSet<>();
	    
	    private boolean recursive(char[][] board, String word, int indexAtWord, int rowC, int colC) {
	    	
	    	if (indexAtWord == word.length()) {
	    		return true;
	    	}
	    	
	    	
	    	if (rowC<0 || colC <0 || rowC == board.length || colC == board[0].length)
	    		return false;
	    	
	    	if (word.charAt(indexAtWord) != board[rowC][colC]) 
	    		return false;
	    	
	    	
	    	board[rowC][colC] ^=  256;
	    	 
	    	for (int [] d: dir) {
	    		int rowD = rowC+d[0];
	    		int colD = colC+d[1];
	    		
	    		
	    			if (recursive(board, word, indexAtWord+1, rowD, colD)) {
	    				return true;
	    			}
	    		
	    		
	    		
	    	}
	    	board[rowC][colC] ^=  256;
	    	return false;
	    	
	    }
	}

}
