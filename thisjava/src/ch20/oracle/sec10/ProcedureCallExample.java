package ch20.oracle.sec10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureCallExample {
	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"hr","hr");
			
			String sql="{call user_create(?,?,?,?,?,?)}";
			CallableStatement stmt=con.prepareCall(sql);
			
			stmt.setString(1,"Summer");
			stmt.setString(2,"한여름");
			stmt.setString(3, "12345");
			stmt.setInt(4, 26);
			stmt.setString(5, "summer@my.com");
			stmt.registerOutParameter(6, Types.INTEGER);
			
			stmt.execute();
			
			int rows=stmt.getInt(6);
			System.out.println("저장된 행 수: "+rows);
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {con.close();}catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
}
