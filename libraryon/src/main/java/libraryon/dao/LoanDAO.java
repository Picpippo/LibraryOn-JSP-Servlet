package libraryon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryon.form.BookForm;
import libraryon.form.LoanForm;
import libraryon.model.Loan;
import utilities.DBUtil;

public class LoanDAO {

	/**
	 * create a loan and save it in the database
	 * 
	 * @param loanForm, the loan that we want create
	 * @throws Exception
	 */
	public static void createLoan(LoanForm loanForm, Long id_book) throws Exception {
		
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO loan (id_user, id_book, assignment_date, expiration_date, state) VALUES (?,?,?,?,?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id_book);
			ps.setLong(2, loanForm.getId_user());
			ps.setString(3, loanForm.getAssignment_date());
			ps.setString(4, loanForm.getExpiration_date());
			ps.setString(5, loanForm.getState());
			
			ps.executeUpdate();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());	
		}
	}

	
	/**
	 * delete a loan in database
	 * 
	 * @param id, the id of the loan
	 * @throws Exception
	 */
	public static void deleteLoan(Long id_loan) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "DELETE FROM loan WHERE id_loan = ?";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id_loan);
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
	public static List<Loan> loanList() throws Exception {
		
	    List<Loan> loanList = new ArrayList();
		LoanDAO loanDAO = new LoanDAO();
	    
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * FROM loan";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Loan loan = new Loan();
				loan.setId_loan(rs.getLong("id_loan"));
				loan.setId_book(rs.getLong("id_book"));
				loan.setId_user(rs.getLong("id_user"));
				loan.setAssignment_date(rs.getString("assignment_date"));
				loan.setExpiration_date(rs.getString("expiration_date"));
				loan.setState(rs.getString("state"));
			
				loanList.add(loan);
			}
			System.out.println(ps);
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	
		return loanList;
	}
	
	/**
	 * method that update a loan in database
	 * 
	 * @param loanForm, the form where we insert the loan fields
	 * @param id_loan, the id of the loan that we want update
	 * @throws Exception
	 */
	public static void updateLoan (LoanForm loanForm, Long id_loan) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE loan SET state = ? WHERE id_loan = ?";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, loanForm.getState());
			ps.setLong(2, id_loan);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
