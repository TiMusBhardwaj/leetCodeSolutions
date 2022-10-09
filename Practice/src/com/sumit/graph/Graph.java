package com.sumit.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Graph <T>{
	 Map<Vertex<T>, List<Vertex<T>>> adjVertices = new HashMap<>();

	static class Vertex<T> {
		T label;

		Vertex(T label) {
			this.label = label;
		}

		@Override
		public int hashCode() {

			return label.hashCode();
		}

		@Override
		public boolean equals(Object obj) {

			return label.equals(((Vertex<?>) obj).label);
		}
		
		@Override
		public String toString() {
			
			return label.toString();
		}
	}
	
	 void getVertex(T label) {
	    adjVertices.putIfAbsent(new Vertex<T>(label), new ArrayList<>());
	}
	
	 void addVertex(T label) {
	    adjVertices.putIfAbsent(new Vertex<T>(label), new ArrayList<>());
	}

	 void removeVertex(T label) {
	    Vertex<T> v = new Vertex<T>(label);
	    adjVertices.values().stream().forEach(e -> e.remove(v));
	    adjVertices.remove(new Vertex<T>(label));
	}
	
	  void addEdge(T label1, T label2) {
	    Vertex<T> v1 = new Vertex<T>(label1);
	    Vertex<T> v2 = new Vertex<>(label2);
	    adjVertices.get(v1).add(v2);
	    adjVertices.get(v2).add(v1);
	}
	
	 void removeEdge(T label1, T label2) {
	    Vertex<T> v1 = new Vertex<T>(label1);
	    Vertex<T> v2 = new Vertex<T>(label2);
	    List<Vertex<T>> eV1 = adjVertices.get(v1);
	    List<Vertex<T>> eV2 = adjVertices.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	}
}