package ch12.sec08;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {
		Calendar now=Calendar.getInstance();
		
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH);
		int day=now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);
		String strWeek= null;
		
		switch (week) {
		case Calendar.MONDAY: strWeek="월"; break;
		case Calendar.TUESDAY: strWeek="화";break;
		case Calendar.WEDNESDAY: strWeek="수";break;
		case Calendar.THURSDAY: strWeek="목"; break;
		case Calendar.FRIDAY: strWeek="금"; break;
		case Calendar.SATURDAY: strWeek="토"; break;
		default: strWeek="일";
		}
		
		int amPm = now.get(Calendar.AM_PM);
		String strAmPmString = null;
		if (amPm == Calendar.AM) {
			strAmPmString = "오전";
			
		} else {
			strAmPmString = "오후";
		}
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		System.out.println(year+"년"+(month+1)+"월"+day+"일"+strWeek+"요일"+strAmPmString+" "+hour+"시"+minute+"분"+second+"초");
	}

}
