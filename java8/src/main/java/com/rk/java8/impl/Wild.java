package com.rk.java8.impl;

import com.rk.java8.interfac.Animal;

public class Wild implements Animal{
	
	private final String type;
	
	public Wild(String type) {
		this.type=type;
	}

	public static void main(String[] args) {
		

	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String startRun() {
		return this.type+" is starting to run";
	}

	@Override
	public String stopRun() {
		return this.type+" is stopping";
	}

}
