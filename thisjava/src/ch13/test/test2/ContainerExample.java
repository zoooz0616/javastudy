package ch13.test.test2;

public class ContainerExample {
	public static void main(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		System.out.println(container1.get());
		
		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		System.out.println(container2.get());
	}
	
}
