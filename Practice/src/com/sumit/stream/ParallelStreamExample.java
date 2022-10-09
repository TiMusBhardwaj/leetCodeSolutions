// Java code to demonstrate
// ParallelStreams
package com.sumit.stream;
import java.util.Arrays;
import java.util.List;

class ParallelStreamExample {
	public static void main(String[] args)
	{
		// create a list
		List<String> list = Arrays.asList("Hello ",
						"G", "E", "E", "K", "S!");

		// using parallelStream()
		// method for parallel stream
		list.parallelStream().forEach(System.out::print);
		list.stream().parallel().forEach(System.out::print);
		
		//REDUCE
		List<Integer> number = Arrays.asList(2,3,4,5);
		int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
	}
}
