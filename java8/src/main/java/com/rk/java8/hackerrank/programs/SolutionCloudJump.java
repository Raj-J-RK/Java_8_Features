package com.rk.java8.hackerrank.programs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SolutionCloudJump {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int result = 0;
		System.out.println("length :" + c.length);
		List<Integer> arList = Arrays.stream(c).boxed().collect(Collectors.toList());
		System.out.println("arList :"+arList);
		List<Integer> planA = new ArrayList<Integer>();
		List<Integer> planB = new ArrayList<Integer>();
		System.out.println("Plan A :");
		for(int i=0; i<arList.size(); i++) {
			System.out.println("ar item :"+arList.get(i) + " index : "+i);
			if(arList.get(i) == 0) {
				planA.add(i);
			}	 
		}
		System.out.println("Plan B");

		int i = 0; for(i = 0;i<arList.size(); i++) {
			System.out.println("value of i :"+i);
			System.out.println("ar item :"+arList.get(i) + " index : "+i);
			if(arList.get(i) == 0) { planB.add(i); } if((arList.get(i) == 0) && (i <
					arList.size()-2)) { if(arList.get(i+2) == 0) { i = i+2;
					System.out.println("ar item +2:"+arList.get(i) + " index : "+i);
					planB.add(i); System.out.println("value of i :"+i); } } }

		System.out.println("planA jump :"+(planA.size()-1));
		System.out.println("planA :"+planA);
		System.out.println("planB jump :"+(planB.size()-1));
		System.out.println("planB :"+planB);
		result = (planA.size()-1) <= (planB.size()-1) ? planA.size()-1 : planB.size()-1;
		System.out.println("result : "+result);
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Raj\\file2"));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
