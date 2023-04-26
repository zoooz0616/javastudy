package ch17.sec07.exam02;

import java.util.ArrayList;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", 30));
		list.add(new Student("신용권", 10));
		list.add(new Student("유미선", 20));
		
		list.stream()
			.sorted((s1,s2)->Integer.compare(s1.getScore(), s2.getScore()))
			.forEach(s->System.out.println(s.getName()+": "+s.getScore()));
		System.out.println();
		
		list.stream()
			.sorted((s1,s2)->Integer.compare(s2.getScore(), s1.getScore()))
			.forEach(s->System.out.println(s.getName()+": "+s.getScore()));
	}
}
