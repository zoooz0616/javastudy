package ch15.sec05.exam04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter @Getter
@ToString
public class Fruit {
	public String nameString;
	public int price;
}
