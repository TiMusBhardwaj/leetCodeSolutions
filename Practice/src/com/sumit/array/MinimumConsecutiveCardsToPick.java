package com.sumit.array;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardsToPick {
	
	public static void main(String[] args) {
		
	}
	
	
	static class Solution {
	    public int minimumCardPickup(int[] cards) {
	    	
	    	int min = Integer.MAX_VALUE;
	    	Map<Integer, Integer> map = new HashMap<>();
	    	
	    	for (int i =0; i < cards.length;i++) {
	    		
	    		if (map.containsKey(cards[i])) {
	    			min = Math.min(min, i-map.get(cards[i]));
	    		}
	    		map.put(cards[i], i);
	    		
	    	}
	    	
	        return min == Integer.MAX_VALUE?-1:min+1;
	    }
	}

}
