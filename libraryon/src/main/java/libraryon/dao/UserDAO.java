package libraryon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import libraryon.form.LoginForm;
import libraryon.form.UserForm;
import libraryon.model.User;
import utilities.DBUtil;

public class UserDAO {
	
	static Connection conn = null;
	static ResultSet rs = null;

	/**
	 * method that allows you to access the site only if you are registered
	 * 
	 * @param loginform, the form where we insert the user fields
	 * @return
	 */
	public static LoginForm login(LoginForm loginform) {
		
		Statement stmt = null;

		String email = loginform.getEmail();
		String password = loginform.getPassword();

		String searchQuery = "select * from user where email='" + email + "' AND password='" + password + "'";

		try {
			
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			if (!more) {
				loginform.setValid(false);
			}

			else if (more) {
				System.out.println("Welcome ");
				loginform.setValid(true);
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}

				conn = null;
			}
		}

		return loginform;

	}

	/**
	 * create a user and save it in the database
	 * 
	 * @param user, the user that we want create
	 * @throws Exception
	 */
	public static void createUser(UserForm userForm) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO user (name, surname, address, email, password, nLoan) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userForm.getName());
			ps.setString(2, userForm.getSurname());
			ps.setString(3, userForm.getAddress());
			ps.setString(4, userForm.getEmail());
			ps.setString(5, userForm.getPassword());
			ps.setInt(6, userForm.getnLoan());
			System.out.println(userForm.getName());

			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * method that shows the list of all users
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<User> userList() throws Exception {

		List<User> userList = new ArrayList();

		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * FROM user";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId_user(rs.getLong("id_user"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

				userList.add(user);
			}
			System.out.println(ps);
			ps.close();
			conn.close();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}

		return userList;
	}

	/**
	 * method that delete a user in database
	 * 
	 * @param id_user
	 * @throws Exception
	 */
	public static void deleteUser(Long id_user) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "DELETE FROM user WHERE id_user = ?";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id_user);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * method that update a user in database
	 * 
	 * @param userForm, the form where we insert the user fields
	 * @param id_user, the id of the user that we want update
	 * @throws Exception
	 */
	public static void updateUser(UserForm userForm, Long id_user) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE user SET name = ?, surname = ?, address = ?, email = ?, password = ? WHERE id_user = ?";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userForm.getName());
			ps.setString(2, userForm.getSurname());
			ps.setString(3, userForm.getAddress());
			ps.setString(4, userForm.getEmail());
			ps.setString(5, userForm.getPassword());
			ps.setLong(6, id_user);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * method that update a loan in database
	 * 
	 * @param user, the user having the loan
	 * @param id_user, the id of the user
	 * @throws Exception
	 */
	public static void UpdatenLoan(User user, Long id_user) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE user SET nLoan = ? WHERE id_user = ?";
		PreparedStatement ps = null;

		try {
			System.out.println("stampo oggetto");
			System.out.println(user.getnLoan());
			System.out.println(id_user);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getnLoan());
			ps.setLong(2, id_user);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
