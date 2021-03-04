package com.rk.java8;

import java.util.function.Supplier;

import com.rk.java8.domain.Employee;

public class SupplierExample {
	
	public static void main( String args[]) {
		
		Supplier<Employee> empSupplier = () -> {
			return new Employee("emp Name", 35, 123, "Emp Location");
		};
		
		Employee emp = empSupplier.get();
		System.out.println(emp.toString());
		
	}

}
