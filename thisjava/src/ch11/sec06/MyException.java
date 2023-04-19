package ch11.sec06;

public class MyException extends RuntimeException {
	public MyException(String message) {
		super(message);
	}
	
	public MyException() {
		this("디폴트 예외 메시지");
	}
}
