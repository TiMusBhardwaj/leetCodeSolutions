package com.sumit.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sumit.tree.IsSubTree.TreeNode;

public class RightViewOfTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(4);
		node.right = new TreeNode(5);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(2);
		node.right.left = new TreeNode(7);
		
		System.out.println(new Solution().rightSideView(node));
		
	}
	
	static class Solution {
	    public List<Integer> rightSideView(TreeNode root) {
	    	if (root == null)
	    		return Collections.emptyList(); 
	    	
	    	List<Integer> list = new ArrayList<>();
	    	
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.add(root);
	        while (!q.isEmpty()) {
	        	
	        	int size = q.size();
	        	list.add(q.peek().val);
	        	while (size-->0) {
	        		TreeNode node = q.poll();
	        		if(node.right != null) q.add(node.right);
	        		if(node.left != null) q.add(node.left);
	        	}
	        	
	        }
	    	
	        return list;
	    }
	    
	    
	}

}
