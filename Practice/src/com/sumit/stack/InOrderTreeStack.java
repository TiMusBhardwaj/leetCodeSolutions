package com.sumit.stack;

import java.util.Stack;

public class InOrderTreeStack {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		  // Let us construct a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.right.left = new Node(10);
        inOrder( root);
	}
	
	
	public static void inOrder(Node root) {
		Stack<Node> st = new Stack<>();
		
		Node current = root;
		while (!st.isEmpty() || current !=null) {
			
			while (current !=null) {
				st.push(current);
				current = current.left;
			}
			current = st.pop();
			System.out.println(current.data);
			
			current= current.right;
			
			
		}
		
	}
}