package ch05.sec12;

import java.util.Date;
import java.util.Calendar;

public class CalendarExample {
	public static void main(String[] args) {
		Date now1 = new Date();
		System.out.println(now1);
		Date now2= new Date();
		System.out.println(now2);
		
		System.out.println(now1==now2);//객체가 새로 생성됨
		
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2=Calendar.getInstance();
		System.out.println(calendar==calendar2);//객체가 복사됨.
		
		int year=calendar.get(Calendar.YEAR);
		System.out.println(year);
		
		
	}

}
