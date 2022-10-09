package com.sumit.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args) {
		List<Integer> number = Arrays.asList(2,3,4,5);
		List<Integer> square = number.stream().map(x->x*x).collect(Collectors.toList());
		
		
		List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
		int computedAges = 
		  users.stream().map(User::getAge).reduce(0, (partialAgeResult, age) -> partialAgeResult + age);
		
		users.stream().collect(Collectors.groupingBy(User::getAge));
		
	}
	
	public Integer executeReduceOnParallelizedStream() {
		List<User> userList = Arrays.asList(new User("John", 30), new User("Julie", 35));
	    return userList
	      .parallelStream()
	      .reduce(
	        0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
	}

}

class User{
	
	int age;
	public User(String string, int i) {
		// TODO Auto-generated constructor stub
	}
	public int getAge() {
		return age;
	}
}
