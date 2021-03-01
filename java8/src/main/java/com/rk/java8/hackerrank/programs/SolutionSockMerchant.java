package com.rk.java8.hackerrank.programs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class SolutionSockMerchant {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		int result = 0;
		System.out.println("n :" + n);
		System.out.println("length :" + ar.length);

		List<Integer> arList = Arrays.stream(ar).boxed().collect(Collectors.toList());

		System.out.println("arList size : "+arList.size());
		System.out.println("arList : "+arList);
		Collections.sort(arList);
		System.out.println("arList : "+arList);

		Set<Integer> arSet = new HashSet<Integer>();
		for(int i : arList) {
			arSet.add(i);
		}
		System.out.println(arSet);
		int indcount = 0;
		for(int j : arSet) {
			indcount = Collections.frequency(arList, j);
			System.out.println("indcount "+j+":"+indcount);
			if(indcount > 1) {
				if ((indcount % 2) == 0) {
					result = result + (indcount/2);
				}
				else {
					result = result + ((indcount-1)/2);
				}
			}
		}

		System.out.println("Result : " + result);
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Raj\\file"));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
