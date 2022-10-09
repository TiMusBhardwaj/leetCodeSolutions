package com.sumit.tree;

public class IsSubTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(4);
		node.right = new TreeNode(5);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(2);
		
		TreeNode node2 = new TreeNode(4);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(2);
		
		new Solution().isSubtree(node, node2);
		
	}
	
	static class TreeNode {
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
	
	static class Solution {
	    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
	    	
	    	if (root == null) {
	    		return false;
	    	}
	    	return isEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	        
	    }
	    public boolean isEqual(TreeNode root, TreeNode subRoot) {
			if (root != null && subRoot != null)
				
				return root.val == subRoot.val 
	    			&& isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
			else if (root == null && subRoot == null)
				return true;
			else 
                return false;
		}

	}

	
}
