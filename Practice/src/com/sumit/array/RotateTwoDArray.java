package com.sumit.array;

import java.util.Arrays;

public class RotateTwoDArray {
	
	public static void main(String[] args) {
		int[][] matrix = {{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26},{33,1,20,7,21,7},{4,24,1,6,32,34}};//{{5,1,9,11,5},{2,4,8,10,6},{13,3,6,7,8},{15,14,12,16,9},{1,3,5,77,88}};
		
		for (int [] arr : matrix) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
		new Solution().rotate(matrix);
		
		for (int [] arr : matrix) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	static class Solution {
	    public void rotate(int[][] matrix) {
	        
	    	//int j=0;
	    	
	    	//int i=0;
	    	
	    	for (int i=0; i<matrix.length/2 ; i++) {
	    		int j=i;
	    		int n = matrix.length-1-i;
	    		int count=0;
		    	while (j<=n) {
		    		swap(i, j, j, n, matrix);
			    	swap(i, j, n, n-count, matrix);
			    	swap(i, j, n-count, i, matrix);
			    	count++;
			    	j++;
		    	}
		    	for (int [] arr : matrix) {
					//System.out.println(Arrays.toString(arr));
				}
		    	System.out.println();
		    	
	    	}
	    	
	    }
	    
	    private void swap(int i, int j, int _i, int _j, int [][] matrix){
	    	
	    	int temp = matrix[i][j];
	    	 matrix[i][j] = matrix[_i][_j];
	    	 matrix[_i][_j] = temp;
	    }

		
		
		
	}
	
	static class Solution2 {
	    public void rotate(int[][] matrix) {
	        
	    	transpose(matrix);
	    	swap(matrix);
	    }

		private void transpose(int[][] matrix) {
			
			for (int i=0; i< matrix.length;i++) {
				
				for (int j=i;j<matrix.length;j++) {
					
					if (i==j)
						continue;
					
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
				
			}
			
		}
		
		private void swap(int [][] matrix) {
			int start = 0;
			int end = matrix.length-1;
			while (start < end) {
				
				for (int i=0; i< matrix.length; i++) {
					
					int temp = matrix[i][start];
					matrix[i][start] = matrix[i][end];
					matrix[i][end] = temp;
				}
				
				start++;
				end--;
			}
			
		}
	}

}
