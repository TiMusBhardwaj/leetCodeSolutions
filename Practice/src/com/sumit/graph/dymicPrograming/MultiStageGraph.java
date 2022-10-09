package com.sumit.graph.dymicPrograming;

import java.util.Arrays;

public class MultiStageGraph {
	
	
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
			{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
			MultiStageGraph t = new MultiStageGraph();
			System.out.println(Arrays.toString(t.findPath(graph)));
	}

	private int[] findPath(int[][] graph) {
		
		int[] cost = new int[graph.length];
		int[] path = new int[graph.length];
		cost[graph.length-1]=0;
		for (int i = graph.length-1;i>=1;i--) {
			int min = Integer.MAX_VALUE;
			
			for (int k = i+1; k<graph.length;k++) {
				if (graph[i][k] !=0 && cost[i]+graph[i][k]<min) {
					min= graph[i][k];
					path[i]=k;
				}
			}
			cost[i]=min;
		}
		return path;
	}
	



}
