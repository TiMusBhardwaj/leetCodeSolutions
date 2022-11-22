package com.sumit.stack;

import java.util.LinkedList;
import java.util.Queue;

public class WinnerOfCircularGame {
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().findTheWinner(5, 2));
	}
	
	static class Solution {
	    public int findTheWinner(int n, int k) {
	        
	        
	        Queue<Integer> q = new LinkedList<>();
	        int i =0;
	        while (i++ <n) {
	        	q.add(i);
	        }
	        int count = k;
	        while (q.size() >1) {
	        	
	        	if (count ==1) {
	        		
	        		System.out.println( q.poll());
	        		count = k;
	        		continue;
	        	}else 
	        		q.add(q.poll());
	        	count--;
	        	
	        }
	        
	      
	        return q.poll();
	    }
	}

}
