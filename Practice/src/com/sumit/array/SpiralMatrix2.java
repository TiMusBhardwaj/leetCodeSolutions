package com.sumit.array;

import java.util.Arrays;

public class SpiralMatrix2 {

	public static void main(String[] args) {

		int[][] matrix = new Solution().generateMatrix(10);
		for (int[] arr : matrix) {
			System.out.println(Arrays.toString(arr));
		}
	}

	static class Solution {

		int fillN = 0;

		public int[][] generateMatrix(int n) {
			

			int[][] matrix = new int[n][n];
			
			int end = n-1;

			
			
			int loop = 0;
			while (fillN < n*n) {
				
				if (loop == end-loop) {
					matrix[loop][loop] = ++fillN;
					break;
				}
				
				fill1(loop, loop, loop, end-1-loop,     0, 1, matrix);
				fill1(loop, end-loop, end-1-loop, end-loop,     1, 0, matrix);
				fill2(end-loop, end-loop, end-loop, loop+1,      0, 1, matrix);
				fill2(end-loop, 0+loop, 1+loop,0+loop,         1, 0, matrix);
				loop++;
			}


			return matrix;

		}

		private void fill1(int i, int j, int maxI, int maxJ, int incI, int incJ, int[][] matrix) {
			
			while (i <= maxI && j <= maxJ) {

				matrix[i][j] = ++fillN;
				i = i + incI;
				j = j + incJ;
			}

		}
		private void fill2(int i, int j, int minI, int minJ, int incI, int incJ, int[][] matrix) {

			while (i >= minI && j >= minJ) {

				matrix[i][j] = ++fillN;
				i = i - incI;
				j = j - incJ;
			}

		}
	}

}
