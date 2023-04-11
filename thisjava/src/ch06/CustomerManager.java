package ch06;

import java.util.Scanner;

public class CustomerManager {
	//배열에 저장가능한 고객 최대 수
	//final 붙이면 보통 static 같이 붙임.
	static final int MAX = 100;
	
	static Customer[] custList = new Customer[MAX];
	
	//배열의 인덱스.
	static int index = -1;
	//배열안에 들어있는 데이터 개수.
	static int count = 0;
	
	//고객의 정보를 입력/수정하는 메소드에서 사용하기 때문에 main밖에 static으로 선언.
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while (true) {
			System.out.printf("\n[INFO] 고객 수 : %d, 인덱스 : %d\n", count, index);
			System.out.println("(A)ppend, (I)nsert, (P)revious, (N)ext, (C)urrent, (U)pdate, (D)delete, (Q)uit");
			System.out.print("메뉴를 입력하세요 : ");
			
			String menu = scanner.next();
			menu=menu.toLowerCase();//입력한 문자를 모두 소문자로 변환.
			
			
			switch (menu.charAt(0)) {
			case 'i' : {
				if (count>=MAX) {
					System.out.println("더 이상 입력할 수 없습니다.");
				}else {
					insertCustomerData();
					System.out.println("고객 정보를 입력했습니다.");
				}
				break;
			}
			case 'a': {
				System.out.println("고객정보 입력을 시작합니다.");
				
				if (count>=MAX) {
					System.out.println("더 이상 입력할 수 없습니다.");
				}else {
					appendCustomerData();
					System.out.println("고객 정보를 입력했습니다.");
				}
				
				break;
			}
			case 'p': {
				System.out.println("이전 데이터를 출력합니다.");
				if (index<=0) {
					System.out.println("이전 데이터가 존재하지 않습니다.");
				} else {
					index--;
					printCustomerInfo();
				}
				break;
			}
			case 'n': {
				System.out.println("다음 데이터를 출력합니다.");
				if (index>=count-1) {
					System.out.println("다음 데이터가 존재하지 않습니다.");
				} else {
					index++;
					printCustomerInfo();
				}
				break;
			}
			case 'c': {
				System.out.println("현재 데이터를 출력합니다.");
				if ((index>=0 && index<count)) {
					printCustomerInfo();
				} else {
					System.out.println("데이터가 선택되지 않았습니다.");
				}
				break;
			}
			case 'u': {
				System.out.println("데이터를 수정합니다.");
				if ((index>=0)&&(index<count)) {
					System.out.println(index+"번째 데이터를 수정하겠습니다.");
					updateCustomerData();
				}else {
					System.out.println("데이터가 선택되지 않았습니다.");
				}
				break;
			}
			case 'd': {
				System.out.println("데이터를 삭제합니다.");
				if ((index>=0)&&(index<count)) {
					System.out.println(index +"번째 데이터를 삭제합니다.");
					deleteCustomerData();
				} else {
					System.out.println("데이터가 선택되지 않았습니다.");
				}
				break;
			}
			case 'q': {
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
	
	private static void insertCustomerData() {
		Customer customer = new Customer();
		
		System.out.print("이름 :");
		customer.setNameString(scanner.next());
		System.out.print("성별(M/F) :");
		customer.setGender(scanner.next().charAt(0));
		System.out.print("이메일 :");
		customer.setEmailString(scanner.next());
		System.out.print("출생년도 :");
		customer.setBirthYear(scanner.nextInt());
		
		custList[count++]=customer;
	}
	
	private static void appendCustomerData() {
		Customer customer = new Customer();
		
		System.out.print("이름 :");
		customer.setNameString(scanner.next());
		System.out.print("성별(M/F) :");
		customer.setGender(scanner.next().charAt(0));
		System.out.print("이메일 :");
		customer.setEmailString(scanner.next());
		System.out.print("출생년도 :");
		customer.setBirthYear(scanner.nextInt());
		
		custList[count++]=customer;
		
	}
	
	private static void printCustomerInfo() {
		Customer customer=custList[index];
		System.out.println("==========CUSTOMER INFO================");
		System.out.println("이름	:	"	+ customer.getNameString());
		System.out.println("성별	:	"	+ customer.getGender());
		System.out.println("이메일	:	"	+ customer.getEmailString());
		System.out.println("출생년도	:	"	+ customer.getBirthYear());
		System.out.println("=======================================");
	}
	
	private static void updateCustomerData() {
		System.out.println("----------UPDATE CUSTOMER INFO-----------");
		
		Customer customer = custList[index];
		
		System.out.print("이름("+customer.getNameString()+") :");
		customer.setNameString(scanner.next());
		System.out.print("성별("+customer.getGender()+") :");
		customer.setGender(scanner.next().charAt(0));
		System.out.print("이메일("+customer.getEmailString()+") :");
		customer.setEmailString(scanner.next());
		System.out.print("출생년도("+customer.getBirthYear()+") :");
		customer.setBirthYear(scanner.nextInt());
	}
	
	private static void deleteCustomerData() {
		for (int i = index; i < count-1; i++) {
			custList[i]=custList[i+1];
//			nameList[index]=nameList[index+1];
//			genderList[i]	=	genderList[i+1];
//			emailList[i]	=	emailList[i+1];
//			birthYearList[i]	=	birthYearList[i+1];
		}
		count--;
	}

}
