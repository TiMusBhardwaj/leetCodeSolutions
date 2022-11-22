package com.sumit.stack;

import java.util.Stack;

public class MinStack {
	
	
	int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) 
        	min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    
    
    public static void main(String[] args) {
		
    	MinStack st = new MinStack();
		st.push(10);
		st.push(5);
		st.push(20);
		st.push(31);
		st.push(2);
		st.push(-20);
		System.out.println(st.stack);
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		
		
	}

}
