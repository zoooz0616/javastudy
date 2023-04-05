package ch04.test;

import java.util.Scanner;

public class Test8 {
	//다음 지시대로 데이터를 읽는 프로그램을 작성하세요.
	//맨 처음 입력한 숫자는 테스트 케이스입니다.
	//ex 3입력=>3번 반복해야됨.
	//각 테스트별로 입력 데이터의 개수와 그 입력데이터만큼의 데이터가 입력되어야 합니다. 
	//ex 4면 1 2 3 4 처럼.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T=scanner.nextInt()
;
		for (int i = 0; i < T; i++) {
			int sum=0;
			int count=scanner.nextInt();
			for (int j = 0; j < count; j++) {
				int data= scanner.nextInt();
				sum+=data;
			}
			System.out.println("#"+(i+1)+" "+sum);
		
		}
		scanner.close();

}}
