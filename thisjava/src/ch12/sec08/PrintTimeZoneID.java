package ch12.sec08;

import java.util.TimeZone;

public class PrintTimeZoneID {

	public static void main(String[] args) {
		String[] availableIDStrings = TimeZone.getAvailableIDs();
		for(String id:availableIDStrings){
			System.out.println(id);

		}
	}

}
