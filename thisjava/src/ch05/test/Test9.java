package ch05.test;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		String menu;
		boolean status=true;
		Scanner scanner=new Scanner(System.in);
		int max=0;
		int sum=0;
		
		int[] scores= {};
		
		int stdnum;

		while (status) {
			System.out.println("------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택>");
			
			menu=scanner.nextLine();
			
			
			switch (menu) {
			case "1": {
				System.out.print("학생수>");
				stdnum=Integer.parseInt(scanner.nextLine());
				scores=new int[stdnum];
				break;
			}
			case "2": {
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores["+i+"]>");
					scores[i]=Integer.parseInt(scanner.nextLine());
					//scores[i]=scanner.nextInt();
				}
				break;
			}
			case "3":{
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores["+i+"]:"+scores[i]);
					
				}
				break;
			
			}
			case "4": {
				for (int i = 0; i < scores.length; i++) {
					if (max<scores[i]) {
						max=scores[i];
					}
					sum+=scores[i];
				}
				System.out.println("최고 점수: "+ max);
				System.out.println("평균 점수: "+(double)sum/scores.length);
				break;
			}
			case "5" :{
				status=false;
				System.out.println("프로그램 종료");
				break;
			}
			default: System.out.println("다시 입력해주세요.");
			
			}
		}
		scanner.close();
	}
}
