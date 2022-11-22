package com.sumit.tree;

import java.util.HashMap;
import java.util.Map;

public class CreateTreeFromInorderAndPreOrder {
	
	public static void main(String[] args) {
		
		int [] preorder = {3,9,20,15,7};
		int [] inorder = {9,3,15,20,7};
		
		TreeNode node = new Solution2().buildTree(preorder, inorder);
		System.out.println(node);
	}

	static class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			
			inOrderMap = new HashMap<>();
			for (int i=0; i< inorder.length;i++) {
				inOrderMap.put(inorder[i], i);
			}
			
			return helper(inorder, 0, inorder.length-1, preorder, 0);
		}
		
		Map<Integer, Integer> inOrderMap;
		
		private TreeNode helper(int[] inorder, int start, int end , int[] preOrder, int index) {
			
			if (index >= preOrder.length || start > end) {
				return null;
			}
			
			
			
			int indexInOrder = inOrderMap.get(preOrder[index]);
			if (indexInOrder <start || indexInOrder >end){
				return null;
			}
			
			TreeNode node = new TreeNode(preOrder[index]);
			node.left = helper(inorder, start, indexInOrder-1, preOrder, index+1);
			if (node.left == null) {
				node.right = helper(inorder, indexInOrder+1, end, preOrder, index+1);
			}else {
				node.right = helper(inorder, indexInOrder+1, end, preOrder, indexInOrder-1-start+2+index);
			}
			return node;
		}
	}
	
	static class Solution2 { // TC: O(n), SC: O(height)
		   int i, p; // i as index for inorder, p as index for preorder
		   public TreeNode buildTree(int[] pre, int[] in) {
		      i = p = 0;
		      return dfs(pre, in, 3001);
		   }

		   private TreeNode dfs(int[] pre, int[] in, int rightBoundary) {
		      if (p == pre.length || in[i] == rightBoundary) return null;

		      TreeNode node = new TreeNode(pre[p++]);
		      node.left  = dfs(pre, in, node.val);
		      i++;
		      node.right = dfs(pre, in, rightBoundary);
		      return node;
		   }
		}

}
