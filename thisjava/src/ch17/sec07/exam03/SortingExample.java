package ch17.sec07.exam03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", 30));
		list.add(new Student("신용권", 10));
		list.add(new Student("유미선", 20));
		
		list.stream()
			.sorted(new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getScore()-o2.getScore();
				}
			})
			.forEach(s->System.out.println(s.getName()+": "+s.getScore()));
		
		System.out.println();
		
		list.stream()
			.sorted(new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o2.getScore()-o1.getScore();
				}
			})
			.forEach(s->System.out.println(s.getName()+": "+s.getScore()));
	}
}
