package pack1;

import java.sql.Date;

public class Hello {
	public static void main(String[] args) {
		java.lang.String s1= "Hello";
		Date date = new Date(123456789L);
		
		try{
			Class.forName("java.lang.String");
		}catch (ClassNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
		System.out.println();
		
		try {
			Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
			System.out.println();
		}
	}
}
