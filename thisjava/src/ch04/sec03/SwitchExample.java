package ch04.sec03;

public class SwitchExample {
	
	public static void main(String[] args) {
		int a = 10;
		char b = switch(a) {
		case 10,9,8 -> 'A';
		case 7,6,5 -> {
			System.out.println("7,6,5 입니다.");
			yield 'B';
		}
		default -> 'C';
		};
		System.out.println(b);
	}

}
