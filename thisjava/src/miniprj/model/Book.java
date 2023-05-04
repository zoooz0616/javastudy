package miniprj.model;

import lombok.Data;

@Data
public class Book {
	// 예약자성함
	   String name;
	   // 체크인날짜
	   String checkIn;
	   // 체크아웃 날짜
	   String checkOut;
	   // 예약한 객실(standard, superior, suite 셋 중 하나)
	   String room;
	   // 예약 비밀번호
	   String password;
}
