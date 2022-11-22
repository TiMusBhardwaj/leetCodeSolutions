package com.sumit.binarysearch;

public class KokoEatingBanana {

	public static void main(String[] args) {
		
		int [] piles = {312884470};//[312884470][312884470]
		
				
		
		System.out.println(new Solution().minEatingSpeed(piles, 968709470));
	}
	
	
	static class Solution {
	    public int minEatingSpeed(int[] piles, int h) {
	    	
	    	
	    	
	    	int left = getMinValue(piles)/h +(getMinValue(piles)%h >0? 1:0), right = getMaxValue(piles);
	    	
	    	while (left < right) {
	    		
	    		int mid = left + (right-left)/2;
	    		if (feasible(piles, mid, h)) {
	    			right = mid;
	    		}else {
	    			left = mid+1;
	    		}
	    	}
	    	
	        return left;
	    }
	    
	    private boolean feasible(int[] piles, int mid, int h) {
	    	
	    	int t=0; 
	    	for (int pile : piles) {
	    		t += (pile/mid + (pile%mid >0? 1:0));
	    		
	    		if (t > h)
	    			return false;
	    	}
	    	
	    	return true;
	    }
	    
	    private static int getMaxValue(int[] array) {
	        int maxValue = array[0];
	        for (int i = 0; i < array.length; i++){
	            if (array[i] > maxValue){
	                maxValue = array[i];
	            }
	        }
	        return maxValue;
	    }

	    private static int getMinValue(int[] array) {
	        int minValue = array[0];
	        for (int i = 0; i < array.length; i++){
	            if (array[i] < minValue) {
	                minValue = array[i];
	            }
	        }
	        return minValue;
	    }
	}
}
