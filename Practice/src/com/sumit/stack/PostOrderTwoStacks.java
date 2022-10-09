package com.sumit.stack;

import java.util.Stack;

//LEFT RIGHT ROOT

public class PostOrderTwoStacks {
	
	static class node {
        int data;
        node left, right;
 
        public node(int data)
        {
            this.data = data;
        }
    }
	
	static Stack<node> stack1 = new Stack<>();
	static Stack<node> stack2 = new Stack<>();
	
	public static void postOrderIterative(node root) {
		
		stack1.push(root);
		
		while (!stack1.isEmpty()) {
			node n = stack1.pop();
			if(n.left != null)
				stack1.push(n.left);
			if(n.right != null)
				stack1.push(n.right);
			stack2.push(n);
		}
		
		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop().data);
		}
		
	}
	
	public static void main(String[] args)
    {
        // Let us construct the tree
        // shown in above figure
 
        node root = null;
        root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);
 
        postOrderIterative(root);
    }
	
	
}
