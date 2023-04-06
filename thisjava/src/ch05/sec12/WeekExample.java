package ch05.sec12;

import java.util.Calendar;

import sun.util.resources.ext.CalendarData_es;

public class WeekExample {

	public static void main(String[] args) {
		Week today=null;
		
		Calendar calendar=Calendar.getInstance();
		
		int week=calendar.get(Calendar.DAY_OF_WEEK);
		
		switch (week) {
		case 1: today=Week.SUNDAY;break;
		case 2: today=Week.MONDAY;break;
		case 3: today=Week.TUESDAY;break;
		case 4: today=Week.WEDSNESDAY; break;
		case 5: today=Week.THURSDAY; break;
		case 6: today=Week.FRIDAY; break;
		case 7: today=Week.SATURDAY;break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + week);
		}
		
		if (today==Week.SUNDAY) {
			System.out.println("일요일에는 축구를 합니다.");
			
		}else {
			System.out.println(today);
			System.out.println("열심히 자바를 공부합니다.");
		}
	}

}
