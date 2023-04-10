package ch06.sec04;

public class Pen {
	String color;// ="black";
	
	//기본 생성자 : 인자가 없는 생성자
	//생성자가 없으면 컴파일러는 기본 생성자를 알아서 추가해줌
	
	//인자 있는 생서아자 있으니 기본 생성자가 안 생김
	
//	public Pen(){
//		this.color="black";
//	}
	
	public Pen() {
		this("black");//현재 클래스 내의 다른 생성자를 호출.
		
	}
	public Pen(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Pen [color=" + color + "]";
	}
//	
	//메서드
	//접근 제한자 사용제한자 리턴타입 매개변수 선언 + 실행코드
	//return은 void가 아닐 때 반드시 추가해야함.
	//메서드 정의, 메서드 호출(객체 참조)
	
	void write() {
		System.out.println("글을 쓴다.");
	}
	
	void write(String message) {
		System.out.println(message);
	}
	
}
