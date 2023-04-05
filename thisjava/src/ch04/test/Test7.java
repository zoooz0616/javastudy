package ch04.test;

import java.util.Scanner;

import javax.imageio.stream.ImageInputStream;

public class Test7 {

	public static void main(String[] args) {
		
		int count=0;
		boolean run=true;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("---------------------------");
			System.out.print("선택>");
			
			String menu=scanner.nextLine();
			
			if (menu.equals("1")) {
				System.out.print("예금액> ");
				String num=scanner.nextLine();
				count += Integer.parseInt(num);
			} else if (menu.equals("2")) {
				System.out.print("출금액> ");
				String num=scanner.nextLine();
				count -= Integer.parseInt(num);
			} else if (menu.equals("3")) {
				System.out.println("잔고>"+count);
			} else if (menu.equals("4")) {
				run=false;
			}
		}
		System.out.println("프로그램 종료");
		scanner.close();
	}

}
