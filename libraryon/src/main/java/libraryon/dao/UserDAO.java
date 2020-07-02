package libraryon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libraryon.form.LoginForm;
import utilities.DBUtil;



public class UserDAO {

	public void Login(LoginForm LoginForm) throws Exception{

		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * FROM user WHERE email = ? AND  password = ?";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
