package com.sumit.tree;

public class DeleteNodeInBST {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(3);
		node.right = new TreeNode(6);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(4);
		node.right.right = new TreeNode(7);
		new Solution().deleteNode(node, 3);
	}
	
	static class Solution {
	    public TreeNode deleteNode(TreeNode root, int key) {
	    	
	    	if(root == null) {
	    		return null;
	    	}
	    	if (root.val == key) {
	    		
	    		if (root.left == null)
	    			return root.right;
	    		if (root.right == null)
	    			return root.left;
	    		
	    		root.val = nextVal(root.right);
	    		
	    		root.right = deleteNode(root.right, root.val);
	    		
	    	} else if (root.val < key) {
	    		root.right = deleteNode(root.right, key);
	    	} else {
	    		root.left = deleteNode(root.left, key);
	    	}
	        return root;
	    }

		private int nextVal(TreeNode right) {
			
			while (right.left !=null) {
				right = right.left;
				
			}
			return right.val;
		}
	}

}
