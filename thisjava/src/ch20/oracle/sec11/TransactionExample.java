package ch20.oracle.sec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"hr","hr");
			
			con.setAutoCommit(false);
			
			String sql1="update accounts set balance=balance-? where ano=?";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setInt(1,10000);
			stmt1.setString(2, "111-111-1111");
			int rows=stmt1.executeUpdate();
			if(rows==0) throw new Exception("출금되지 않았음");
			stmt1.close();
			
			String sql2="update accounts set balance=balance+? where ano=?";
			PreparedStatement stmt2=con.prepareStatement(sql2);
			stmt2.setInt(1,10000);
			stmt2.setString(2, "222-222-2222");
			int rows2=stmt2.executeUpdate();
			if(rows2==0) throw new Exception("입금되지 않았음");
			stmt2.close();
			
			con.commit();
			System.out.println("계좌이체 성공");
			
			
			
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("계좌 이체 실패");
				e.printStackTrace();
			}finally {
				if(con!=null) {
					try {
						con.setAutoCommit(true);
						con.close();
					} catch (SQLException e3) {
						// TODO: handle exception
					}
				}
			}
		}
	}
}
