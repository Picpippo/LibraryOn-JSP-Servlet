package libraryon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libraryon.form.LoginForm;
import utilities.DBUtil;

public class UserDAO {
	static Connection conn = null;
	static ResultSet rs = null;

	public static LoginForm login(LoginForm loginform) {

		// preparing some objects for connection
		Statement stmt = null;

		String email = loginform.getEmail();
		String password = loginform.getPassword();

		String searchQuery = "select * from user where email='" + email + "' AND password='" + password + "'";

// "System.out.println" prints in the console; Normally used to trace the process
		System.out.println("Your user name is " + email);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				loginform.setValid(false);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				System.out.println("Welcome ");
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

//some exception handling
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
}
