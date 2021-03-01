package com.rk.java8.hackerrank.programs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecursiveDigitSum {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
       	int result = 0;
    	System.out.println("input string :"+n);
    	System.out.println("repeat times :"+k);
    	StringBuilder sb = new StringBuilder();
    	while(true) {
    		sb = sb.append(n);
    		k--;
    		if(k<=0) {
    			break;
    		}
    	}
    	System.out.println("final input string :"+sb);
    	String s = new String(sb);
    	System.out.println("s:"+s);
    	Long l = Long.parseLong(s);
    	System.out.println("l:"+l);
    	int sum =0;
    	char[] intarr = s.toCharArray();
    	for(char c : intarr) {
    		System.out.println("C :" +c);
    		System.out.println("q:"+String.valueOf(c));
    		int d = Integer.valueOf(String.valueOf(c));
    		sum = sum+d;
    	}
    	System.out.println("sum:"+sum);
    	if(sum < 10) {
    		result = sum;
    	}
    	else {
    		String newip = String.valueOf(sum);
    		result = superDigit(newip,0);
    	}
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Raj\\file_rds"));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

