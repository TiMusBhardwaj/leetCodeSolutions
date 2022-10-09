package com.sumit.bitwise;

public class Add2Numbers {
	
	public static void main(String[] args) {
		System.out.print(new Solution().getSum(5, 9));
	}
	static class Solution {
	    public int getSum(int a, int b) {
	        if (b==0) {
	        	return a;
	        }
	        return getSum(a^b, (a&b)<<1);
	    }
	}
	

}
