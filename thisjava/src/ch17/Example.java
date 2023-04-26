package ch17;

import java.util.Arrays;
import java.util.List;

public class Example {
	public static void main(String[] args) {
		List<String> list = Arrays.asList(
				new String("hihihihi"),
				new String("nonnono"),
				new String("omg")
			);
	
		int result = list.stream()
			.filter(item->item.length()>4)
			.peek(item-> System.out.println(item))
			.mapToInt(item ->{
				return item.length();
			})
			.reduce(0,(a,b)->a+b);
		System.out.println(result);
	}
}
