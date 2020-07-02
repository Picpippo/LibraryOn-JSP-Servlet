package library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import library.form.LoginForm;
import library.util.DBUtil;

public class UserDAO {

	public void Login(HttpSession session) {
		LoginForm loginForm = new LoginForm();
		String email = loginForm.getParameter("email");
		String password = user.getPassword();
		Connection con = DBUtil.getMySqlConnection();
		Statement st = con.createStatement();
		ResultSet rs;
		rs = st.executeQuery(
				"select * from USER where EMAIL='" + email + "' and PASSWORD='" + password + "'");
		if (rs.next()) {
			session.setAttribute("email", email);
			response.sendRedirect("home.jsp");
		} else {
			out.println("Invalid password <a href='login.jsp'>try again</a>");
		}
	}

}
