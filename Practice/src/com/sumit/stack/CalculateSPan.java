package com.sumit.stack;

import java.util.Arrays;
import java.util.Stack;

public class CalculateSPan {

public static int[] calculateSpan(int [] input){
		
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[input.length];
		st.push(0);
		ans[0] = 1;
		for (int i =1 ; i< input.length ; i++ ) {
			while (!st.isEmpty() && input[st.peek()] <= input[i])
				st.pop();
			if(st.isEmpty())
				ans[i]= i+1;
			else 
				ans[i] = i-st.peek();
			
			st.push(i);
		}
		return ans;
	}

	
	public static void main(String[] args)
    {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int S[] = new int[n];
  
        // Fill the span values in array S[]
        System.out.println(Arrays.toString(calculateSpan(price)));
  
    }
}
