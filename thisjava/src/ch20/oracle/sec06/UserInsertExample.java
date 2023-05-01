package ch20.oracle.sec06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertExample {
	public static void main(String[] args) {
		Connection con=null;
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"hr","hr");
			
			String sql="insert into users values(?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,"winter");
			stmt.setString(2,"한겨울");
			stmt.setString(3,"12345");
			stmt.setInt(4,25);
			stmt.setString(5,"winter@mycompany.com");
			
			int rows = stmt.executeUpdate();
			System.out.println("저장된 행 수 :"+rows);
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
