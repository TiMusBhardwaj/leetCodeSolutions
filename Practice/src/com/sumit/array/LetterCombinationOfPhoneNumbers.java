package com.sumit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumbers {
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().letterCombinations("2322"));
	}
	static class Solution {
		
		
		Map<Character, char[]> map = new HashMap<>();
		{	char [] a = new char [] {'a','b','c'};
			map.put('2', a);
			a =  new char [] {'d','e','f'};
			map.put('3', a);
			a = new char  [] {'g','h','i'};
			map.put('4', a);
			a = new char  [] {'j','k','l'};
			map.put('5', a);
			a = new char  [] {'m','n','o'};
			map.put('6', a);
			a = new char  [] {'p','q','r','s'};
			map.put('7', a);
			a = new char  [] {'t','u','v'};
			map.put('8', a);
			a = new char  [] {'w','x','y','z'};
			map.put('9', a);
			
		}
		
		List<String> res = new ArrayList<>();
		
	    public List<String> letterCombinations(String digits) {
	    	if (digits.length()==0) {
	    		return new ArrayList<>();
	    	}
	        
	    	char [] chars = digits.toCharArray();
	    	bfs(chars, new char[chars.length], 0);
	    	
	    	return res;
	    }
	    
	    private void bfs(char [] numChars, char [] charRes, int level) {
	    	if (level == numChars.length) {
	    		
	    		res.add(new String(charRes));
	    		return;
	    	}
	    	
	    	char num = numChars[level];
	    	char[] charArray = map.get(num);
	    	for (char c : charArray) {
	    		charRes[level] = c;
	    		bfs(numChars, charRes, level+1);
	    		
	    		
	    	}
	    	
	    	
	    }
	    
	}

}
