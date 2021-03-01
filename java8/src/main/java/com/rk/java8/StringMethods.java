package com.rk.java8;

public class StringMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "This is the input";
		System.out.println("Input for this prog : " + input);
		
		System.out.println("Method charAt(): ");
		System.out.println("Method charAt():" +input.charAt(0));
		System.out.println("Method charAt():" + input.charAt(1));
		
		System.out.println("Method codePointAt(): Returns unicode value of char");
		System.out.println("Method codePointAt():" +input.codePointAt(0));
		System.out.println("Method codePointAt():" +input.codePointAt(1));
		
		System.out.println("Method codePointBefore(): Returns unicode value of char before this index");
		//System.out.println("Method codePointBefore():"+input.codePointBefore(0));
		System.out.println("Method codePointBefore():"+input.codePointBefore(1));
		System.out.println("Method codePointBefore():"+input.codePointBefore(2));
		
		System.out.println("Method codePointCount(x,y): returns value between these 2 indexes");
		System.out.println("values:"+input.codePointCount(0, 1));
		System.out.println("compareTo 1:"+input.compareTo("Hello"));
		System.out.println("compareTo 2:"+input.compareTo("This is the input"));
		System.out.println("compareTo 3:"+input.compareTo("This is the Input"));
		System.out.println("compareToIgnoreCase 1:"+input.compareToIgnoreCase("This is the Input"));
		
		input = input.concat(" concated string");
		System.out.println("modified input value:"+input);
		System.out.println("input : "+input);
		System.out.println("input contains z :"+input.contains("z"));
		System.out.println("input contains c :"+input.contains("c"));
		
		System.out.println("input contentEquals :"+input.contentEquals("This is the input concated string"));
		System.out.println("input contentEquals :"+input.contentEquals("Input"));
		
		System.out.println("input length :"+input.length());
		System.out.println("input getBytes :"+input.getBytes().length);
		
		System.out.println("intern : "+input.intern());
	}

}
