package com.rk.java8;

import java.math.BigDecimal;

public class DoubleExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Double d1 = 7.89;
		Double d2 = 7.89;
		System.out.println("d1+d2=");
		System.out.println(d1+d2);
		
		BigDecimal bd = new BigDecimal(7.89);
		System.out.println("bd+bd="+bd.add(bd));
		
	}

}
