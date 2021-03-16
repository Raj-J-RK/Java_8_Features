package com.rk.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RestCallExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Making call to external service sequantially : ");
		List<String> ctryList = Arrays.asList("Afghanistan","Albania","Bangladesh","Aruba","Bermuda","Colombia");
		HttpURLConnection conn;
		String baseUrl = "https://restcountries.eu/rest/v2/name/";
		URL url;
		BufferedReader br;
		try {
			Instant start = Instant.now();
			for(String s : ctryList) {
				url = new URL(baseUrl+s);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				System.out.println(br.readLine());
			}
			System.out.println("Time took sequentially:" + Duration.between(start, Instant.now()).getSeconds());

			System.out.println("------------------------------------------------------------ ");
			System.out.println("Making call to external service parallely using parallel stream : ");
			Instant startpr = Instant.now();
			ctryList.parallelStream().forEach(s -> {
				URL urlpr;
				try {
					urlpr = new URL(baseUrl+s);
					HttpURLConnection connpr = (HttpURLConnection) urlpr.openConnection();
					connpr.setRequestMethod("GET");
					connpr.setRequestProperty("Accept", "application/json");
					BufferedReader brpr = new BufferedReader(new InputStreamReader(connpr.getInputStream()));
					System.out.println(Thread.currentThread().getName() +" " +brpr.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Exception :"+ e);
				}
			});
			System.out.println("Time took parallel stream:" + Duration.between(startpr, Instant.now()).getSeconds());
			System.out.println("------------------------------------------------------------ ");
			System.out.println("Making call to external service parallely using executor service : ");
			Instant startex = Instant.now();
			ExecutorService es = Executors.newFixedThreadPool(3);
			Runnable cmd = (() -> invokeMethod(ctryList));
			es.execute(cmd);
			es.shutdown();
			System.out.println("Time took Executor :" + Duration.between(startex, Instant.now()).getSeconds());
			System.out.println("------------------------------------------------------------ ");
			System.out.println("Making call to external service parallely using callable service : ");
			Instant startcl = Instant.now();
			ExecutorService esc = Executors.newFixedThreadPool(3);
			List<Future<String>> clcList = new ArrayList<Future<String>>();			
			ctryList.parallelStream().forEach(s -> {
				Callable<String> cl = (() -> {
					return invokeMethodCal(s);
				});
				Future<String> fut = esc.submit(cl);
				clcList.add(fut);
			});
			for (Future<String> fu : clcList) {
				System.out.println("Callable: "+fu.get());
			}
			esc.shutdown();
			System.out.println("Time took Callable:" + Duration.between(startcl, Instant.now()).getSeconds());
		} catch (IOException | InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exception :"+ e1);
		}

	}

	private static void invokeMethod(List<String> ctryList) {
		String baseUrl = "https://restcountries.eu/rest/v2/name/";
		ctryList.parallelStream().forEach(s -> {
			URL urlpr;
			try {
				urlpr = new URL(baseUrl+s);
				HttpURLConnection connpr = (HttpURLConnection) urlpr.openConnection();
				connpr.setRequestMethod("GET");
				connpr.setRequestProperty("Accept", "application/json");
				BufferedReader brpr = new BufferedReader(new InputStreamReader(connpr.getInputStream()));
				System.out.println("executor :" +Thread.currentThread().getName() +" " +brpr.readLine());
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception :"+ e);
			}
		});

	}

	private static String invokeMethodCal(String s) {
		String baseUrl = "https://restcountries.eu/rest/v2/name/";
		String result = null;
		URL urlpr;
		try {
			urlpr = new URL(baseUrl+s);
			HttpURLConnection connpr = (HttpURLConnection) urlpr.openConnection();
			connpr.setRequestMethod("GET");
			connpr.setRequestProperty("Accept", "application/json");
			BufferedReader brpr = new BufferedReader(new InputStreamReader(connpr.getInputStream()));
			//System.out.println(Thread.currentThread().getName() +" " +brpr.readLine());
			result = Thread.currentThread().getName() +" " +brpr.readLine();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception :"+ e);
		}
		return result;
	}
}
