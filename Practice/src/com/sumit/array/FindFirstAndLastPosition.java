package com.sumit.array;

import java.util.Arrays;

public class FindFirstAndLastPosition {

	public static void main(String[] args) {
		int []nums = {2,2};
		int [] rs = new Solution().searchRange(nums, 2);
		System.out.println(Arrays.toString(rs));
	}
	
	
	static class Solution {
	    public int[] searchRange(int[] nums, int target) {
	    	
	    	int [] res = {getFirst(nums, target), getLast(nums, target)};
			return res;
	        
	    }

		private int getFirst(int[] nums, int target) {
			
			int start = 0;
			int end = nums.length-1;
			while (start <=end) {
				int mid = (start+end)/2;
				if (nums[mid] == target) {
					if (mid == 0 || nums[mid-1] != target) {
						return mid;
					} else {
						end = mid-1;
					}
				}else if (nums[mid] > target) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
			
			return -1;
		}

		private int getLast(int[] nums, int target) {

			
			int start = 0;
			int end = nums.length-1;
			while (start <=end) {
				int mid = (start+end)/2;
				if (nums[mid] == target) {
					if (mid == nums.length-1 || nums[mid+1] != target) {
						return mid;
					} else {
						start = mid+1;
					}
				}else if (nums[mid] > target) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
			
			return -1;
		
		}
	}
}
