package ch20.oracle.sec07;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
	public static void main(String[] args) {
		Connection con=null;
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url,"hr","hr");
			
			String sql=new StringBuilder()
					.append("update boards set ")
					.append("btitle=?,")
					.append("bcontent=?,")
					.append("bfilename=?,")
					.append("bfiledata=? ")
					.append("where bno=?")
					.toString();
			
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,"눈사람");
			stmt.setString(2, "눈으로 만든 사람");
			stmt.setString(3, "snowman.jpg");
			stmt.setBlob(4,new FileInputStream("snow.jfif"));
			stmt.setInt(5, 1);
			
			int rows=stmt.executeUpdate();
			System.out.println("수정된 행 수: "+rows);
			
			stmt.close();
			
			
		} catch (Exception e) {
			// TODO: hande exception
			e.printStackTrace();
		} finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					
				}
			}
		}
	}
}
