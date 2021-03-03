package com.rk.java8;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		
		//Optional is a container object which may or may not contain a not-null object. 
		//Optional object is used to represent null with absent value.
		
		Optional<String> opt = Optional.empty();
		Optional<String> opt1 = Optional.of("One");
		Optional<String> opt2 = Optional.ofNullable("");
		Optional<String> opt3 = Optional.ofNullable(null);
		System.out.println("opt: "+opt);
		System.out.println("isPresent:"+opt.isPresent());
		
		System.out.println("opt1: "+opt1);
		System.out.println("isPresent:"+opt1.isPresent());
		System.out.println("opt1 get : "+opt1.get());
		
		System.out.println("opt2: "+opt2);
		System.out.println("isPresent:"+opt2.isPresent());
		
		System.out.println("opt3: "+opt3);
		System.out.println("isPresent:"+opt3.isPresent());
		
		String result = (String) Optional.ofNullable(null).orElse("One");
		System.out.println("result:"+result);
		
		Optional<String> opt4 = Optional.ofNullable(null);
		String out = opt4.get();
		System.out.println("out:"+out);
		
		String result1 = (String) Optional.ofNullable(null).orElseThrow(IllegalArgumentException::new);
		System.out.println("result:"+result1);
		
	}

}
