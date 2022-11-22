package com.sumit.tree;

public class SortedArrayToBST {
	
	public static void main(String[] args) {
		
		int [] nums = {-10,-3,0,5,9};
		new Solution().sortedArrayToBST(nums);
		
	}

	
	static class Solution {
	    public TreeNode sortedArrayToBST(int[] nums) {
	    	
	    	return helper(nums, 0, nums.length-1);
	        
	    }

		private TreeNode helper(int[] nums, int start, int end) {
			if (start > end) {
				return null;
			}
			int mid = (start+end)/2;
			TreeNode node = new TreeNode(mid);
			node.left = helper(nums, start, mid-1);
			node.right = helper(nums, mid+1, end);
			
			
			return node;
		}
	}
}

