package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Spring");
		
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String elementString = iterator.next();
			System.out.println(elementString);
			if (elementString.equals("JSP")) {
				iterator.remove();
			}
			
		}
		System.out.println();
		
		set.remove("JDBC");
		
		for (String string : set) {
			System.out.println(string);
		}
	}

}
