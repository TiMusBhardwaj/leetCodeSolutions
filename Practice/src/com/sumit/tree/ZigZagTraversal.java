package com.sumit.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.sumit.tree.IsSubTree.TreeNode;

public class ZigZagTraversal {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(4);
		node.right = new TreeNode(5);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(2);
		node.right.right = new TreeNode(7);
		
		System.out.println(new Solution().zigzagLevelOrder(node));
	}
	
	static class Solution {
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    	
	    	if (root == null)
	    		return Collections.emptyList();
	    	
	    	Stack<TreeNode> stCur = new Stack<>();
	    	Stack<TreeNode> stBk = new Stack<>();
	    	stCur.push(root);
	    	List<List<Integer>> list = new ArrayList<>();
	    	while (!stCur.isEmpty()) {
	    		List<Integer> tList = new ArrayList<>();
	    		while(!stCur.isEmpty()) {
	    			TreeNode node = stCur.pop();
	    			tList.add(node.val);
	    			if (node.left !=null)stBk.push(node.left);
	    			if (node.right !=null)stBk.push(node.right);
	    		}
	    		list.add(tList);
	    		tList = new ArrayList<>();
	    		while(!stBk.isEmpty()) {
	    			
	    			TreeNode node = stBk.pop();
	    			tList.add(node.val);
	    			if (node.right !=null)stCur.push(node.right);
	    			if (node.left !=null)stCur.push(node.left);
	    		}
	    		if (!tList.isEmpty())list.add(tList);
	    	}
	        return list;
	    }
	    
	   
	}

}
