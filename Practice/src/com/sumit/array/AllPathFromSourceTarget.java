package com.sumit.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPathFromSourceTarget {
	
	public static void main(String[] args) {
		
		int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
		
		System.out.println(new Solution().allPathsSourceTarget(graph));
	}
	
	static class Solution {
		
		
	    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	    	
	    	List<Integer> list = new ArrayList<>();
	    	
	    	list.add(0);
	    	dfs(graph, list);
	    	
	    	return res;
	    }
	    Set<Integer> visited = new HashSet<>();
	    List<List<Integer>> res = new ArrayList<>();
    	
	    public void  dfs(int[][] graph, List<Integer> list){
	    	
	    	int n = list.get(list.size()-1);
	    	if (n == graph.length-1) {
	    		res.add(new ArrayList<>(list));
	    		return;
	    	}
	    	visited.add(n);
	    	for (int i : graph[n]) {
	    		//if (visited.contains(i))
	    		//	continue;
	    		list.add(i);
	    		dfs(graph, list);
	    		list.remove(list.size()-1);
	    	}
	    	visited.remove(n);
	    	
	    }
	}

}
