package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
	public static void main(String[] args) {
		//1. connection 객체 생성
		//2. statement 객체 생성
		//3. sql구문 실행
		//4. 결과 소비
		Connection con= null;
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"hr","hr");
			System.out.println(con);
			//데이터 삽입
			String sql ="insert into employees values (?,?,?,?,?, sysdate, ?,?, ?, ?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 301);
			stmt.setString(2, "JinYoung");
			stmt.setString(3, "Kim");
			stmt.setString(4, "jin@gmail.com");
			stmt.setString(5, "010-3333-3333");
			stmt.setString(6, "IT_PROG");
			stmt.setDouble(7, 8000);
			stmt.setDouble(8, 0);
			stmt.setInt(9, 103);
			stmt.setInt(10,60);
			stmt.executeUpdate();//insert,update,delete 는 executeUpdate(). select는 executeQuary()로
			System.out.println("데이터가 입력됐습니다.");
			
//			데이터 가져와서 읽기
			Statement stmt2=con.createStatement();
			ResultSet rs = stmt2.executeQuery("select * from employees");
			while(rs.next()) {
				System.out.print(rs.getInt("employee_id")+"\t");
				System.out.print(rs.getString("first_name")+"\t");
				System.out.print(rs.getString("last_name")+"\t");
				System.out.println(rs.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try{con.close();}catch (Exception e) {}
		}
		
	}
}
