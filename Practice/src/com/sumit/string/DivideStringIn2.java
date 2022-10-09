package com.sumit.string;

public class DivideStringIn2 {
	
	public static void main(String[] args) {
		String s1 = "asd1erf";
		final int mid = s1.length() / 2; //get the middle of the String
		String[] parts = {s1.length()%2==0? s1.substring(0, mid) :s1.substring(0, mid+1) ,s1.substring(mid)};
		System.out.println(parts[0]); //first part
		System.out.println(parts[1]); //second part
	}

}
