package ch12.sec08;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateExample {

	public static void main(String[] args) {
		Date now= new Date();
		String strNow1= now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strNow2=sdf.format(now);
		System.out.println(strNow2);
		
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		java.sql.Date date2 = new java.sql.Date(date.getTime());
		System.out.println(date2);
		System.out.println(System.currentTimeMillis());
		System.out.println(new java.sql.Date(System.currentTimeMillis()));
		
		
	}

}
