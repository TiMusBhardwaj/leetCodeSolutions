package com.sumit.string;

public class DeleteOperationForTwoStrings {

	public static void main(String[] args) {
		int res = new Solution().minDistance("dinitrophenylhydrazine"
				,"acetylphenylhydrazine");
		System.out.println(res);
		res = new Solution().lcs("bbbab"
				,new StringBuffer("bbbab").reverse().toString());
		System.out.println(res);
	}
}

class Solution {
	String arr1;
	String arr2;
	int [][] mem;
	String [][] mem2;
	
	public int minDistance(String word1, String word2) {
		arr1 = word1;
		arr2 = word2;
		mem = new int[word1.length()][word2.length()];
		
		for (int i = 0;
	             i < word1.length() * word2.length(); i++) {
	 
	            // Find row and column index
	            int row = i / word2.length();
	            int col = i % word2.length();
	 
	            mem[row][col]=-1;
	        }
		//System.out.println();
		int res = lcs(0, 0);
		//int res = lcs(0, 0);
		//mem2 = new String[word1.length()][word2.length()];
		return word1.length() + word2.length() - (2 * res);
	}

	public int lcs(String word1, String word2) {
		arr1 = word1;
		arr2 = word2;
		mem = new int[word1.length()][word2.length()];
		
		for (int i = 0;
	             i < word1.length() * word2.length(); i++) {
	 
	            // Find row and column index
	            int row = i / word2.length();
	            int col = i % word2.length();
	 
	            mem[row][col]=-1;
	        }
		//System.out.println();
		int res = lcs(0, 0);
		//int res = lcs(0, 0);
		//mem2 = new String[word1.length()][word2.length()];
		return res;
	}

	
	int lcs(int i, int j) {
		
		if (i < arr1.length() && j< arr2.length() && mem[i][j] !=-1) {
			return mem[i][j];
		}
		
		if (i == arr1.length() || j == arr2.length()) {
			return 0;
		} else if (arr1.charAt(i) == arr2.charAt(j)) {
			
			int resT = 1+lcs(i+1,j+1);
			
			mem[i][j] = resT;
			return resT;
		} else {
			int resT = Math.max(lcs(i+1,j),lcs(i,j+1));
			mem[i][j] = resT;
			return resT;
		}

	}
	String lcsString(int i , int j) {
		if (i < arr1.length() && j< arr2.length() && mem2[i][j] !=null) {
			return mem2[i][j];
		}
		
		if (i == arr1.length() || j == arr2.length()) {
			return "";
		} else if (arr1.charAt(i) == arr2.charAt(j)) {
			
			String resT = arr1.charAt(i)+lcsString(i+1,j+1);
			System.out.println(i +"-"+j+"---"+resT);
			mem2[i][j] = resT;
			return resT;
		} else {
			String resT = lcsString(i+1,j).length() > lcsString(i,j+1).length()?lcsString(i+1,j):lcsString(i,j+1);
			System.out.println(i +"-"+j+"---"+resT);
			mem2[i][j] = resT;
			return resT;
		}
		
		
	}
}