package miniprj;

import java.util.List;
import java.util.Scanner;

import miniprj.model.Book;
import miniprj.model.BookDAO;
import miniprj.model.IBookDAO;

public class BookWin {
	static boolean isCustomer;
	   static boolean isAdmin;
	   private static  Scanner scan = new Scanner(System.in);
	   static IBookDAO bookDao = new BookDAO();
	   static String name = null;
	   static String pwd = null;

	   // 호텔 예약 리스트
	   public static void list(Book list) {
	      System.out.printf("%-6s%-12s%-16s%-40s",list.getName(), list.getCheckIn(), list.getCheckOut(), list.getRoom());
	      System.out.println();
	   }

	   public static void mainMenu() {
	      System.out.println();
	      System.out.println("--------------------------------------------------------");
	      System.out.println("메인메뉴: 1.예약 | 2.조회 | 3.수정 | 4.삭제 | 5.로그아웃 | 6.종료");
	      System.out.print("메뉴선택: ");
	      String menuNo = scan.nextLine();
	      System.out.println();

	      switch(menuNo) {
	      case "1" -> {
	         Book book = new Book();

	         System.out.print("예약자: ");
	         book.setName(scan.nextLine());
	         System.out.print("체크인 날짜: ");
	         book.setCheckIn(scan.nextLine());
	         System.out.print("체크아웃 날짜: ");
	         book.setCheckOut(scan.nextLine());
	         System.out.print("객실: ");
	         book.setRoom(scan.nextLine());
	         System.out.print("비밀번호: ");
	         book.setPassword(scan.nextLine());

	         bookDao.insertBook(book);
	         break;
	      }

	      case "2" -> {
	         System.out.println("[호텔 예약관리 시스템]");
	         System.out.println("--------------------------------------------------------");
	         System.out.printf("%-6s%-12s%-16s%-40s", "성함","체크인 날짜","체크아웃 날짜","객실");
	         System.out.println();
	         System.out.println("--------------------------------------------------------");
	         if (isAdmin) {
	            List<Book> list = bookDao.getAllBooks();
//	            System.out.println(list);
	            for(int i=0;i<list.size();i++) {
	               list(list.get(i));
	            }
	         } else if(isCustomer) {
	            Book book = bookDao.getInfo(name, pwd);
	            list(book);
	         }
	         mainMenu();
	         break;
	      }

	      case "3" -> {
	    	  if(name.equals("admin")) {
	    		 System.out.println("관리자는 수정이 불가합니다.");
	    		 mainMenu();
	    		 break;
	    	  }
	         Book book = bookDao.getInfo(name, pwd);

	         System.out.print("체크인 날짜: ");
	         book.setCheckIn(scan.nextLine());
	         System.out.print("체크아웃 날짜: ");
	         book.setCheckOut(scan.nextLine());
	         System.out.print("객실: ");
	         book.setRoom(scan.nextLine());

	         bookDao.updateBook(book);
	         mainMenu();
	         break;

	      }
	      case "4" -> {
	    	 if(name.equals("admin")) {
	    		 System.out.println("관리자는 예약 취소가 불가능합니다.");
	    		 mainMenu();
	    		 break;
	    	 } else {
	    		 Book onesBook = bookDao.getInfo(name, pwd);
		         if(!onesBook.getName().equals(name)) {
		            System.out.println("예약건이 없습니다.");
		            break;
		         } 

		         int rowCount = bookDao.deleteBook(name, pwd);
		         System.out.println(rowCount + "건의 에약이 취소되었습니다.");
		         mainMenu();
		         break;
	    	 }
	         
	      }
	      case "5" -> {
	         isAdmin = false;
	         isCustomer = false;
	         name = null;
	         pwd = null;
	         loginMenu();
	         break;
	      }
	      case "6" -> {
	         System.out.println("프로그램이 종료되었습니다.");
	         System.exit(0);
	      }
	      }
	   }

	   public static boolean loginMenu() {
	      System.out.println();
	      System.out.println("--------------------------------------------------------");
	      System.out.print("성함을 입력하세요: ");
	      name = scan.nextLine();
	      System.out.print("비밀번호를 입력하세요: ");
	      pwd = scan.nextLine();

	      if(name.equals("admin") && pwd.equals("admin")) {
	         isAdmin = true;
	         mainMenu();
	         return true;
	      } else if(bookDao.login(name, pwd)){
	         isCustomer = true;
	         mainMenu();
	         return true;
	      } else {

	         System.out.println("회원정보가 일치하지 않습니다.");
	         loginMenu();
	         return false;
	      }


	   }
	   
	   public static void firstMenu() {
		   System.out.println();
		      System.out.println("--------------------------------------------------------");
		      System.out.println("메인메뉴: 1.예약 | 2.로그인");
		      System.out.print("메뉴선택: ");
		      String menuNo = scan.nextLine();
		      System.out.println();
		      
		   switch (menuNo) {
			case "1": {
				Book book = new Book();

		         System.out.print("예약자: ");
		         book.setName(scan.nextLine());
		         System.out.print("체크인 날짜: ");
		         book.setCheckIn(scan.nextLine());
		         System.out.print("체크아웃 날짜: ");
		         book.setCheckOut(scan.nextLine());
		         System.out.print("객실: ");
		         book.setRoom(scan.nextLine());
		         System.out.print("비밀번호: ");
		         book.setPassword(scan.nextLine());

		         bookDao.insertBook(book);
		         break;
			}
			case "2": {
				loginMenu();
				break;
			}
			}

		   }

	   public static void main(String[] args) {
		   firstMenu();
	   }

}
