package ch09.sec05;

public class A {
	int a=10; //인스턴스 멤버변수
	void doIt() { //인스턴스 메서드
		
	}
	
	static int b; //정적 멤버변수
 	static void doThat() { //정적 메서드
		
	}
	
 	class B{
 		int a = 20;
 		void method1() {
 			a = 30; //가장 가까운 10를 가리킴.20을 30으로 바꿈.
 			b = 20;
 		}
 	}
 	
 	static class C{
// 		int a = 10;
 		void method1() {
// 			a=10; //Error.C는 인스턴스 없이 참조가능해야하기 때문에 내부에 a가 있어야 a사용 가능
 			b=10;//static 변수만 참조 가능.non-static ㅏ참조 불가능.
 			
 			A a1 = new A();
 			a1.a=20; //a를 참조하려면 인스턴스를 만들고 접근해야함.
 		}
 	}
}
