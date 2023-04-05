package ch05;

public class MemoryExample {

	public static void main(String[] args) {
		int number=10;
		
		Pen p1 = new Pen("검정색");
		Pen p2 = new Pen("검정색");
		Pen p3=p1;
		System.out.println(p1==p2);
		System.out.println(p1==p3);
		
		Pen p4=new Pen("파랑색");
		p4.write();
		
		p2=null; //p2 GC대상이 된다.
		p1=null;//p3가 가리키고 잇기 때문에 GC대상이 안 됨.(garbage collector)
	}
}//end Class

class Pen{
	public final String BRAND ="모나미"; //상수
	public static int count =0;//정적 필드
	public String color;//인스터스 필드
	public Pen(String color) {
		this.color = color;
	}//생성자
	public void write() {
		System.out.println("Hello");
	}
	
	
	
}
