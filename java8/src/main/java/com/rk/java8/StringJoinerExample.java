package com.rk.java8;

import java.util.StringJoiner;

public class StringJoinerExample {

	public static void main(String[] args) {
		
		//StringJoiner is a new class added in Java 8 under java.util package.
		//it is used for joining Strings with the help of delimiter, prefix, and suffix.
		
		StringJoiner joinNames = new StringJoiner(",");
		System.out.println("length:"+joinNames.length());
		joinNames.setEmptyValue("Its currently empty");
		System.out.println(joinNames);
		joinNames.add("One");
		joinNames.add("Two");
		joinNames.add("Three");
		joinNames.add("Four");
		System.out.println("joinNames: "+joinNames);
		
		StringJoiner joinNames1 = new StringJoiner("_");
		joinNames1.add("One");
		joinNames1.add("Two");
		joinNames1.add("Three");
		joinNames1.add("Four");
		System.out.println("joinNames: "+joinNames1);
		
		StringJoiner joinNames2 = new StringJoiner(",", "[", "]"); 
		joinNames2.add("One");
		joinNames2.add("Two");
		joinNames2.add("Three");
		joinNames2.add("Four");
		System.out.println("joinNames: "+joinNames2);	
		
		 StringJoiner merge = joinNames2.merge(joinNames1);   
	     System.out.println("meged: "+merge); 
	     System.out.println("merged string value: "+merge.toString());
	     System.out.println("merged length: "+merge.length());
	     
	}

}
