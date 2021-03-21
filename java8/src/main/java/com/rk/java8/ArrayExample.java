package com.rk.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rk.java8.domain.User;

public class ArrayExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrStrings = {"One","Two","Three","Four","Five"};
		System.out.println(arrStrings.length);
		System.out.println(Arrays.asList(arrStrings));
		
		User[] userArr = new User[5];
		userArr[0] = new User("1", "userfName", "userlName", 30, "city", "country", false, LocalDate.now());
		userArr[1] = new User("2", "userfName", "userlName", 30, "city", "country", false, LocalDate.now());
		userArr[2] = new User("3", "userfName", "userlName", 30, "city", "country", false, LocalDate.now());
		userArr[3] = new User("4", "userfName", "userlName", 30, "city", "country", false, LocalDate.now());
		userArr[4] = new User("5", "userfName", "userlName", 30, "city", "country", false, LocalDate.now());
		//array index out of bound exception
		//userArr[5] = new User("6", "userfName", "userlName", 30, "city", "country", false, LocalDate.now());
		
		for(User u:userArr) {
			System.out.println(u.toString());
		}
		System.out.println("Array List size can be increased dynamically");
		List<User> userList = new ArrayList<User>();
		userList.add(new User("1", "userfName", "userlName", 30, "city", "country", false, LocalDate.now()));
		userList.add(new User("2", "userfName", "userlName", 30, "city", "country", false, LocalDate.now()));
		userList.add(new User("3", "userfName", "userlName", 30, "city", "country", false, LocalDate.now()));
		userList.add(new User("4", "userfName", "userlName", 30, "city", "country", false, LocalDate.now()));
		userList.stream().forEach(u -> System.out.println(u.toString()));
		System.out.println("Size: "+userList.size());
		System.out.println("Adding few more entries");
		userList.add(new User("5", "userfName", "userlName", 30, "city", "country", false, LocalDate.now()));
		userList.add(new User("6", "userfName", "userlName", 30, "city", "country", false, LocalDate.now()));
		userList.add(new User("7", "userfName", "userlName", 30, "city", "country", false, LocalDate.now()));
		userList.stream().forEach(u -> {
			if(Integer.valueOf(u.getUserId()) > 4) {
			System.out.println(u.toString());
			}
			});
		System.out.println("Size: "+userList.size());
	}
}
