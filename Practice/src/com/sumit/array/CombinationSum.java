package com.sumit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public static void main(String[] args) {
		
		int[] nums = {10,1,2,7,6,1,5};

		List<List<Integer>> l = new Solution().combinationSum(nums, 8);

		System.out.println(l);
	}
	
	static class Solution {
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        Arrays.sort(candidates);
	    	bfs(candidates, target, new ArrayList<>(), 0, 0);
	    	return res;
	    }
	    
	    List<List<Integer>> res = new ArrayList<>();
	    
	    public void bfs(int[] candidates, int target, List<Integer> al, int sum, int n) {
	    	
	    	if (sum == target) {
	    		res.add(new ArrayList<>(al));
	    		return;
	    	}
	    	if (sum > target) {
	    		return;
	    	}
	    	
	    	for (int i =n ; i < candidates.length; i++) {
	    		
	    		if (i!=n  && i<candidates.length && candidates[i]== candidates[i-1])
	    			continue;
	    		sum = sum+candidates[i];
	    		al.add(candidates[i]);
	    		bfs(candidates, target, al, sum, i+1);
	    		sum = sum- candidates[i];
	    		al.remove(al.size()-1);
	    	
	    	}
	    	
	    }
	}

}
