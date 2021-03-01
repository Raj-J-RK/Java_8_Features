package com.rk.java8.hackerrank.programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
    	int valleyCount = 0;
    	int stepCount = 0;
    	System.out.println("Steps : "+steps);
    	System.out.println("Path : "+path);
    	char[] arrayPath = path.toCharArray();
    	System.out.println("arrayPath length : " +arrayPath.length);
    	for(int i=0;i<arrayPath.length;i++) {
    		int localCount = 0;
    		if(arrayPath[i] == 'U') {
    			localCount = 1;
    		}
    		else if (arrayPath[i] == 'D')
    		{
    			localCount = -1;
    		}
    		stepCount = stepCount+localCount;
    		if(stepCount == 0 && arrayPath[i] == 'U') {
    			valleyCount++;
    		}
    	}
    	System.out.println("valleyCount : "+valleyCount);
    	return valleyCount;
    }

}

public class CountingValleysSteps {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\Raj\\file4"));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

