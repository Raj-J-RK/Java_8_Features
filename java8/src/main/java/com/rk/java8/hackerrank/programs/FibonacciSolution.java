package com.rk.java8.hackerrank.programs;

import java.util.*;

public class FibonacciSolution {

    public static int fibonacci(int n) {
    	int fib = 0;
    	System.out.println("n:"+n);
        // Complete the function.
    	if( n == 1) {
    		fib = 1;
    		System.out.println("fib :"+fib);
    		return fib;
    	}
    	else if (n == 0) {
    		fib = 0;
    		System.out.println("fib :"+fib);
    		return fib;
    	}
    	else {
    		fib = fibonacci(n-2) + fibonacci(n-1);
    		System.out.println("fib :"+fib);
    		return fib;
    	}
    	//System.out.println("final fib :"+fib);
    	//return fib;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
