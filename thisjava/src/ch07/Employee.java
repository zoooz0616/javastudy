package ch07;

import java.util.Date;


public class Employee {
	private static final double BASE_SALARY=15000.00;
	private String name;
	private double salary;
	private Date birthDate;
	

	public Employee(String name, double salary, Date birthDate) {
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
		System.out.println("Employee(String name, double salary, Date birthDate)생성자 호출");
	}
	
	public Employee(String name, double salary) {
		this(name, salary, null);
		System.out.println("Employee(String name, double salary)생성자 호출");
	}
	
	public Employee(String name, Date DoB) {
		this(name, BASE_SALARY, DoB);
		System.out.println("Employee(String name, Date DoB)생성자 호출");;
	}
	
	public Employee(String name) {
		this(name, BASE_SALARY);
		System.out.println("Employee(String name)생성자 호출");
	}
}
