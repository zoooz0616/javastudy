package ch12.sec08;

import java.util.Calendar;
import java.util.TimeZone;

public class LosAngelesExample {

	public static void main(String[] args) {
		TimeZone tz= TimeZone.getTimeZone("America/Los_Angeles");
		Calendar now=Calendar.getInstance(tz);
		
		int amPm = now.get(Calendar.AM_PM);
		String strAmPm=null;
		if (amPm == Calendar.AM) {
			strAmPm="오전";
		}else {
			strAmPm ="오후";
		}
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		System.out.println("LA의 시간은 "+strAmPm+" "+hour+"시 "+minute+"분 "+second+"초");
				
	}

}
