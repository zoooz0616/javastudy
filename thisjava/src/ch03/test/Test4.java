package ch03.test;

public class Test4 {

	public static void main(String[] args) {
		int pencils =534;
		int students =30;
		
		//한 학생이 가지는 연필 수
		int pencilsPerStrudent = pencils/students;
		System.out.println(pencilsPerStrudent);
		
		//남은 연필 수
		int pencilsLeft = pencils%students;
		System.out.println(pencilsLeft);
	}

}
