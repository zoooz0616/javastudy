package ch17.sec07.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동",30));
		list.add(new Student("이은지",100));
		list.add(new Student("유미선",80));
		
		list.stream()
			.sorted()
			.forEach(s->System.out.println(s.getName()+": "+s.getScore()));
		System.out.println();
		
		list.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(s->System.out.println(s.getName()+": "+s.getScore()));
	}
}
