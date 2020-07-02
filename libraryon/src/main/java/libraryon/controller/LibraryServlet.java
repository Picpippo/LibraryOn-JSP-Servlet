package libraryon.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libraryon.model.Loan;
import libraryon.model.User;

/**
 * Servlet implementation class LibraryServlet
 */
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
	
}
