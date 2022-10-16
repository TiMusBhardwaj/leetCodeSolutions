package com.sumit.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle {
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().getRow(2));
	}
	
	static class Solution {
	    public List<Integer> getRow(int rowIndex) {
	    	
	    List<Integer> list = new ArrayList<>();
	    	
	     for (int i = 0; i<= rowIndex; i++) {
	    	 
	    	 
	    	 
	    	 list.add(getRow(rowIndex-1, i));
	     }
	    	
	      return list;  
	    }
	    
	    Map<String, Integer> mem = new HashMap<>();
	    public Integer getRow(int rowIndex, int counter) {
	    	
	    	if (mem.containsKey(rowIndex+"-"+counter)) {
	    		return mem.get(rowIndex+"-"+counter);
	    	}
	    	
	    	if (counter ==0 || counter>rowIndex) {
	    		return 1;
	    	
	    	}else {
	    		int n = getRow(rowIndex-1, counter-1) + getRow(rowIndex-1, counter);
	    		mem.put(rowIndex+"-"+counter, n);
	    		return n;
	    	}
	    }
	}

}
