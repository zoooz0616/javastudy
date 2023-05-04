package miniprj.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO implements IBookDAO{

	@Override
	public int deleteBook(String name, String password) {
		int rowCount=0;
		String sql="delete from book where cust_name=? and pwd=?";
		Connection con=null;
		try {
			con=BookDataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			rowCount=stmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			BookDataSource.closeConnection(con);
		}
		return rowCount;
	}

	@Override
	public int insertBook(Book book) {
		int rowCount=0;
		String sql="insert into book "
				+ "(cust_name, checkin, checkout, room, pwd) values(?,?,?,?,?)";
		Connection con=null;
		try {
			con=BookDataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, book.getName());
			stmt.setString(2, book.getCheckIn());
			stmt.setString(3, book.getCheckOut());
			stmt.setString(4, book.getRoom());
			stmt.setString(5, book.getPassword());
			rowCount=stmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			BookDataSource.closeConnection(con);
		}
		return rowCount;
	}

	@Override
	public int updateBook(Book book) {
		String sql="update book set checkin=?, checkout=?, room=? "
				+ "where cust_name=? and pwd=?";
		int rowCount=0;
		Connection con=null;
		System.out.println(book);
		try {
			con=BookDataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, book.getCheckIn());
			stmt.setString(2, book.getCheckOut());
			stmt.setString(3, book.getRoom());
			stmt.setString(4, book.getName());
			stmt.setString(5, book.getPassword());
			rowCount=stmt.executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			BookDataSource.closeConnection(con);
		}

		return rowCount;
	}
	public boolean login(String name, String password) {
		String sql="select * from book where cust_name=? and pwd=?";
		int rowCount=0;
		Connection con=null;
		try {
			con=BookDataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			if (rs.next()) {
				return true;
			}else{
				System.out.println("일치하는 정보가 없습니다.");
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public int getBookCount() {
		String sql="select count(*) from book";
		int rowCount=0;
		Connection con=null;
		try {
			con=BookDataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			rowCount=rs.getInt(1);
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			BookDataSource.closeConnection(con);
		}
		return rowCount;
	}

	@Override
	public Book getOne(String name, String password) {
		String sql="select * from book where cust_name=? and pwd=?";
		Connection con=null;
		Book book=new Book();
		try {
			con=BookDataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);

			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				book.setName(rs.getString("cust_name"));
				book.setCheckIn(rs.getString("checkin"));
				book.setCheckOut(rs.getString("checkout"));
				book.setRoom(rs.getString("room"));
				book.setPassword(rs.getString("pwd"));
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			BookDataSource.closeConnection(con);
		}
		return book;
	}

	@Override
	public ArrayList<Book> getAllBooks() {
		// TODO Auto-generated method stub
		ArrayList<Book> list = new ArrayList<>();
		String sql = "select * from book";
		Connection con = null;
		
		try {
			con = BookDataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				Book book = new Book();
				book.setName(rs.getString("cust_name"));
				book.setRoom(rs.getString("room"));
				book.setPassword(rs.getString("pwd"));
				book.setCheckIn(rs.getString("checkin"));
				book.setCheckOut(rs.getString("checkout"));
				list.add(book);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			BookDataSource.closeConnection(con);
		}

		return list;

	}


}
