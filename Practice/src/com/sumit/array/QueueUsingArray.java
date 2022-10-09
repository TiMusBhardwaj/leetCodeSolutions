package com.sumit.array;

import java.util.Arrays;

public class QueueUsingArray {
	int limit = 10;
	Integer[] array = new Integer[limit];
	int count = 0;
	int head = 0;
	int tail = 0;
	
	public void enQueue(int i) {
		if (count >= limit) {
			throw new RuntimeException("QUEUE IS FULL");
		}
		
		array[head] = i;
		if (head == limit-1) {
			head = 0;
		}else {
			head++;
		}
		count++;
		System.out.println(Arrays.toString(array));
	}
	
	public int deQueue() {
		if (count==0) {
			System.out.println("QUEUE IS EMPTY");
			throw new RuntimeException("QUEUE IS Empty");
		}
		int out = array[tail];
		array[tail] = null;
		if (tail == limit-1) {
			tail = 0;
		}else {
			tail++;
		}
		count--; 
		System.out.println(Arrays.toString(array));
		return out;
	}
	
	public static void main(String[] args) {
		QueueUsingArray q = new QueueUsingArray();
		q.enQueue(5);
		q.enQueue(2);q.enQueue(3);
		q.enQueue(4);q.enQueue(6);q.enQueue(8);q.enQueue(9);q.enQueue(4);q.enQueue(11);q.enQueue(13);
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.enQueue(2);q.enQueue(3);
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		
	}
}
