package ch07;

public class InheritanceExample {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동",20,"123456789");
//		s1.name = "홀길동";
//		s1.age = 20;
//		s1.studentId = "123456789";
		Student s2= new Student();
		
		Person s3 = new Student();//super()를 부르니까 
		s3.name="g";
		s3.age=40;
//		s3.studentId="d";
		
		Person s5 = new Student();
		Student s4 = (Student)s5; // Student생성자를 부를 수 없음.
		s4.studentId="10";
		
		
		System.out.println(s1.getDetails());
	}

}
