package com.sumit.binarysearch;

public class SqrtUsingBinarySearch {
	
	
	public static void main(String[] args) {
		System.out.println(getSqrt(16));
	}
	
	
	public static int getSqrt(int x) {
		
		int start=0, end=x;
		
		while (end > start) {
			
			int mid = start + (end-start)/2;
			
			if (mid*mid > x) {
				end = mid;
			} else {
				start =mid+1;
			}
		}
		return start-1;
	}

}
