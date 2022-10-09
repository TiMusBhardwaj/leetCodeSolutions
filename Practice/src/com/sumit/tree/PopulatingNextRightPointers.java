package com.sumit.tree;

public class PopulatingNextRightPointers {
	
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);	
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.right = new Node(5);
		
		new Solution().connect(root);
		System.out.println();
	}
	
	static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	

	static class Solution {
	    public Node connect(Node root) {
	    	
	    	Node rootT = root;
	    	while (rootT !=null) {
	    		rootT= recursive(rootT);
	    		while (rootT !=null && rootT.left == null && rootT.right == null) {
	    			rootT = rootT.next;
	    		}
	    		
	    	}
	    	
	        
	    	
	    	return root;
	    }
	    
	    public Node recursive(Node node) {
	    	
	    	if (node == null) {
	    		return null;
	    	}
	    	Node link = recursive(node.next);
	    			
	    	if (node.right !=null) {
	    		node.right.next = link;
	    		link = node.right;
	    	}
	    	if (node.left !=null) {
	    		node.left.next = link;
	    		link = node.left;
	    	}
	    	return link;
	    }
	}
	
	
	static class Solution2 {
	    public Node connect(Node root) {
	        Node dummyHead  = new Node(0); // this head will always point to the first element in the current layer we are searching
	        Node pre = dummyHead; // this 'pre' will be the "current node" that builds every single layer   
	        Node real_root = root; // just for return statement
	          
	        while(root != null){
	            if(root.left != null){
	                pre.next = root.left;
	                pre = pre.next;
	            }
	            if(root.right != null){
	                pre.next = root.right; 
	                pre = pre.next;
	            }
	            root = root.next; 
	            if(root == null){ // reach the end of current layer
	                pre = dummyHead; // shift pre back to the beginning, get ready to point to the first element in next layer  
	                root = dummyHead.next; ;//root comes down one level below to the first available non null node
	                dummyHead.next = null;//reset dummyhead back to default null
	            }
	        }
	          return real_root;
	      }
	  }

}
