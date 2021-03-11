package com.rk.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import com.rk.java8.domain.Employee;

public class ConcurrentExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		//completable future with tunnable
		CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> {
			System.out.println("without return");
		});
		System.out.println("Message : "+cf1.get());
		
		//completable future with supplier
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
			System.out.println("completable feature");
			return "Hello";
		});
		System.out.println("Message : "+cf.get());
		
		getEmpDetails();
		
	}
	
	private static void getEmpDetails() {
		CompletableFuture<List<Employee>> cfe = CompletableFuture.supplyAsync(() -> {
			return getEmp();
		}).thenCompose(emps -> {
			List<Employee> updEmpList = null;
			try {
				updEmpList = emps.get().stream().map(emp -> {
					emp.setName(emp.getName().concat(" Updated"));
					emp.setLocation(emp.getLocation().concat(" Updated"));
					return emp;
				}).collect(Collectors.toList());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return CompletableFuture.completedFuture(updEmpList);
		});
		try {
			cfe.get().stream().forEach(emp -> System.out.println(emp.toString()));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static CompletableFuture<List<Employee>> getEmp() {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("name One", 25, 1, "location One"));
		empList.add(new Employee("name two", 35, 2, "location two"));
		empList.add(new Employee("name three", 45, 3, "location three"));
		empList.add(new Employee("name four", 55, 4,"location four"));
		empList.add(new Employee("name five", 65, 5, "location five"));
		empList.add(new Employee("name six", 75, 6, "location six"));
		empList.add(new Employee("name seven", 85, 7, "location seven"));
		empList.add(new Employee("name eight", 40, 8, "location eight"));
		empList.add(new Employee("name nine", 50, 9, "location nine"));
		empList.add(new Employee("name ten", 38, 10, "location ten"));
		return CompletableFuture.completedFuture(empList);
	}
}
