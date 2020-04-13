package com.rk.java8;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class NewDateApi {

	public static void main(String[] args) {
		
		System.out.println("Current Date :"+LocalDate.now());
		System.out.println("Current Date Time :"+LocalDateTime.now());
		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		System.out.println("Current Date Time by Zone:"+LocalDateTime.now(zoneId));
		System.out.println("Specific Date :"+LocalDate.of(1947, 8, 15));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY hh:mm:ss");
		System.out.println("Formatted Current Date Time by Zone:"+LocalDateTime.now(zoneId).format(formatter));
		System.out.println("Zones : "+ZoneId.getAvailableZoneIds());
		System.out.println("Default Zone :" + ZoneId.systemDefault());
		
		System.out.println("Instant :"+Instant.now());
		System.out.println("Instant to Epoche:"+Instant.now().toEpochMilli());
		System.out.println("Epoche to Instant:"+Instant.ofEpochMilli(1586763588957l).atZone(zoneId));
		
	}

}
