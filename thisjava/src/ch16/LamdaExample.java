package ch16;

public class LamdaExample {
	public static void main(String[] args) {
//		doIt(doThat()->{
//			System.out.println("ㅗㅑ");
//		});
		
		action(new Calculable() {
			
			@Override
			public void calculate(int x, int y) {
				System.out.println(x+y);
			}
		});
		
		action((x,y)->{System.out.println(x+y);});
		//calculate의 매개변수x,와y
	}
	
	public static void action(Calculable c) {
		c.calculate(10, 20);
	}
	
	public static void doIt() {
		System.out.println("doIt");
	}
	
	public static void doThat() {
		System.out.println("doThat");
	}
}
