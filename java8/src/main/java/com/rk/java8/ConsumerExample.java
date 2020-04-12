package com.rk.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<String> consumer = x -> System.out.println(x.toUpperCase());
		Consumer<String> consumer1 = x -> System.out.println(x.length());
		List<String> list = Arrays.asList("one","two","three","four","five");
		list.stream().forEach(x -> {
			consumer.accept(x);
			consumer1.accept(x);
		});
	}

}
