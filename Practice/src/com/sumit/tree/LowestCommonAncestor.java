package com.sumit.tree;

public class LowestCommonAncestor {

	
	class Solution {
		
		
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        
	    	if (root == null) {
	    		return root;
	    	}
	    	
	    	if (root ==p || root==q)
	    		return root;
	    	
	    	
	    	
	    	TreeNode  nodeLeft = lowestCommonAncestor(root.left, p, q);
	    	TreeNode  nodeRight = lowestCommonAncestor(root.right, p, q);
	    	
	    	if (nodeLeft !=null && nodeRight !=null) {
	    		return root;
	    	}
	    	return nodeLeft ==null ? nodeRight : nodeLeft;
	    }
	}
}
