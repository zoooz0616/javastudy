package ch06.sec04;

public class ClassExample {

	public static void main(String[] args) {
		Pen p1 = new Pen();
		//클래스 명 = new 생성자();
		System.out.println(p1);//해시코드(주소값)를 출력함.
		Pen p2 = new Pen();
		System.out.println(p2);
		System.out.println(p1.color);
		p2.color="blue";
		System.out.println(p2.color);
		
		Pen p3 = new Pen("red");
		System.out.println(p3.color);
	}

}
