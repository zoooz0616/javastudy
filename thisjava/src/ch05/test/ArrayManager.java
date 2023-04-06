package ch05.test;

import java.util.Scanner;

public class ArrayManager {

	public static void main(String[] args) {
//		이	예제는	정수를	저장하는	배열을	생성합니다.
		int[] array = new int[10];
		//배열 인덱스 초기값
		int index=-1;
		//배열에 저장된 개수
		int count=0;
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("*************배열 관리 프로그램*************");
		while(true) {
			System.out.println("------------------------------------------------");
			System.out.println("1.추가 | 2.출력 | 3.조회 | 4.수정 | 5.삭제 | 6.삽입 | 7.종료");
			System.out.println("-------------------------------------------------");
			
			System.out.println("메뉴 : ");
			int menu=scanner.nextInt();
					
			switch (menu) {
			case 1: {
				System.out.print("배열에 추가할 데이터:");
				int inputData =	scanner.nextInt();
				array[count] =	inputData;
				count++;
				break;
			}
			case 2:
				System.out.println("배열의 데이터를 출력합니다.");
				for(int i=0; i<count; i++)	{
				System.out.print(array[i]+"\t");
				}
				System.out.println();
				break;
			case 3:
				System.out.print("배열에서	찾을	데이터:");
				int searchData = scanner.nextInt();
				for(int i=0; i<count; i++)	{
					if(array[i]	==	searchData)	{
						System.out.println(i+"위치에서	데이터 찾음");
					}
				}
				break;
			case 4:
				System.out.print("수정할 위치와 데이터 입력(예 : 2 30):");
				index	=	scanner.nextInt();
				int updateData	=	scanner.nextInt();
				array[index]	=	updateData;
				break;
			case 5:
				System.out.print("삭제할 위치 입력:	");
				index	=	scanner.nextInt();
				int deletedData	=	array[index];
				System.out.printf("%d 위치의 데이터 %d 삭제\n",index,deletedData);
				for(int i=index;	i<count-1;	i++)	{
				array[i]	=	array[i+1];
				}
				count--;
				break;
			case 6:
				System.out.print("삽입할 위치와 데이터	입력(예: 2 30):");
				index	=	scanner.nextInt();
				int insertData	=	scanner.nextInt();
				for(int i=count;	i>index;	i--)	{
				array[i]	=	array[i-1];
				}
				array[index]	=	insertData;
				count++;
				break;
			case 0:
				scanner.close();
				System.out.println("배열 관리 프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}
}
