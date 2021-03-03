package com.rk.java8.impl;

import com.rk.java8.interfac.Animal;

public class Domestic implements Animal{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private final String type;
	
	public Domestic(String type) {
		this.type=type;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public String startRun() {
		// TODO Auto-generated method stub
		return this.type+" is starting to run";
	}

	@Override
	public String stopRun() {
		// TODO Auto-generated method stub
		return this.type + "stopped running";
	}

}
