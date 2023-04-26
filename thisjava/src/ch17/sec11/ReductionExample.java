package ch17.sec11;

import java.sql.Struct;
import java.util.Arrays;
import java.util.List;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동",92),
				new Student("신용권",95),
				new Student("감자바",8)
		);
		
		int sum=list.stream()
					.mapToInt(Student::getScore)
					.sum();
		
		int sum2 =list.stream()
				.map(Student::getScore)
				.reduce(0,(a,b)->a+b);
		
		System.out.println("sum1: "+sum);
		System.out.println("sum2: "+sum2);
	}
}
