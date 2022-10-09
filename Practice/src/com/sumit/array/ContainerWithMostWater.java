package com.sumit.array;

//https://leetcode.com/problems/container-with-most-water/?envType=study-plan&id=algorithm-ii
public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		
		int [] height = {1,1};
		
		System.out.println(new Solution().maxArea(height));
	}

	static class Solution {
	    public int maxArea(int[] height) {
	    	
	    	int area = Integer.MIN_VALUE;
	    	int l=0;
	    	int r=height.length-1;
	    	
	    	while (l<r) {
	    		area = Math.max(area, (r-l)*Math.min(height[l], height[r]));
	    		if (height[l]<= height[r]) {
	    			l++;
	    		}else {
	    			r--;
	    		}
	    	}
	    	
			return area;
	        
	    }
	}
}
