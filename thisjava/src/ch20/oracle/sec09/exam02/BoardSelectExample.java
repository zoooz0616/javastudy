package ch20.oracle.sec09.exam02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelectExample {
	public static void main(String[] args) {
		Connection con=null;
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url,"hr","hr");
			
			String sql="select * from boards where bwriter=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,"winter");
			
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Board board=new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				System.out.println(board);
				
				Blob blob=board.getBfiledata();
				if(blob!=null) {
					InputStream is=blob.getBinaryStream();
					OutputStream os=new FileOutputStream(board.getBfilename());
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();
				}
				
			}
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
