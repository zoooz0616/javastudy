package ch17.sec02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("신욕권");
		list.add("홍길동");
		list.add("신욕권");
		list.add("홍길동");
		list.add("신욕권");
		
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(name->{
			System.out.println(name+": "+Thread.currentThread().getName());
		});
		
	}
}
