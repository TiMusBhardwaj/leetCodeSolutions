package com.sumit.tree;

import java.util.Stack;

public class KthSmalleatElement {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(3);
		node.right = new TreeNode(6);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(4);
		node.right.right = new TreeNode(7);
		System.out.println(new Solution().kthSmallest(node, 3));
	}
	
	static class Solution {
	    public int kthSmallest(TreeNode root, int k) {
	    	
	    	
	    	return helper(root,k);
	        
	    }

		private int helper(TreeNode root, int k) {
			Stack<TreeNode> st = new Stack<>();
			int res = -1;
			TreeNode node = root;
			while(!st.isEmpty() || node!=null) {
			
				while (node != null) {
					st.add(node);
					node = node.left;
				}
				
				
				while (!st.isEmpty()) {
					node = st.pop();
					if (k--==1)
						 return node.val;
					node = node.right;
					if (node !=null)
						break;
				}
				
				
			}
			
			return res;
			
		}
	}

}
