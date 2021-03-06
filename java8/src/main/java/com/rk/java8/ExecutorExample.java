package com.rk.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.rk.java8.domain.User;

public class ExecutorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		User user = new User("1", "userfName 1", "userlName 1", 25, "Chennai", "India", false, LocalDate.of(1986, 1, 1));
		User user1 = new User("2", "userfName 2", "userlName 2", 26, "Mumbai", "India", true, LocalDate.of(1987, 1, 1));
		User user2 = new User("3", "userfName 3", "userlName 3", 27, "Texas", "US", false, LocalDate.of(1988, 1, 1));
		User user3 = new User("4", "userfName 4", "userlName 4", 28, "Montreal", "Canada", false, LocalDate.of(1989, 1, 1));
		User user4 = new User("5", "userfName 5", "userlName 5", 29, "Sydney", "Australia", true, LocalDate.of(1990, 1, 1));
		users.add(user);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		testMethod1(users);
		testMethod2(users);
	}
	
	private static void testMethod1(List<User> users) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Runnable command = () -> {
			System.out.println("test method 1 executed by " + Thread.currentThread().getName());
			ThreadExample.printarray();
		};
		executor.submit(command);
		executor.shutdown();
		
	}
	
	private static void testMethod2(List<User> users) {
		System.out.println("test method 2 executed by " + Thread.currentThread().getName());
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (User user : users) {
			Runnable task = () -> {
				printuser(user);
			};
			executor.submit(task);
		}
		executor.shutdown();
	}
	
	private static void printuser(User users) {
		System.out.println("executed by " + Thread.currentThread().getName()+ " " +users.toString());
	}

}
