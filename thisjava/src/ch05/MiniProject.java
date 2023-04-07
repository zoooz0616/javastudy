package ch05;

import java.util.Scanner;

//학생 성적 관리 프로그램
public class MiniProject {
	//배열에 저장가능한 고객 최대 수
	//final 붙이면 보통 static 같이 붙임.
	static final int MAX = 15;
	
	
	
	//static으로 선언하여 분리.
	static int[] classList = new int[MAX];//반
	static String[] nameList = new String[MAX]; //이름
	static int[] koreanscoreList = new int[MAX]; //국어 점수
	static int[] mathscoreList = new int[MAX]; //수학 점수
	static int[] englishscoreList = new int[MAX]; //영어 점수
	
	//배열의 인덱스.
	static int index = -1;
	//배열안에 들어있는 데이터 개수.
	static int count = 0;
	
	//고객의 정보를 입력/수정하는 메소드에서 사용하기 때문에 main밖에 static으로 선언.
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while (true) {
			System.out.printf("\n[INFO] 학생 수 : %d\n", count);
			System.out.println("1. 학생 추가 | 2. 전체 성적 조회 | 3. 학생  조회 | 4. 성적 수정 | 5. 성적 삭제 | 6. 종료");
			System.out.print("메뉴를 입력하세요 : ");
			
			int menu = scanner.nextInt();
			scanner.nextLine();
			
			switch (menu) {
			case 1 : {
				if (count>=MAX) {
					System.out.println("더 이상 입력할 수 없습니다.");
				}else {
					insertStudentData();
					System.out.println("고객 정보를 입력했습니다.");
				}
				break;
			}
			case 2: {
				System.out.println("전체 학생의 성적을 조회합니다.");
				
				if (count<=0) {
					System.out.println("데이터가 없습니다.");
				}else {
					printAllStudentData();
					System.out.println("전체 학생의 성적을 조회했습니다.");
				}
				
				break;
			}
			case 3: {
				System.out.println("학생의 성적을 조회합니다.");
				if (count<=0) {
					System.out.println("데이터가 없습니다.");
				}else {
					printStudentData();
					System.out.println("학생의 성적을 조회했습니다.");
				}
				
				break;
			}
			case 4: {
				System.out.println("데이터를 수정합니다.");
				if (0<count) {
					updateCustomerData();
				}else {
					System.out.println("데이터가 선택되지 않았습니다.");
				}
				break;
			}
			case 5: {
				System.out.println("데이터를 삭제합니다.");
				if (count<=0) {
					System.out.println("삭제할 데이터가 존재하지 않습니다.");
				} else {
					deleteStudentData();
					System.out.println("데이터를 삭제했습니다.");
				}
				break;
			}
			case 6: {
				System.out.println("프로그램을 종료합니다.");
				scanner.close();
				System.exit(0);//프로그램 종료
				break;
			}
			default:
				System.out.println("메뉴를 잘못 입력했습니다.");
			}
		}
		
	}
	
	private static void printStudentData() {
		System.out.print("조회할 학생 이름 : ");
		String name = scanner.nextLine();
		
		for (int i = 0; i < count; i++) {
			if (nameList[i].equals(name)) {
				System.out.println("==========STUDENT INFO================");
				System.out.println("반 : "+classList[i]);
				System.out.println("이름 : " + nameList[i]);
				System.out.println("국어 성적 : "+koreanscoreList[i]);
				System.out.println("영어 성적 :	"+englishscoreList[i]);
				System.out.println("수학 성적 :	"+mathscoreList[i]);
				System.out.println("=======================================");
			}else {
				System.out.println("그런 이름은 없습니다.");
			}
		}
	}

	private static void insertStudentData() {
		System.out.print("반 : ");
		classList[count]=scanner.nextInt();
		System.out.print("이름 :");
		nameList[count]=scanner.next();
		System.out.print("국어 성적 :");
		koreanscoreList[count]=scanner.nextInt();
		System.out.print("영어 성적 :");
		englishscoreList[count]=scanner.nextInt();
		System.out.print("수학 성적 :");
		mathscoreList[count]=scanner.nextInt();
		
		count++;
		
	}
	
	private static void printAllStudentData() {
		double[][] avgList=new double[3][MAX];
		
		double min=0;
		int winner=0;
		
		for (int i = 0; i < count; i++) {
			avgList[0][i]=(double)(koreanscoreList[i]+englishscoreList[i]+mathscoreList[i]);
			avgList[1][i]=avgList[0][i]/3;
			
			if (avgList[1][i]>min) {
				min=avgList[1][i];	
				winner=i;
			}
		}
		
		System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 합계 \t 평균 \t 장학금여부");
		for (int i = 0; i < count; i++) {
			int sum=koreanscoreList[i]+englishscoreList[i]+mathscoreList[i];
			double avg=(double)sum/3;
			System.out.printf("%s \t %d \t %d \t %d \t %.0f \t %.0f \t",nameList[i],koreanscoreList[i],englishscoreList[i],mathscoreList[i],avgList[0][i],avgList[1][i]);
			if (i==winner) {
				System.out.print("장학금대상자");	
			}
			System.out.println();
		}
//		System.out.println("==========CUSTOMER INFO================");
//		System.out.println("이름	:	"	+	nameList[index]);
//		System.out.println("성별	:	"	+	genderList[index]);
//		System.out.println("이메일	:	"	+	emailList[index]);
//		System.out.println("출생년도	:	"	+	birthYearList[index]);
//		System.out.println("=======================================");
	}

	
	
	private static void updateCustomerData() {
		System.out.print("수정할 학생 이름 : ");
		String name = scanner.nextLine();
		
		for (int i = 0; i < count; i++) {
			if (nameList[i].equals(name)) {
				System.out.println("==========STUDENT INFO================");
				System.out.print("반 ("+classList[i]+") :");
				classList[i]=scanner.nextInt(); scanner.nextLine();
				System.out.print("이름(" + nameList[i]+") : ");
				nameList[i]=scanner.nextLine();
				System.out.print("국어 성적 ("+koreanscoreList[i]+") : ");
				koreanscoreList[i]=scanner.nextInt();scanner.nextLine();
				System.out.print("영어 성적 ("+englishscoreList[i]+") :");
				englishscoreList[i]=scanner.nextInt();scanner.nextLine();
				System.out.print("수학 성적 ("+mathscoreList[i]+") :");
				mathscoreList[i]=scanner.nextInt();scanner.nextLine();
				System.out.println("=======================================");
			}else {
				//System.out.println("그런 이름은 없습니다.");
			}
		}
	}
	
	private static void deleteStudentData() {
		System.out.print("삭제할 학생 이름 : ");
		String name = scanner.nextLine();
		index=0;
		for (int i = 0; i < count; i++) {
			if (nameList[i].equals(name)) {
				index=i;
			}
			
		}
		
		for (int j = index;j < count-1; j++) {
			classList[j]=classList[j+1];
			nameList[j]=nameList[j+1];
			koreanscoreList[j]=koreanscoreList[j+1];
			englishscoreList[j]=englishscoreList[j+1];
			mathscoreList[j]=mathscoreList[j+1];
		}
		count--;
	}

}
