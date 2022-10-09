package com.sumit.graph.greedyMethods;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShortestPathUsingDjisktra {

	public static void main(String[] args) {

		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		ShortestPathUsingDjisktra t = new ShortestPathUsingDjisktra();
		Map<Integer, Pair> map = t.dijkstra(graph, 0);

		System.out.println(map);

	}

	private Map<Integer, Pair> dijkstra(int[][] graph, int i) {

		Queue<Pair> pQ = createPriorityQueue(graph);
		Map<Integer, Pair> nodeToPairMap = pQ.stream()
				.collect(Collectors.toMap(pair -> pair.node, Function.identity()));
		
		while (!pQ.isEmpty()) {
			Pair cuPair = pQ.poll();
			cuPair.visited = true;
			IntStream.range(0, 9).boxed().filter(x -> filter(graph, cuPair, x,nodeToPairMap)).forEach(x -> modifyAdjCost(graph, nodeToPairMap, cuPair, x));
		}
		return nodeToPairMap;
	}

	private boolean filter(int[][] graph, Pair cuPair, Integer x, Map<Integer, Pair> nodeToPairMap) {
		return !(graph[cuPair.node][x] == 0) && !nodeToPairMap.get(x).visited;
	}

	private void modifyAdjCost(int[][] graph, Map<Integer, Pair> nodeToPairMap, Pair cuPair, Integer x) {
		Pair p = nodeToPairMap.get(x);
		p.distance = Math.min(cuPair.distance + graph[cuPair.node][x], p.distance) ;
		//p.visited = true;
		return;
	}

	private Queue<Pair> createPriorityQueue(int[][] graph) {
		Queue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return Integer.compare(o1.distance, o2.distance);
			}
		});
		q.add(new Pair(0, graph[0][0]));
		for (int currNode = 1; currNode < graph.length; currNode++) {
			q.add(new Pair(currNode, graph[0][currNode] == 0 ? Integer.MAX_VALUE: graph[0][currNode]));
		}
		return q;
	}

	static class Pair {
		int node;
		int distance;
		boolean visited;

		public Pair(int node, int distance) {
			super();
			this.node = node;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Pair [node=" + node + ", distance=" + distance + "]";
		}
		
	}

}
