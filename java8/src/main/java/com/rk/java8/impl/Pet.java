package com.rk.java8.impl;

import com.rk.java8.interfac.Animal;
import com.rk.java8.interfac.Sound;

public class Pet implements Animal,Sound{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	private String type;
	
	public Pet(String type) {
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
		return this.type+ " is starting to run";
	}

	@Override
	public String stopRun() {
		// TODO Auto-generated method stub
		return this.type+ " is stopping";
	}

	@Override
	//Since same default method is present in both interface use the interface name to call the respective default methods.
	public String startSound() {
		// TODO Auto-generated method stub
		return Sound.super.startSound() + " " + Animal.super.startSound();
	}
	
	@Override
	public String stopSound() {
		// TODO Auto-generated method stub
		return Sound.super.stopSound() + " " + Animal.super.stopSound();
	}

}
