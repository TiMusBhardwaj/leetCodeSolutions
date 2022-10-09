package com.sumit.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sumit.graph.Graph.Vertex;

public class GraphTraversal
{
	
	
	static Graph<String> createGraph() {
	    Graph <String>graph = new Graph<String>();
	    graph.addVertex("Bob");
	    graph.addVertex("Alice");
	    graph.addVertex("Mark");
	    graph.addVertex("Rob");
	    graph.addVertex("Maria");
	    graph.addEdge("Bob", "Alice");
	    graph.addEdge("Bob", "Rob");
	    graph.addEdge("Alice", "Mark");
	    graph.addEdge("Rob", "Mark");
	    graph.addEdge("Alice", "Maria");
	    graph.addEdge("Rob", "Maria");
	    //graph.removeVertex("Rob");
	     
	    //depthFirstTraversal(graph);
	    return graph;
	}
	
	public static void main(String[] args) {
		Graph<String> graph = createGraph();
		depthFirstTraversal(graph);
		breathFirstTraversal(graph);
	}
	
	static  void depthFirstTraversal(Graph<String> graph) {
		
		Set<Vertex<String>> visited = new HashSet<>();
		Stack<Vertex<String>> stack = new Stack<>();
		stack.push(graph.adjVertices.keySet().iterator().next());
		while (!stack.isEmpty()) {
			Vertex<String> curr = stack.pop();
			if(visited.contains(curr))
				continue;
			System.out.println(curr);
			visited.add(curr);
			List<Vertex<String>> list = graph.adjVertices.get(curr);
			list.stream().forEach(v -> stack.push(v));
			
		}
		
	}
	
	static  void breathFirstTraversal(Graph<String> graph) {
		
		Set<Vertex<String>> visited = new HashSet<>();
		Queue<Vertex<String>> queue = new LinkedBlockingQueue<>();
		queue.add(graph.adjVertices.keySet().iterator().next());
		while (!queue.isEmpty()) {
			Vertex<String> curr = queue.poll();
			if(visited.contains(curr))
				continue;
			System.out.println(curr);
			visited.add(curr);
			List<Vertex<String>> list = graph.adjVertices.get(curr);
			list.stream().forEach(v -> queue.add(v));
			
		}
		
	}

}

