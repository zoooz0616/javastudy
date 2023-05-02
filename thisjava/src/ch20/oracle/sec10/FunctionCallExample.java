package ch20.oracle.sec10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionCallExample {
	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"hr","hr");
			
			String sql="{? = call user_login(?,?)}";
			CallableStatement stmt=con.prepareCall(sql);
			
			stmt.registerOutParameter(1,Types.INTEGER);
			stmt.setString(2, "winter");
			stmt.setNString(3, "12345");
			
			stmt.execute();
			int result=stmt.getInt(1);
			stmt.close();
			
			String message=switch (result) {
			case 0 -> "로그인 성공";
			case 1 -> "비밀번호가 틀림";
			default -> "아이디가 존재하지 않음";
			};
			System.out.println(message);
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try{con.close();}catch(SQLException e) {}
		}
	}
}
