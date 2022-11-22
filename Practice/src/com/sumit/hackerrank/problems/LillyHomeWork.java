package com.sumit.hackerrank.problems;

import java.util.Arrays;
import java.util.List;

public class LillyHomeWork {

	public static void main(String[] args) {

		int a  = Result.lilysHomework(Arrays.asList(2, 1, 4, 3, 5));
		System.out.println(a);
	}

	static class Result {

		/*
		 * Complete the 'lilysHomework' function below.
		 *
		 * The function is expected to return an INTEGER. The function accepts
		 * INTEGER_ARRAY arr as parameter.
		 */

		public static int lilysHomework(List<Integer> arr) {

			int count = 0;
			int count2 = 0;
			for (int i = 0; i < arr.size(); i++) {
				int min = i;
				for (int j = i + 1; j < arr.size(); j++) {
					if (arr.get(min) > arr.get(j)) {
						min = j;
					}
				}
				if (min != i) {
					count++;
					int temp = arr.get(min);
					arr.set(min, arr.get(i));
					arr.set(i, temp);
				}

			}
			
			for (int i = 0; i < arr.size(); i++) {
				int max = i;
				for (int j = i + 1; j < arr.size(); j++) {
					if (arr.get(max) < arr.get(j)) {
						max = j;
					}
				}
				if (max != i) {
					count2++;
					int temp = arr.get(max);
					arr.set(max, arr.get(i));
					arr.set(i, temp);
				}

			}

			return Math.min(count, count2);

		}

	}

}
