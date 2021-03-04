package com.rk.java8;

public class FunctionalInterfaceExample {
	
	public static void main(String args[]) {
		//Functional programming
		Printable lambdaPrint = (msg) -> {
			System.out.println("Lambda Message : " + msg);
		};
		lambdaPrint.printMsg("Printing msg");
		
		//Normal way
		Printable normalPrint = new Printable() {
			@Override
			public void printMsg(String msg) {
				System.out.println("Normal Message : " + msg);
			}
		};
		normalPrint.printMsg("Printing msg");
	}
}

@FunctionalInterface
interface Printable {
	void printMsg(String msg);
}
