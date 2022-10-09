package com.sumit.array;

import java.util.Stack;

public class NumberOfProvinces {

	
	public static void main(String[] args) {
		int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(new Solution().findCircleNum(isConnected));
		
	}
	
	static class Solution {
	    public int findCircleNum(int[][] isConnected) {
	    	
	    	Stack<Integer> st = new Stack<>();
	    	if (isConnected.length == 0) {
	    		return 0;
	    	}
	    	
	    	int n = isConnected.length, m = isConnected[0].length, count = 0;
	        
	        for(int i = 0; i < n; i++){
	            for(int j = 0; j < m; j++){
	            	if (isConnected[i][j] == 1) {
	            		isConnected[i][j] = 0;
	            		st.push(i*m+j);
	            		
	            	}
	            }
	            if (st.isEmpty()) {
            		continue;
            	}
            	count++;
            	while (!st.isEmpty()) {
        			int in = st.pop();
        			int r = in/m;
        			int c = in%m;
        			
        			if (r == c) {
        				continue;
        			}
        			int counter = 0;
        			while (counter < m ) {
        				
        				
        				if (isConnected[c][counter] == 1 ) {
        					isConnected[c][counter] = 0;
        					st.push((c*m)+counter);
        					
        				}
        				counter++;
        			}
        			
        		}
            	
            
	        }
	    	
	        return count;
	    }
	}
}
