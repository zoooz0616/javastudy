package ch08;

public class Hello extends HelloLog{
	public void sayHello(String name) {
		System.out.println("Hello~~"+name);
	}
}
//Hello 클래스의 sayHello()메서드가 실행되기 전에 HelloLog의 log()메서드를 실행하세요
//단 Hello 클래스 수정 불가능

