package libraryon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	Long id_user;
	Long id_book;
	
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
			createUser(request);
			break;

		case "delete-user":
			deleteUser(request);
			break;

		case "update-user":
			updateUser(request, id_user);
			break;

		case "create-book":
			createBook(request);
			break;

		case "delete-book":
			deleteBook(request);
			break;

		case "update-book":
			updateBook(request, id_book);
			break;

		case "show-books":
			showBooks(request);
			break;

		case "show-users":
			showUsers(request);
			break;

		case "change-pageCB":
			changePageCB(request);
			break;

		case "change-pageCU":
			changePageCU(request);
			break;

		case "change-pageUB":
			id_book = changePageUB(request);
			break;

		case "change-pageUU":
			id_user = changePageUU(request);
			break;
		}

		request.getRequestDispatcher("view/" + page + ".jsp").forward(request, response);

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

		BookForm bookForm = new BookForm();
		bookForm.setTitle(request.getParameter("title"));
		bookForm.setEditor(request.getParameter("editor"));
		bookForm.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		bookForm.setPosition(request.getParameter("position"));
		bookForm.setAuthor(request.getParameter("author"));

		try {
			BookDAO.createBook(bookForm);
			page = "employee";
			System.out.println("giusto");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("sbagliato");
		}
		showBooks(request);
	}

	private void createUser(HttpServletRequest request) {
		UserForm userForm = new UserForm();

		userForm.setName(request.getParameter("name"));
		userForm.setSurname(request.getParameter("surname"));
		userForm.setAddress(request.getParameter("address"));
		userForm.setEmail(request.getParameter("email"));
		userForm.setPassword(request.getParameter("password"));
		System.out.println("stampo form");
		System.out.println(userForm.getName());

		try {
			UserDAO.createUser(userForm);
			page = "administration";
			System.out.println("giusto");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("sbagliato");
		}
		showUsers(request);
	}

	private void deleteBook(HttpServletRequest request) {

		Long id_book = Long.parseLong(request.getParameter("id_book"));

		try {
			BookDAO.deleteBook(id_book);
			page = "employee";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		showBooks(request);

	}

	private void deleteUser(HttpServletRequest request) {

		Long id_user = Long.parseLong(request.getParameter("id_user"));

		try {
			UserDAO.deleteUser(id_user);
			page = "administration";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		showUsers(request);
	}

	private void updateBook(HttpServletRequest request, Long id_book) {
		
		
		BookForm bookForm = new BookForm();
		bookForm.setTitle(request.getParameter("title"));
		bookForm.setEditor(request.getParameter("editor"));
		bookForm.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		bookForm.setPosition(request.getParameter("position"));
		bookForm.setAuthor(request.getParameter("author"));

		try {
			BookDAO bookdao = new BookDAO();
			bookdao.updateBook(bookForm, id_book);
			page = "employee";

		} catch (Exception e) {
			System.out.println(e);
		}
		showBooks(request);
	}

	private void updateUser(HttpServletRequest request,Long id_user) {
		/*
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setAddress(request.getParameter("address"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		*/
		
		UserForm userForm = new UserForm();
		userForm.setName(request.getParameter("name"));
		userForm.setSurname(request.getParameter("surname"));
		userForm.setAddress(request.getParameter("address"));
		userForm.setEmail(request.getParameter("email"));
		userForm.setPassword(request.getParameter("password"));
		
		/*
		request.setAttribute("id_user", user.getId_user());
		request.setAttribute("name", user.getName());
		request.setAttribute("surname", user.getSurname());
		request.setAttribute("address", user.getAddress());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("password", user.getPassword());
		*/
		
		try {
			UserDAO userdao = new UserDAO();
			userdao.updateUser(userForm, id_user);
			page = "administration";

		} catch (Exception e) {
			System.out.println(e);
		}
		showUsers(request);
	}

	private List<User> showUsers(HttpServletRequest request) {
		UserDAO userDAO = new UserDAO();
		List<User> userList = new ArrayList();
		try {
			userList = userDAO.userList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.getSession().setAttribute("userList", userList);

		page = "administration";
		return userList;
	}

	private List<Book> showBooks(HttpServletRequest request) {
		BookDAO bookDAO = new BookDAO();
		List<Book> bookList = new ArrayList();
		try {
			bookList = bookDAO.bookList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.getSession().setAttribute("bookList", bookList);

		page = "employee";
		return bookList;
	}

	private void changePageCB(HttpServletRequest request) {
		page = "createBook";
	}

	private void changePageCU(HttpServletRequest request) {
		page = "createUser";
	}

	private Long changePageUB(HttpServletRequest request) {
		Long id_book = Long.parseLong(request.getParameter("id_book"));

		page = "updateBook";
		return id_book;
	}

	private Long changePageUU(HttpServletRequest request) {
		Long id_user = Long.parseLong(request.getParameter("id_user"));
		page = "updateUser";
		return id_user;
	}
}
