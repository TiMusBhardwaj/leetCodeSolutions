package com.sumit.stack;

public class MinDistanceBSTNode {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(14);
        root.left.right = new TreeNode(15);
		new Solution().minDiffInBST(root);
	}
}

/**
 *Definition for a binary tree node.
 **/ 
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
	 private Integer previous = null;
	    private int minDiff = Integer.MAX_VALUE;
	    
	    public int minDiffInBST(TreeNode root) {
	        inorder(root);
	        return minDiff;
	    }
	    
	    private void inorder(TreeNode root) {
	        if (root == null) {
	            return;
	        }
	        inorder(root.left);
	        if (previous == null) {
	            previous = root.val;
	        } else {
	            minDiff = Math.min(minDiff, Math.abs(root.val - previous));
	            previous = root.val;
	        }
	        inorder(root.right);
	    }
}