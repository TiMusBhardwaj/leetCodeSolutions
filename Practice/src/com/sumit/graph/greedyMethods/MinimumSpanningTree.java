package com.sumit.graph.greedyMethods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public class MinimumSpanningTree {

	public static void main(String[] args) {
		/*
		 * Let us create the following graph 2 3 (0)--(1)--(2) | / \ | 6| 8/ \5 |7 | / \
		 * | (3)-------(4) 9
		 */
		MinimumSpanningTree t = new MinimumSpanningTree();
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };

		// Print the solution
		System.out.println(t.primMST(graph));
		System.out.println(t.kruskalMST(graph));
	}

	private Map<Integer, Node> primMST(int[][] graph) {

		Node node = new Node(0, -1, 0, false);
		Map<Integer, Node> mp = new HashMap<>();
		Queue<Node> q = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {

				return Integer.compare(o1.weight, o2.weight);
			}
		});
		q.add(node);
		int count = 0;
		while (!q.isEmpty() && count < graph.length) {
			Node currNode = q.poll();
			mp.put(currNode.id, currNode);
			IntStream.range(0, graph.length).boxed().filter(x -> !(graph[currNode.id][x] == 0) && !(mp.containsKey(x)))
					.forEach(x -> q.add(new Node(x, currNode.id, graph[currNode.id][x], false)));
			count++;
		}

		return mp;
	}
	
	class Node {
		int id;
		int parent;
		int weight;

		public Node(int id, int parent, int weight, boolean visited) {
			super();
			this.id = id;
			this.parent = parent;
			this.weight = weight;

		}

		@Override
		public String toString() {
			return "Node [id=" + id + ", parent=" + parent + ", weight=" + weight + "]";
		}

	}

	private List<Edge> kruskalMST(int[][] graph) {

		
		Queue<Edge> q = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {

				return Integer.compare(o1.weight, o2.weight);
			}
		});
		Set<Integer> vertexUsed = new HashSet<>();
		List<Edge> res = new ArrayList<>();
		
		IntStream.range(0, graph.length * graph.length).forEach(n -> {
            int i = n / graph.length;
            int j = n % graph.length;
            if (graph[i][j] != 0)
            	q.add(new Edge(graph[i][j], i, j));
            
        });
		int count = 0;
		while (!q.isEmpty() && count < graph.length-1) {
			Edge currEdge = q.poll();
			if (vertexUsed.contains(currEdge.child) && vertexUsed.contains(currEdge.child)){
				continue;
			}
			vertexUsed.add(currEdge.child);
			vertexUsed.add(currEdge.parent);
			res.add(currEdge);
			count++;
		}

		return res;
	}

	class Edge{
		
		int weight;
		int parent =-1, child=-1;
		
		public Edge(int weight, int parent, int child) {
			super();
			this.weight = weight;
			this.parent = parent;
			this.child = child;
		}

		@Override
		public String toString() {
			return "Edge [weight=" + weight + ", parent=" + parent + ", child=" + child + "]";
		}
	}
}
