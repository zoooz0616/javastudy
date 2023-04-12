package ch07;

public class Student extends Person {
	protected String studentId;
	

	public Student(String name, int age,String studentId) {
		super(name, age);
		this.studentId = studentId;
	}
	public Student() {
		super();
	}



	public String getDetails() {
		return super.getDetails() +"\t학번:"+studentId;
	}
}
