package ch20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPoolExample {
	private static BasicDataSource dataSource;
	static {
		dataSource=new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		dataSource.setInitialSize(10);//처음 커넥션 수
		dataSource.setMaxTotal(20);//최대 커넥션 수
	}
	public static void main(String[] args) {
		System.out.println(getExmpCount());
	}
	
	public static int getExmpCount() {
		String sql="select count(*) from employees";
		Connection con=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			rs.next();
			rowCount=rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if(con!=null){
				try {con.close();}catch (Exception e) {}
			}
		}
		return rowCount;
	}
}
