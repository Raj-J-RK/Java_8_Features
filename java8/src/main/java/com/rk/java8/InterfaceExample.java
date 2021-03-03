package com.rk.java8;

import com.rk.java8.impl.Domestic;
import com.rk.java8.impl.Pet;
import com.rk.java8.impl.Wild;
import com.rk.java8.interfac.Animal;

public class InterfaceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal wildAnimal = new Wild("Lion");
		System.out.println(wildAnimal.getType());
		System.out.println(wildAnimal.startRun());
		System.out.println(wildAnimal.stopRun());
		System.out.println(wildAnimal.startSound());
		System.out.println(wildAnimal.stopSound());
		
		Animal domAnimal = new Domestic("Cow");
		System.out.println(domAnimal.getType());
		System.out.println(domAnimal.startRun());
		System.out.println(domAnimal.stopRun());
		System.out.println(domAnimal.startSound());
		System.out.println(domAnimal.stopSound());
		
		Animal petAnimal = new Pet("Cat");
		System.out.println(petAnimal.getType());
		System.out.println(petAnimal.startRun());
		System.out.println(petAnimal.stopRun());
		System.out.println(petAnimal.startSound());
		System.out.println(petAnimal.stopSound());
	}

}
