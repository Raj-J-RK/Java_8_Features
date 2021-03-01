package com.rk.java8.hackerrank.programs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RotateLeftSolution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
    	List<Integer> resultList = new ArrayList<Integer>();
    	List<Integer> inputList = Arrays.stream(a).boxed().collect(Collectors.toList());
    	int lastElmt=0;
    	while(true) {
    		System.out.println("Rotations : " + d);
    		System.out.println("inputList:"+inputList);
    	for(int i=0;i<inputList.size();i++) {
    		if(i == 0) {
    			lastElmt = inputList.get(i);
    		}
    		else {
    		resultList.add(inputList.get(i));
    		}
    	}
    	resultList.add(lastElmt);
    	System.out.println("resultList:"+resultList);
    	inputList.clear();
    	inputList.addAll(resultList);
    	d--;
    	if(d != 0) {
        	resultList.clear(); }
    	if(d == 0) {
    	break;
    	}
    	}
    	System.out.println("resultList:" + resultList);
    	int[] arr = resultList.stream().mapToInt(i -> i).toArray();
		return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Raj\\file_RLS"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
