package com.sumit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagram {
	
	
	 public static void main(String[] args) {
	        String []  s = {"eat","tea","tan","ate","nat","bat"};
	        System.out.println(new Solution().groupAnagrams(s));
	    }
		
	
	static class Solution {
		
		private  String sortString(String str) {
	        char []arr = str.toCharArray();
	        Arrays.sort(arr);
	        return new String(arr);
	    }
	 
	
	   
		
	    public List<List<String>> groupAnagrams(String[] strs) {
	    	
	    	
	    	Map<String, List<String>> map = Arrays.stream(strs).collect(Collectors.groupingBy( x-> sortString(x)));
	    	return new ArrayList<>(map.values());
	        
	    }
	}

}
