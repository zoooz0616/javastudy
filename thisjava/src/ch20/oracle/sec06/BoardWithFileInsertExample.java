package ch20.oracle.sec06;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWithFileInsertExample {
	public static void main(String[] args) {
		Connection con=null;
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url,"hr","hr");
			String sql="insert into boards values(SEQ_BNO.NEXTVAL,?,?,?,sysdate,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql,new String[] {"bno"});
			stmt.setString(1,"눈 오는 날");
			stmt.setString(2, "함박눈이 내려요");
			stmt.setString(3, "winter");
			stmt.setString(4, "snow.jpg");
			stmt.setBlob(5,new FileInputStream("snow.jfif"));
			
			int rows=stmt.executeUpdate();
			System.out.println("저장된 행 수:"+rows);
			
			if (rows==1) {
				ResultSet rs=stmt.getGeneratedKeys();
				if (rs.next()) {
					int bno=rs.getInt(1);
					System.out.println("저장된 bno:"+bno);
				}
				rs.close();
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					// TODO: handle exception
				}
				
			}
		}
	}
}
