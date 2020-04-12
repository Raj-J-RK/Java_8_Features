package com.rk.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExamples {

	public static void main(String[] args) {
		// Functional Interface : Function, Predicate, Consumer
		List<Integer> list = Arrays.asList(10,20,30,40,50,60,70,80,90,100);
		System.out.println("Full List");
		System.out.println(list);
		System.out.println("-----------------");
		System.out.println("Reducing list using filters");
		System.out.println(list.stream().filter(i -> i > 50).collect(Collectors.toList()));
		System.out.println("Reducing list using predicate");
		Predicate<Integer> predicate = x->x>50;
		System.out.println(list.stream().filter(predicate).collect(Collectors.toList()));
		System.out.println("Reducing list using multiple predicate");
		Predicate<Integer> predicate2 = x->x<100;
		System.out.println(list.stream().filter(predicate.and(predicate2)).collect(Collectors.toList()));

	}

}
