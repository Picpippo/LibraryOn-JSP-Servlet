package libraryon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryon.form.BookForm;
import libraryon.model.Book;
import utilities.DBUtil;

public class BookDAO {

	/**
	 * create a book and save it in the database
	 * 
	 * @param book, the book that we want create
	 * @throws Exception
	 */
	public static void createBook(BookForm bookForm) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO book (title, author, quantity, editor, position) VALUES (?,?,?,?,?)";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bookForm.getTitle());
			ps.setString(2, bookForm.getAuthor());
			ps.setInt(3, bookForm.getQuantity());
			ps.setString(4, bookForm.getEditor());
			ps.setString(1, bookForm.getPosition());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	
	/**
	 * delete a book in database
	 * 
	 * @param id, the id of the book
	 * @throws Exception
	 */
	public static void deleteBook(Long id) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = "DELETE FROM book WHERE id = ?";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * update a book in database
	 * 
	 * @param id, the id of the book
	 * @throws Exception
	 */
	public static void updateBook(Long id) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE book SET title = ?, author = ?, quantity = ?, editor = ?, position = ?, WHERE id = ?";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * return a list of all books
	 * 
	 * @return, the books list
	 * @throws Exception
	 */
	public static List<Book> bookList() throws Exception {
		
	    List<Book> bookList = new ArrayList();
		
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * FROM book";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return bookList;
	}
}
