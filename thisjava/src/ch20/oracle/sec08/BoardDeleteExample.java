package ch20.oracle.sec08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BoardDeleteExample {
	public static void main(String[] args) {
		Connection con=null;
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url,"hr","hr");
			
			String sql="delete from boards where bwriter=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setNString(1,"winter");
			
			int rows = stmt.executeUpdate();
			System.out.println("삭제된 행 수:"+rows);
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
