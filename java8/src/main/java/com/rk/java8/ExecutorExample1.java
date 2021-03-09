package com.rk.java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorExample1 {
	
	private static final String FILE_PATH = "C:\\Users\\HP\\Documents\\Java_8_Features\\java8\\src\\main\\resources\\input.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long start,end;
			List<List<Integer>> input = loadDate();
			System.out.println("Input data : " + input);
			System.out.println("----------------------------------------------------------------------------------------------");
			
			
			start = System.nanoTime();
			List<Integer> sequentialSum = sequantialSum(input);
			end = System.nanoTime() - start;
			System.out.println("Time took for summing it sequentially: " + end);
			System.out.println("Result by summing it sequentially : " + sequentialSum);
			System.out.println("----------------------------------------------------------------------------------------------");
			
			start = System.nanoTime();
			ConcurrentHashMap<String, Integer> threadSum = threadSum(input);
			end = System.nanoTime() - start;
			System.out.println("Time took for summing it using threads: " + end);
			System.out.println("Result by summing it using threads : " + threadSum);
			System.out.println("----------------------------------------------------------------------------------------------");
			
			start = System.nanoTime();
			ConcurrentHashMap<String, Integer> executorSum = executorSum(input);
			end = System.nanoTime() - start;
			System.out.println("Time took for summing it using executors: " + end);
			System.out.println("Result by summing it using executors : " + executorSum);
			System.out.println("----------------------------------------------------------------------------------------------");
			
			start = System.nanoTime();
			List<Integer> callableSum = callableSum(input);
			end = System.nanoTime() - start;
			System.out.println("Time took for summing it using callable: " + end);
			System.out.println("Result by summing it using callable : " + callableSum);
			System.out.println("----------------------------------------------------------------------------------------------");
		}
		catch (IOException e) {
			System.out.println("Exception occured :"+e);
		}
	}
	
	private static List<Integer> sequantialSum(List<List<Integer>> input) {
		List<Integer> sequentialSum = new ArrayList<Integer>();
		for(List<Integer> li : input) {
			int sum = 0;
			for(int i : li) {
				sum = sum + i;
			}
			sequentialSum.add(sum);
		}
		return sequentialSum;
	}
	
	private static ConcurrentHashMap<String, Integer> threadSum(List<List<Integer>> input) {
		ConcurrentHashMap<String, Integer> threadSum = new ConcurrentHashMap<String, Integer>(input.size());
		List<Thread> threads = new ArrayList<Thread>();
		int i = 1;
		for (List<Integer> li : input) {
			String arrayName = "Array " + i;
			Thread thread = new Thread(new ThreadSumCalculator(threadSum, arrayName, li));
			threads.add(thread);
			i++;
		}
		for (Thread t: threads) {
			t.start();
			try {
				t.join();
			}
			catch (InterruptedException e) {
				// TODO: handle exception
				Thread.currentThread().interrupt();
			}
		}
		return threadSum;
	}
	
	private static ConcurrentHashMap<String, Integer> executorSum(List<List<Integer>> input) {
		ConcurrentHashMap<String, Integer> executorSum = new ConcurrentHashMap<String, Integer>(input.size());
		ExecutorService execService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
		 int i = 1;
		for(List<Integer> li : input) {
			String arrayName = "ArranName " + i;
			execService.execute(new ThreadSumCalculator(executorSum, arrayName, li));
			i++;
		}
		execService.shutdown();
		try {
			execService.awaitTermination(60, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			Thread.currentThread().interrupt();
		}
		return executorSum;
		
	}
	
	private static List<Integer> callableSum(List<List<Integer>> input) {
		List<Callable<Integer>> callable = new ArrayList<>(input.size());
		List<Integer> callableSum = new ArrayList<Integer>();
		for(List<Integer> li : input) {
			Callable<Integer> call = new CallableSum(li);
			callable.add(call);
		}
		ExecutorService execService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
		try {
			List<Future<Integer>> futures = execService.invokeAll(callable);
			execService.shutdown();
			for(Future<Integer> fui : futures) {
				Integer sum = fui.get();
				callableSum.add(sum);
			}
		}
		catch (InterruptedException | ExecutionException e) {
			// TODO: handle exception
			Thread.currentThread().interrupt();
		}
		return callableSum;
	}
	
	private static List<List<Integer>> loadDate() throws IOException{
		Path path = Paths.get(FILE_PATH);
		List<String> filedata = Files.readAllLines(path, Charset.defaultCharset());
		List<List<Integer>> data = new ArrayList<List<Integer>>();
		for(String s: filedata) {
			String [] singleline = s.split(",");
			List<Integer> intList = new ArrayList<Integer>();
			for(String st : singleline) {
				intList.add(Integer.valueOf(st));
			}
			data.add(intList);
		}
		return data;
	}
}

class ThreadSumCalculator implements Runnable {
	ConcurrentHashMap<String, Integer> threadSum;
	String arrayname;
	List<Integer> intList;
	
	public ThreadSumCalculator(ConcurrentHashMap<String, Integer> threadSum, 
			String arrayName, List<Integer> intList) {
		this.arrayname = arrayName;
		this.intList = intList;
		this.threadSum = threadSum;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i : intList) {
			sum = sum + i;
			threadSum.put(arrayname, sum);
		}
	}
	
}

class CallableSum implements Callable<Integer> {
	List<Integer> li;
	public CallableSum(List<Integer> li) {
		this.li = li;
	}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i : li) {
			sum = sum + i;
		}
		return sum;
	}
	
}
