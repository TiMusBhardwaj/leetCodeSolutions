package com.sumit.stack;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Stack;

public class NextGreaterElement {

	public static int[] nextGreater(int[] input) {
		
		int [] ans = new int[input.length];
		Stack<Integer> st = new Stack<>();
		st.push(0);
		ans[0] = -1;
		for (int i=1; i< input.length ; i++) {
			ans[i] = -1;
			while(!st.isEmpty() && input[st.peek()] < input[i]) {
				ans[st.pop()]=input[i];
				
			}
			st.push(i);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		 int arr[] = { 11, 13, 21, 3 ,5};
		 System.out.println(Arrays.toString(nextGreater(arr)));
		 //LinkedHashMap<String, String> l = new LinkedHashMap<>();
		 
	}
}