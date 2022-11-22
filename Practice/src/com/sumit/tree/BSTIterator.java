package com.sumit.tree;

import java.util.Stack;

class BSTIterator {

	Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
    	
    	
    	TreeNode node = root; 
    	while (node != null) {
			st.add(node);
			node = node.left;
		}
    }
    
    public int next() {
    	if(!st.isEmpty()) {
    		TreeNode node = st.pop();
    		int val = node.val;
    		node = node.right;
    		while (node != null) {
    			st.add(node);
    			node = node.left;
    		}
    	return val;
    		
    	}else {
    		return -1;
    	}
    		
    		
        
    }
    
    public boolean hasNext() {
    	
    	return !st.isEmpty();
        
    }
}