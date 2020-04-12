package com.rk.java8.domain;

import java.time.LocalDate;

public class User {
	
	private String userId;
	private String userfName;
	private String userlName;
	private int age;
	private String city;
	private String country;
	private boolean governmentEmployee;
	private LocalDate dob;
	
	public User(String userId, String userfName, String userlName, int age, String city, String country,
			boolean governmentEmployee, LocalDate dob) {
		super();
		this.userId = userId;
		this.userfName = userfName;
		this.userlName = userlName;
		this.age = age;
		this.city = city;
		this.country = country;
		this.governmentEmployee = governmentEmployee;
		this.dob = dob;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserfName() {
		return userfName;
	}
	public void setUserfName(String userfName) {
		this.userfName = userfName;
	}
	public String getUserlName() {
		return userlName;
	}
	public void setUserlName(String userlName) {
		this.userlName = userlName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isGovernmentEmployee() {
		return governmentEmployee;
	}
	public void setGovernmentEmployee(boolean governmentEmployee) {
		this.governmentEmployee = governmentEmployee;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userfName=" + userfName + ", userlName=" + userlName + ", age=" + age
				+ ", city=" + city + ", country=" + country + ", governmentEmployee=" + governmentEmployee + ", dob="
				+ dob + "]";
	}

}
