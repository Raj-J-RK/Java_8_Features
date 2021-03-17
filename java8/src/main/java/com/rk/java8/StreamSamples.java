package com.rk.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rk.java8.domain.User;

public class StreamSamples {

	public static void main(String[] args) {
		List<User> users = setUserList();
		System.out.println("Full List of users");
		System.out.println(users);
		System.out.println("-----------------------------");
		System.out.println("Full List of users using for each");
		users.stream().forEach(user -> System.out.println(user.toString()));
		System.out.println("-----------------------------");
		System.out.println("User with age greater than 30 ");
		users.stream().filter(user -> user.getAge() > 30).forEach(user -> System.out.println(user.toString()));
		System.out.println("-----------------------------");
		users.stream().forEach(user -> {
			if(user.getAge() == 28) {
			System.out.println("User with 28 year age is "+user.getUserfName());	
			}
		});
		System.out.println("-----------------------------");
		System.out.println("Government Employee from India");
		users.stream().filter(user -> user.isGovernmentEmployee()==true)
		.filter(user->user.getCountry()=="India").forEach(user->System.out.println(user.toString()));
		System.out.println("-----------------------------");
		System.out.println("Government Employee");
		System.out.println(users.stream().filter(user -> user.isGovernmentEmployee()==true)
		.collect(Collectors.toList()));
		System.out.println("-----------------------------");
		System.out.println("List of peoples from India");
		System.out.println(users.stream().filter(user -> user.getCountry()=="India")
				.map(user -> user.getUserfName()).collect(Collectors.toList()));
		System.out.println("-----------------------------");
		System.out.println("Group by");
		System.out.println(users.stream().collect(Collectors.groupingBy(User::getCountry, Collectors.counting())));
		System.out.println("-----------------------------");
		System.out.println("Sorted");
		System.out.println(users.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList()));
		System.out.println(users.stream().sorted(Comparator.comparing(User::getCountry)).collect(Collectors.toList()));
		System.out.println("-----------------------------");
		//convert list to map
		ArrayList<User> userList = (ArrayList<User>) setUserList();
		Map<String, String> productPriceMap = userList.stream()
				.collect(Collectors.toMap(u -> u.getUserId(), u -> u.getUserfName()));
		System.out.println(productPriceMap);
		
		//Array Sorting
		List<User> sortList = setUserList();
		Collections.sort(sortList);
		System.out.println(sortList);
		Collections.sort(sortList, (u1,u2) -> u1.getCity().compareTo(u2.getCity()));
		System.out.println(sortList);
	}
	
	private static List<User> setUserList(){
		List<User> users = new ArrayList<User>();
		User user = new User("1", "userfName 1", "userlName 1", 25, "Chennai", "India", false, LocalDate.of(1986, 1, 1));
		User user1 = new User("2", "userfName 2", "userlName 2", 26, "Mumbai", "India", true, LocalDate.of(1987, 1, 1));
		User user2 = new User("3", "userfName 3", "userlName 3", 27, "Texas", "US", false, LocalDate.of(1988, 1, 1));
		User user3 = new User("4", "userfName 4", "userlName 4", 28, "Montreal", "Canada", false, LocalDate.of(1989, 1, 1));
		User user4 = new User("5", "userfName 5", "userlName 5", 29, "Sydney", "Australia", true, LocalDate.of(1990, 1, 1));
		User user5 = new User("6", "userfName 6", "userlName 6", 30, "Dublin", "Ireland", false, LocalDate.of(1991, 1, 1));
		User user6 = new User("7", "userfName 7", "userlName 7", 31, "Tokyo", "Japan", true, LocalDate.of(1992, 1, 1));
		User user7 = new User("8", "userfName 8", "userlName 8", 32, "Jakarta", "Indonesia", false, LocalDate.of(1993, 1, 1));
		User user8 = new User("9", "userfName 9", "userlName 9", 33, "Boston", "US", true, LocalDate.of(1994, 1, 1));
		User user9 = new User("10", "userfName 10", "userlName 10", 34, "Paris", "France", false, LocalDate.of(1995, 1, 1));
		User user10 = new User("20", "userfName 20", "userlName 20", 54, "Paris", "France", false, LocalDate.of(1985, 1, 1));
		users.add(user);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		users.add(user7);
		users.add(user8);
		users.add(user9);
		users.add(user10);
		return users;
	}
}
