package ch07.test.test7;

public class Child extends Parent{
	public String name;
	
	public Child() {
		this("홍길동");
		System.out.println("Child()");
	}
	
	public Child(String name) {
		this.name=name;
		System.out.println("Chile(String name)");
	}
}
