package com.sumit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet2 {

	public static void main(String[] args) {

		int[] nums = { 1, 2,2,3};

		List<List<Integer>> l = new Solution().subsetsWithDup(nums);

		System.out.println(l);
	}

	static class Solution {
		public List<List<Integer>> subsetsWithDup(int[] nums) {
			Arrays.sort(nums);
			List<List<Integer>> ans = new ArrayList<>();
			subset(ans, new ArrayList<Integer>(), nums, 0);
			return ans;
		}

		void subset(List<List<Integer>> ans, List<Integer> al, int[] nums, int ind) {
			ans.add(new ArrayList<>(al));
			for (int i = ind; i < nums.length; i++) {

				// checks if pervious element is same or not for generating same length of
				// subset
				if (i != ind && nums[i] == nums[i - 1])
					continue;

				al.add(nums[i]);
				subset(ans, al, nums, i + 1);
				al.remove(al.size() - 1);

			}
		}

		
	}

}
