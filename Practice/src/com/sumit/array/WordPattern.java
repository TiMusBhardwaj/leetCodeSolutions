package com.sumit.array;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
	}

	static class Solution {
		public boolean wordPattern(String pattern, String s) {

			int pLen = pattern.length();
			String[] strs = s.split(" ");
			if (pLen != strs.length)
				return false;
			Map<Character, String> charStringMap = new HashMap<>();
			Map<String, Character> stringCharMap = new HashMap<>();
			for (int i = 0; i < pLen; i++) {
				if (charStringMap.containsKey(pattern.charAt(i)) ) {
					if (!charStringMap.get(pattern.charAt(i)).equals(strs[i])) {
						return false;
					}
				}else if (stringCharMap.containsKey(strs[i])) {
					if (!stringCharMap.get(strs[i]).equals((pattern.charAt(i)))) {
						return false;
					}
				}else {
					charStringMap.put(pattern.charAt(i), strs[i]);
					stringCharMap.put(strs[i], pattern.charAt(i));
				}

			}
			return true;

		}
	}

}
