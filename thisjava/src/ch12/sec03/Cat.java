package ch12.sec03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //setter/getter,toString, hash,equals 자동 생성
@AllArgsConstructor
@NoArgsConstructor//기본 생성자
public class Cat {
	private String idString;
	private String nameString;
	private int age;
}
