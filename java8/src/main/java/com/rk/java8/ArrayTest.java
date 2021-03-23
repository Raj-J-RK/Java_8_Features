package com.rk.java8;

public class ArrayTest {
	
	public static void main(String args[]) {
		//count 0's
		int arr[] = {1,1,1,0,0,0};
		int count =0;
		printArray(arr);
		for(int i=0; i < arr.length; i++) {
			if(arr[i]== 0) {
				count=count+1;
			}
		}
		System.out.println("Count of 0:"+count);
		//count 0's
		
		//count number of numbers in int array[]
		 int arrnum[] = {11,12,13,14,15,16};
		 printArray(arrnum);
		 String tmp;
		 int count2=0;
		 for(int i=0; i < arr.length; i++) {
			 tmp=String.valueOf(arrnum[i]);
			 char chrarr[] = tmp.toCharArray();
			 for (int j=0; j< chrarr.length; j++) {
				 if(chrarr[j] == '1') {
					 count2=count2+1; 
				 }
			 }
			}
			System.out.println("Count of 1:"+count2);
	
			//count number of numbers in int array[]
			
			//find index of seq in string
			String input="ABCDACASAEABWDEFRGABSCE";
			System.out.println("input string:"+input);
			int inputlen = input.length();
			System.out.println("length :"+inputlen);
			String[] tmpArry;
			tmpArry = input.split("AB");
			for(int i=0; i<tmpArry.length;i++) {
				if(i ==3 && tmpArry[i]!= null) {
				System.out.println(tmpArry[i]);
				System.out.println("Index :"+input.indexOf("AB", input.indexOf("AB") + 3));
				}
			}
			int first = input.indexOf("AB");
			int second = input.indexOf("AB", first + 1);
			int third = input.indexOf("AB", second + 1);
			System.out.println(first+ " "+ second + " " + third);
			//find index of seq in string
	}
	
	static void printArray(int arr[]) {
		System.out.println("Array value: ");
		for(int i : arr) {
			System.out.print(i + "\t");
		}
	}

}
