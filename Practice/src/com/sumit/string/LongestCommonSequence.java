package com.sumit.string;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSequence {
	
	 char[] arr1;
	 char[] arr2;
	 List<Character> ans = new ArrayList<>();
	
	public LongestCommonSequence(char[] arr1, char[] arr2) {
		super();
		this.arr1 = arr1;
		this.arr2 = arr2;
	}

	public static void main(String[] args) {
		String s = new LongestCommonSequence("bd".toCharArray(), "abcd".toCharArray()).lcs(0, 0);
		System.out.println(s);;
	}
	
	String lcs(int i , int j) {
		if (i == arr1.length || j == arr2.length) {
			return "";
		} else if (arr1[i] == arr2[j]) {
			return arr1[i]+lcs(i+1,j+1);
		} else {
			return lcs(i+1,j).length() > lcs(i,j+1).length()?lcs(i+1,j):lcs(i,j+1);
		}
		
		
	}

}
