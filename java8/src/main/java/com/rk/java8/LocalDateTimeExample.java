package com.rk.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class LocalDateTimeExample {
	
	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		LocalDate ld1 = LocalDate.of(2021, 01, 01);
		LocalDate ld2 = LocalDate.of(2020, 12, 30);
		
		System.out.println("ld1: "+dtf.format(ld1));
		System.out.println("ld2: "+dtf.format(ld2));
		
		System.out.println("ld1.compareTo(ld2): "+ld1.compareTo(ld2));
		System.out.println("ld1.equals(ld2): "+ld1.equals(ld2));
		System.out.println("ld1.isAfter(ld2): "+ld1.isAfter(ld2));
		System.out.println("ld1.isBefore(ld2): "+ld1.isBefore(ld2));
		System.out.println("Current time "+ LocalDateTime.now());
		
		System.out.println("Formatted value : "+dtf2.format(LocalDate.parse("19/01/2019", dtf2)));
		System.out.println("Zone ids: "+ZoneId.getAvailableZoneIds());
		System.out.println("Zoned Time Canada/Eastern : "+LocalDateTime.now(ZoneId.of("Canada/Eastern")));
		System.out.println("Zoned Time Canada/Atlantic : "+LocalDateTime.now(ZoneId.of("Canada/Atlantic")));
		System.out.println("Zoned Time Asia/Kolkata : "+LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
		System.out.println("Zoned Time Canada/Eastern + 8hrs in diferent time zone: "+LocalDateTime.now().plusHours(8).atZone(ZoneId.of("Canada/Eastern")).withZoneSameInstant(ZoneId.of("Asia/Kolkata")));
		System.out.println("Zoned Time Canada/Eastern + 8hrs in same time zone: "+LocalDateTime.now().plusHours(8).atZone(ZoneId.of("Canada/Eastern")).withZoneSameLocal(ZoneId.of("Canada/Eastern")));
		System.out.println("Zoned Time Canada/Eastern + 8hrs in same time zone: "+LocalDateTime.now().plusHours(8).atZone(ZoneId.of("Canada/Eastern")));
		
		Set<String> zones = ZoneId.getAvailableZoneIds();
		zones.stream().forEach(z -> {
			if(z.contains("Asia")) {
				System.out.println(z);
			}
		});
		
		System.out.println("Asia Zones :"+zones.stream().filter(z -> z.contains("Asia")).collect(Collectors.toList()));
	}

}
