package ch07;

import java.util.Date;

public class Manager extends Employee {
	private String department;
	
	public Manager(String name, double salary, Date birthDate, String deparment) {
		super(name, salary, birthDate);
		this.department = deparment;
		System.out.println("Manager(String name, double salary, Date birthDate, String deparment)생성자 호출");
	}
	
	public Manager(String name, String deparment) {
		super(name);
		this.department = deparment;
		System.out.println("Manager(String name, String deparment)생성자 호출");
	}
	
	public Manager(String department) {
		this(null, department);
		System.out.println("Manager(String department)생성자 호출");
	}
}
