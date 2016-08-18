package com.bean;

public class Person {
	int id;
	String name;
	String grade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Person(int id, String name, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
}
