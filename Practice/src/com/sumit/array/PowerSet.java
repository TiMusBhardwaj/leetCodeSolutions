package com.sumit.array;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	
	public static void main(String[] args) {
		
		int [] nums = {1,2,3};
		
		System.out.println(new Solution().subsets(nums));
	}
	
	static class Solution {
	    public List<List<Integer>> subsets(int[] nums) {
	    	
	    	bfs(nums, 0);
	    	return res;
	        
	    }
	    List<List<Integer>> res = new ArrayList<>();
	    public void bfs(int[] nums, int i) {
	    	
	    	if (i == nums.length-1) {
	    		List<Integer> list=  new ArrayList<>();
	    		list.add(nums[nums.length-1]);
	    		res.add(list);
	    		res.add(new ArrayList<>());
	    		return;
	    	} else {
	    		bfs(nums, i+1);
	    		List<List<Integer>> listT = new ArrayList<>();
	    		for (List<Integer> prev: res) {
	    			List<Integer> list = new ArrayList<>(prev);
	    			list.add(nums[i]);
	    			listT.add(list);
	    			
	    		}
	    		res.addAll(listT);
	    		
	    }
	    }
	    
	}

}
