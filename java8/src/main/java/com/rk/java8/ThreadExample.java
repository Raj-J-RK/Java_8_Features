package com.rk.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.rk.java8.domain.User;

public class ThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMethod1();
	}
	
	private static void testMethod1() {
		Runnable runnable = () -> {
			try {
			System.out.println("test method 1 executed by " + Thread.currentThread().getName());
			printarray();
				Thread.sleep(2000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		runnable.run();
		Thread thread = new Thread(runnable);
		thread.start();
	}
	
	public static void printarray() {
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
		System.out.println(users);
		users.stream().filter(usr -> usr.getAge() > 30).forEach(usr -> System.out.println(usr.toString()));
	}

}
