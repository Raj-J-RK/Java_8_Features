package com.rk.java8.interfac;

public interface Animal {
	
	String getType();
	
	String startRun();
	
	String stopRun();
	
	default String startSound() {
		return "Starting animal sound";
	}
	
	default String stopSound() {
		return "Stopping animal sound";
	}

}
