package com.rk.java8.interfac;

public interface Sound {
	
	default String startSound() {
		return "Starting sound";
	}
	
	default String stopSound() {
		return "Stopping sound";
	}

}
