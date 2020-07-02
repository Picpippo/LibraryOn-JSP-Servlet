package libraryon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import libraryon.dao.UserDAO;
import libraryon.form.LoginForm;
import libraryon.model.Loan;
import libraryon.model.User;

@WebServlet("*.do")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User user;
	Loan loan;

	public LibraryServlet() {
		super();
	}

	String page = "";

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		page = "";
		String path = request.getServletPath();
		String comand = path.substring(1, path.lastIndexOf(".do"));

		switch (comand) {
		case "create-loan":
			break;

		case "update-loan":
			break;

		case "delete-loan":
			break;

		case "login":
			login(request, response);
			break;

		case "create-user":
			break;

		case "delete-user":
			break;

		case "update-user":
			break;

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	private void createLoan(HttpServletRequest request) {
		loan = new Loan();
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {

			LoginForm loginform = new LoginForm();
			loginform.setEmail(request.getParameter("email"));
			loginform.setPassword(request.getParameter("password"));

			loginform = UserDAO.login(loginform);

			if (loginform.isValid()) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", loginform);
				response.sendRedirect("home.jsp"); // logged-in page
			}

			else
				System.out.println("Sbagliato!");
				response.sendRedirect("login.jsp"); // error page
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
