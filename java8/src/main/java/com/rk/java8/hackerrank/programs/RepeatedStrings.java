package com.rk.java8.hackerrank.programs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedStrings {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
		System.out.println("Input String :"+s);
		System.out.println("Number of charecters :"+n);
		System.out.println("length of string:"+s.length());
		long result = 0;
    	String sb = "";
    	//for single char input
    	if(s.length() == 1) {
    		if(s.contentEquals("a")) {
    			result = n;
    		}
    		else {
    			result = 0;
    		}
    	}
    	else {
    		int t = (int) n/s.length();
    	sb = new String(new char[t+1]).replace("\0", s);
    	//for (int i=0;i<=9999999; i++) {
    	//	sb = sb.append(s);
    	//}
    	System.out.println("sb :"+sb);
    	String subSb = sb.substring(0, (int) n);
    	System.out.println("subSb :"+subSb);
    	char[] charSubSb = subSb.toCharArray();
    	System.out.println("charSubSb :" +charSubSb.length);
    	for(char c: charSubSb) {
    		if(c == 'a') {
    			result++;
    		}
    	}
    	}
    	System.out.println("result :"+result);
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Raj\\file3"));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

