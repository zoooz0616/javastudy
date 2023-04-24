package ch13.test.test3;

public class ContainerExample {

	public static void main(String[] args) {
		Container<String, String> container1=new Container<String, String>();
		container1.set("홍길동", "도적");
		String name =container1.getKey();
		String job = container1.getValue();
		System.out.println("name: "+name+"job: "+job);
		Container<String, Integer> container2 = new Container<String, Integer>();
		container2.set("홍길동", 35);
		String name2 = container2.getKey();
		int age = container2.getValue();
		System.out.println("name: "+name2+"age: "+age);
	}

}
