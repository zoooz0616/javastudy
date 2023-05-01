package ch20.oracle.sec09.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserSelectExample {
	public static void main(String[] args) {
		Connection con=null;
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url,"hr","hr");
			
			String sql="select * from users where userid=?";
			
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, "winter");
			
			ResultSet rs=stmt.executeQuery();
			if (rs.next()) {
				User user= new User();
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				user.setUserAge(rs.getInt(4));
				user.setUserEmail(rs.getString(5));
				System.out.println(user);
			}else {
				System.out.println("사용자 아이디가 존재하지 않음");
			}
			
			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
