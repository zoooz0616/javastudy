package ch20.oracle.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class BoardExample {
	//매개변수
	private static Scanner scanner = new Scanner(System.in);
	private static Connection con=null;
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	
			
	public static void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("--------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n","no","writer","date","title");
		System.out.println("--------------------------------------------------");
		
		try {
			String sql="select * from boards order by bno desc";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBDate(rs.getDate("bdate"));
				System.out.printf("%-6s%-12s%-16s%-40s\n", 
						board.getBno(), board.getBwriter(),board.getBDate(),board.getBtitle());
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		mainMenu();
	}
	
	public static void mainMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println("메인 메뉴 : 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1 -> create();
		case 2 -> read();
		case 3 -> clear();
		case 4 -> exit();
		default -> System.out.println("메뉴를 잘못 입력함.");
		}
	}
	
	private static void exit() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		System.out.println("***게시판 종료***");
		System.exit(0);
	}
	
	private static void clear() {
		System.out.println("[게시물 전체 삭제]");
		System.out.println("--------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		int menu=scanner.nextInt();
		scanner.nextLine();
		if(menu==1) {
			try {
				String sql="truncate table boards";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.executeUpdate();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}
	private static void read() {
		System.out.println("[게시물 읽기");
		System.out.print("bno: ");
		int no=scanner.nextInt();
		scanner.nextLine();
		try {
			String sql="select * from boards where bno = ?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, no);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBDate(rs.getDate("bdate"));
				System.out.println("#############");
				System.out.println("번호: "+board.getBno());
				System.out.println("제목: "+board.getBtitle());
				System.out.println("내용: "+board.getBcontent());
				System.out.println("작성자: "+board.getBwriter());
				System.out.println("날짜: "+board.getBDate());
			
				System.out.println("--------------------------------------------------");
				System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
				System.out.print("메뉴 선택: ");
				int menu=scanner.nextInt();
				scanner.nextLine();

				if(menu==1) {
					update(board);
				}else if(menu==2) {
					delete(board);
				}
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		
		list();
	}
	
	public static void update(Board board) {
		System.out.println("[수정 내용 입력]");
		System.out.print("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scanner.nextLine());
		System.out.print("작성자: ");
		board.setBwriter(scanner.nextLine());
		
		System.out.println("--------------------------------------------------");
		System.out.println("보조 메뉴: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택: ");
		int menu=scanner.nextInt();
		
		if(menu==1) {
			try {
				String sql="update boards set btitle=?, bcontent=?, bwriter=? where bno=?";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1, board.getBtitle());
				stmt.setString(2, board.getBcontent());
				stmt.setString(3, board.getBwriter());
				stmt.setInt(4, board.getBno());
				stmt.executeUpdate();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}
	public static void delete(Board board) {
		try {
			String sql="delete from boards where bno=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, board.getBno());
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		list();
		
	}
	
	private static void create() {
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scanner.nextLine());
		System.out.print("작성자: ");
		board.setBwriter(scanner.nextLine());
		
		System.out.println("--------------------------------------------------");
		System.out.println("보조 메뉴: 1.OK | 2.Cancel");
		System.out.print("메뉴 선택: ");
		int menu=scanner.nextInt();

		if(menu==1) {
			try {
				String sql="insert into boards (bno, btitle, bcontent, bwriter, bdate)"
						+ " values(SEQ_BNO.NEXTVAL,?,?,?,sysdate)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				exit();
			}
		}
		list();
	}
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,"hr","hr");
			
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		} finally {
			list();
		}
		
		
	}
}
