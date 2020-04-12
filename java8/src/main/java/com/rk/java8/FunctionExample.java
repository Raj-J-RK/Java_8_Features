package com.rk.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {
		
		Function<String, Integer> function = x -> x.length();
		Integer integer = function.apply("Hello World");
		System.out.println("integer :" +integer);
		
		Function<String, String> function1 = x -> x.toUpperCase();
		String response = function1.apply("Hello World");
		System.out.println("integer :" +response);
		
		Function<Integer, Integer> function2 = x -> x*5;
		Integer result = function1.andThen(function).andThen(function2).apply("Hello World");
		System.out.println("Result : " + result);
		
		BiFunction<String, Integer, String> biFunction = (x1,x2) -> x1+x2;
		String result1 = biFunction.apply("5", 5);
		System.out.println(result1);
		
	}

}
