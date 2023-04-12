package ch07;

public class VirtualMethodInvoationExample {
	public static void main(String[] args) {
		A a= new C();
		a.doIt();
		a=new C();
		a.doIt();
		C c =(C)a;
		c.doThat();
		A a2 =new A();
		B b2 = (B)a2;//에러
	}
}

class A{
	public void doIt() {
		System.out.println("A");
	}
}

class B extends A{
	public void doIt() {
		System.out.println("B");
	}
	

}

class C extends A{
	public void doThat() {
		System.out.println("C");
	}
}