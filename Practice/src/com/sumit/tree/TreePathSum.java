package com.sumit.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePathSum {
	
	static class Solution {
	    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	    	if(root == null) {
	    		return Collections.emptyList();
	    	}
	    	
	        helper(root, targetSum, new ArrayList<>());
	        return res;
	    }
	    List<List<Integer>> res = new ArrayList<>();
	    //int targetSum;
	    private void helper(TreeNode root, int targetSum, List<Integer> list) {
	    	
	    	list.add(root.val);
	    	if (root.left == null && root.right==null && root.val == targetSum) {
	    		List<Integer> tList = new ArrayList<Integer>(list);
	    		res.add(tList);
	    	}
	    	if (root.left!=null)helper(root.left, targetSum-root.val, list);
	    	if (root.right!=null)helper(root.right, targetSum-root.val, list);
	    	
	    	list.remove(list.size()-1);
	    }
	}

}
