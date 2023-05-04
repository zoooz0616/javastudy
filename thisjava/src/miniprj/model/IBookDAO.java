package miniprj.model;

import java.util.ArrayList;

public interface IBookDAO {
	public int deleteBook(String name, String password);
	public int insertBook(Book book);
	public int updateBook(Book book);
	
	public int getBookCount();
	public Book getOne(String name, String password);
	public ArrayList<Book> getAllBooks();
}