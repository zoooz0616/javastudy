package ch04.test;

public class Test4 {

	public static void main(String[] args) {
		
		int num1=0;
		int num2=0;
		int sum=0;
		
		while (true) {
			num1=(int)(Math.random()*6)+1;
			num2=(int)(Math.random()*6)+1;
			sum=num1+num2;
			System.out.println("("+num1+","+num2+")");
			
			if (sum==5) {
				break;
			}
		}
	}
}
