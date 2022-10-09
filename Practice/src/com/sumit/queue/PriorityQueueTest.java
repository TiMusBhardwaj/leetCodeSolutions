package com.sumit.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		
		Pair p1 = new Pair(0, 0);
		Pair p2 = new Pair(0, 1);
		Pair p3 = new Pair(0, 4);
		Pair p4 = new Pair(0, 5);
		Pair p5 = new Pair(0, 6);
		Pair p6 = new Pair(0, -1);
		
		Queue<Pair> q = new PriorityQueue<>( new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				
				return Integer.compare(o1.b, o2.b);
			}
		});
		q.add(p5);
		q.add(p6);
		q.add(p1);
		q.add(p2);
		q.add(p4);
		q.add(p3);
		p3.b=14;
		System.out.println(q);
		while(!q.isEmpty()) {
			System.out.println(q.poll()); 
		}
	}
	
	static class Pair{
		int a;
		int b;
		public Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return this.a+","+this.b;
		}
	}

	
	
}

