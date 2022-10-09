package com.sumit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation_2 {
	
	
	public static void main(String[] args) {
		int[] nums = { 3,0,3,3};

		List<List<Integer>> l = new Solution().permuteUnique(nums);

		System.out.println(l);
	}
	
	static class Solution {
	    public List<List<Integer>> permuteUnique(int[] nums) {
	    	Arrays.sort(nums);
	    	bfs(nums, new ArrayList<>(), new ArrayList<>(),-1);
	    	return res;
	    }
	    
	    List<List<Integer>> res = new ArrayList<>();
	    public void bfs(int[] nums, List<Integer>al, List<Integer> used, int prevCounter) {
	    	if (al.size() == nums.length) {
	    		res.add(new ArrayList<>(al));
	    		return;
	    	}
	    	
	    	for (int i =0; i < nums.length; i++) {
	    		if ( used.contains(i) || (i>0 && i<nums.length && !used.contains(i-1) && nums[i]==nums[i-1])) {
	    			continue;
	    		}
	    		al.add(nums[i]);
	    		used.add(i);
	    		bfs(nums, al, used, i);
	    		al.remove(al.size()-1);
	    		used.remove(used.size()-1);
	    	}
	    }
	}
}
