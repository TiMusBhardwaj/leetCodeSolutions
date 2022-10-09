package com.sumit.stack;

import java.util.Stack;

import com.sumit.stack.InOrderTreeStack.Node;

public class PostOrderOneStack {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	static Stack<Node> stack1 = new Stack<>();

	
	
	public static void postOrder(Node root) {
		Stack<Node> st = new Stack<>();
		
		Node current = root;
		//st.push(current);
		do {
			while (current != null) {
				if (current.right != null)
					st.push(current.right);
				st.push(current);
				current  = current.left;
				
			}
			current = st.pop();
			if (!st.isEmpty() && st.peek() == current.right) {
				
				st.pop();
				st.push(current);
				current = current.right;
				continue;
			}else {
				System.out.println(current.data);
				current = null;
			}
		}while (!st.isEmpty());
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
    //  root.left.left.left = new Node(8);
     // root.left.right.right = new Node(9);
     // root.right.right.left = new Node(10);
      postOrder( root);
      System.out.println("-----");
      //postOrderIterative(root);
	}
	
}
