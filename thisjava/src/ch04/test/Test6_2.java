package ch04.test;

public class Test6_2 {
	public static void main(String[] args) {
		int row=5;
		
		for (int i = 0; i < row; i++) {
			
			for (int x = 0; x < row-i-1; x++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
				
			}
			System.out.println();
		}
	}
}
