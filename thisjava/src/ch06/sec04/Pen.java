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
	
	
	
}
