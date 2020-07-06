package libraryon.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import libraryon.dao.BookDAO;
import libraryon.dao.UserDAO;
import libraryon.form.BookForm;
import libraryon.form.LoginForm;
import libraryon.form.UserForm;
import libraryon.model.Book;
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
			login(request);
			break;

		case "create-user":
			break;

		case "delete-user":
			break;

		case "update-user":
			break;

		case "create-book":
			createBook(request);
			break;

		case "delete-book":
			break;

		case "update-book":
			break;
		}

		request.getRequestDispatcher("view" + page + ".jsp").forward(request, response);

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

	private void login(HttpServletRequest request) {
		try {

			LoginForm loginform = new LoginForm();
			loginform.setEmail(request.getParameter("email"));
			loginform.setPassword(request.getParameter("password"));

			loginform = UserDAO.login(loginform);

			if (loginform.isValid()) {

				HttpSession session = request.getSession(true);
				System.out.println("login riuscito");
				page = "home";

			} else {
				page = "login";
				System.out.println("login sbagliato");

			}
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	private void createBook(HttpServletRequest request) {

		Book book = new Book();
		BookForm bookForm = new BookForm();

		book.setAuthor(bookForm.getAuthor());
		book.setTitle(bookForm.getTitle());
		book.setQuantity(bookForm.getQuantity());
		book.setPosition(bookForm.getPosition());
		System.out.println("prova");
		
		try {
			BookDAO.createBook(bookForm);
			page = "createBook";
			System.out.println("giusto");
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("sbagliato");
		}
	}

	private void createUser(HttpServletRequest request) {

		User user = new User();
		UserForm userForm = new UserForm();

		user.setName(userForm.getName());
		user.setSurname(userForm.getSurname());
		user.setAddress(userForm.getAddress());
		user.setEmail(userForm.getEmail());
		user.setEmail(userForm.getEmail());
		System.out.println("prova");

		try {
			UserDAO.createUser(userForm);
			page = "createBook";
			System.out.println("giusto");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("sbagliato");
		}
	}
}
