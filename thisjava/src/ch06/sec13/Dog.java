package ch06.sec13;

public class Dog {
	private String name;
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age < 0) {
			System.out.println("age는 0보다 크거나 같아야 합니다.");
			age = 0;
		}
		this.age = age;
	}
	
	
}
