package com.sumit.array;
	
public class Search2DSortedArray {
	
	public static void main(String[] args) {
		
		int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		System.out.println(new Solution().searchMatrix(matrix, 3));
	}
	
	static class Solution {
	    public boolean searchMatrix(int[][] matrix, int target) {
	    	if (matrix.length == 0 || matrix[0].length == 0) {
	    		return false;
	    	}
	    	
	    	int x=0;
	    	int y = matrix[0].length-1;
	    	while (y >=0 && x < matrix.length) {
	    		if (matrix[x][y] == target)
	    			return true;
	    		else if(matrix[x][y] > target){
	    			y--;
	    		}else {
	    			x++;
	    		}
	    	}
	    	
	    	
	        
	    	return false;
	    }
	}
}
