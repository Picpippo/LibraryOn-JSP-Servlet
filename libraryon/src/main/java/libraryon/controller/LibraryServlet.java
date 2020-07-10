package libraryon.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import libraryon.dao.BookDAO;
import libraryon.dao.LoanDAO;
import libraryon.dao.RoleDAO;
import libraryon.dao.UserDAO;
import libraryon.form.BookForm;
import libraryon.form.LoanForm;
import libraryon.form.LoginForm;
import libraryon.form.RoleForm;
import libraryon.form.UserForm;
import libraryon.model.Book;
import libraryon.model.Loan;
import libraryon.model.Role;
import libraryon.model.User;

@WebServlet("*.do")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<User> ul = new ArrayList();
	List<Book> bookList = new ArrayList();
	Loan loan;
	UserForm uf;
	Long id_book;
	Long id_loan;
	Long id_user;
	Long id_role;
	int nLoan = 0;
	User us = new User();

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
			createLoan(request, id_book, bookList, ul);
			break;

		case "create-role":
			createRole(request, id_user);
			break;

		case "update-role":
			updateRole(request, id_role);
			break;

		case "update-loan":
			updateLoan(request, id_loan);
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

		case "change-pageLOAN":
			id_book = changePageLOAN(request);
			break;

		case "create-book":
			createBook(request);
			break;

		case "delete-book":
			deleteBook(request);
			break;

		case "delete-loan":
			deleteLoan(request, ul);
			break;

		case "delete-role":
			deleteRole(request);
			break;

		case "update-book":
			updateBook(request, id_book);
			break;

		case "show-books":
			bookList = showBooks(request);
			break;

		case "show-role":
			showRole(request);
			break;

		case "show-users":
			ul = showUsers(request);
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

		case "change-pageLL":
			changePageLL(request);
			break;

		case "change-pageUL":
			id_loan = changePageUL(request);
			break;

		case "change-pageCR":
			id_user = changePageCR(request);
			break;

		case "change-pageUR":
			id_role = changePageUR(request);
			break;

		case "back-home":
			backHome(request);
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

		doGet(request, response);
	}

	/**
	 * method that allows you to access the site only if you are registered
	 * 
	 * @param request
	 */
	private void login(HttpServletRequest request) {
		try {

			LoginForm loginform = new LoginForm();
			loginform.setEmail(request.getParameter("email"));
			loginform.setPassword(request.getParameter("password"));

			loginform = UserDAO.login(loginform);

			if (loginform.isValid()) {

				HttpSession session = request.getSession(true);
				page = "home";

			} else {
				page = "login";
			}
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	/**
	 * method that create a book in database
	 * 
	 * @param request
	 */
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

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		showBooks(request);
	}

	/**
	 * method that create a user in database
	 * 
	 * @param request
	 */
	private void createUser(HttpServletRequest request) {
		UserForm userForm = new UserForm();

		userForm.setName(request.getParameter("name"));
		userForm.setSurname(request.getParameter("surname"));
		userForm.setAddress(request.getParameter("address"));
		userForm.setEmail(request.getParameter("email"));
		userForm.setPassword(request.getParameter("password"));
		userForm.setnLoan(0);
		try {
			UserDAO.createUser(userForm);
			page = "administration";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		showUsers(request);
	}

	/**
	 * method that create a loan in database
	 * 
	 * @param request
	 * @param id_book,  the id of the book
	 * @param listBook, the list where the book is located
	 */
	private void createLoan(HttpServletRequest request, Long id_book, List<Book> listBook, List<User> listUser) {

		LoanForm loanForm = new LoanForm();
		Long indexId;
		int id_user = 0;
		indexId = Long.parseLong(request.getParameter("id_user"));
		id_user = Integer.parseInt(request.getParameter("id_user"));
		loanForm.setId_user(Long.parseLong(request.getParameter("id_user")));

		for (User user : listUser) {
			if (user.getId_user() == indexId) {
				us = listUser.get(id_user);
			} else {
				indexId++;
			}
		}

		if (us.getnLoan() == 0) {
			System.out.println("sto nell' if");
			nLoan = us.getnLoan();
			nLoan++;
			us.setnLoan(nLoan);
			try {
				System.out.println("sto nel try");
				if (us.getnLoan() < 5) {
					UserDAO.UpdatenLoan(us, indexId);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			nLoan++;
			us.setnLoan(nLoan);
			try {
				UserDAO.UpdatenLoan(us, indexId);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(nLoan);
		System.out.println(us.getnLoan());

		/*
		 * String date = request.getParameter("assignment_date"); try { Date dated = new
		 * SimpleDateFormat("dd-MM-yyyy").parse(date); } catch (ParseException e) {
		 * System.out.println(e); }
		 */

		loanForm.setAssignment_date(request.getParameter("assignment_date"));
		loanForm.setExpiration_date(request.getParameter("expiration_date"));
		loanForm.setState(request.getParameter("state"));

		try {

			if (us.getnLoan() < 5) {
				LoanDAO.createLoan(loanForm, id_book);
				quantityMinus(request, listBook, id_book);
				page = "employee";
				System.out.println("giusto");
			} else {
				System.out.println("limit of loans reached");
				page = "home";
			}

			quantityMinus(request, listBook, id_book);
			page = "employee";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		showBooks(request);
	}

	/**
	 * method that create a role
	 * 
	 * @param request
	 * @param id_user, the id of the user
	 */
	private void createRole(HttpServletRequest request, Long id_user) {

		RoleForm roleForm = new RoleForm();
		roleForm.setId_profile(Long.parseLong(request.getParameter("id_profile")));
		try {
			RoleDAO.createRole(roleForm, id_user);
			page = "role";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		showRole(request);
	}

	/**
	 * method that delete a book in database
	 * 
	 * @param request
	 */
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

	/**
	 * method that delete a user in database
	 * 
	 * @param request
	 */
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

	/**
	 * method that delete a loan in database
	 * 
	 * @param request
	 */
	private void deleteLoan(HttpServletRequest request, List<User> listUser) {

		Long id_loan = Long.parseLong(request.getParameter("id_loan"));
		Long indexId;
		int id_user = 0;
		indexId = Long.parseLong(request.getParameter("id_user"));
		id_user = Integer.parseInt(request.getParameter("id_user"));

		for (User user : listUser) {
			if (user.getId_user() == indexId) {
				us = listUser.get(id_user);
			} else {
				indexId++;
			}
		}
		if (us.getnLoan() != 0) {
		nLoan = us.getnLoan();
		nLoan--;
		us.setnLoan(nLoan);
		try {
			System.out.println("sto nel try");
			if (us.getnLoan() != 0) {
				UserDAO.UpdatenLoan(us, indexId);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}else {
		try {
			UserDAO.UpdatenLoan(us, indexId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}

		try {
			LoanDAO.deleteLoan(id_loan);
			page = "listLoan";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		showLoan(request);
	}

	/**
	 * method that delete a role in database
	 * 
	 * @param request
	 */
	private void deleteRole(HttpServletRequest request) {

		Long id_role = Long.parseLong(request.getParameter("id_role"));

		try {
			RoleDAO.deleteRole(id_role);
			page = "listRole";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		showRole(request);
	}

	/**
	 * method that update a book in database
	 * 
	 * @param request
	 * @param id_book, the id of the book that we want update
	 */
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

	/**
	 * method that update a user in database
	 * 
	 * @param request
	 * @param id_user, the id of user that we want update
	 */
	private void updateUser(HttpServletRequest request, Long id_user) {

		UserForm userForm = new UserForm();
		userForm.setName(request.getParameter("name"));
		userForm.setSurname(request.getParameter("surname"));
		userForm.setAddress(request.getParameter("address"));
		userForm.setEmail(request.getParameter("email"));
		userForm.setPassword(request.getParameter("password"));

		try {
			UserDAO userdao = new UserDAO();
			userdao.updateUser(userForm, id_user);
			;
			page = "administration";

		} catch (Exception e) {
			System.out.println(e);
		}
		showUsers(request);
	}

	/**
	 * method that update a loan in database
	 * 
	 * @param request
	 * @param id_loan, the id of the loan that we want update
	 */
	private void updateLoan(HttpServletRequest request, Long id_loan) {

		LoanForm loanForm = new LoanForm();
		loanForm.setState(request.getParameter("state"));

		try {
			LoanDAO loandao = new LoanDAO();
			loandao.updateLoan(loanForm, id_loan);
			;
			page = "listLoan";

		} catch (Exception e) {
			System.out.println(e);
		}
		showLoan(request);

	}

	/**
	 * method that update a role in database
	 * 
	 * @param request
	 * @param id_role, the id of the role that we want update
	 */
	private void updateRole(HttpServletRequest request, Long id_role) {

		RoleForm roleForm = new RoleForm();
		roleForm.setId_profile(Long.parseLong(request.getParameter("id_profile")));

		try {
			RoleDAO roledao = new RoleDAO();
			roledao.updateRole(roleForm, id_role);

			page = "listRole";

		} catch (Exception e) {
			System.out.println(e);
		}
		showRole(request);

	}

	/**
	 * method that shows the list of all users
	 * 
	 * @param request
	 * @return
	 */
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

	/**
	 * method that shows the list of all books
	 * 
	 * @param request
	 * @return
	 */
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

	/**
	 * method that shows the list of all loans
	 * 
	 * @param request
	 * @return
	 */
	private List<Loan> showLoan(HttpServletRequest request) {
		LoanDAO loanDAO = new LoanDAO();
		List<Loan> loanList = new ArrayList();
		try {
			loanList = loanDAO.loanList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.getSession().setAttribute("loanList", loanList);

		page = "listLoan";
		return loanList;
	}

	/**
	 * method that shows the list of all roles
	 * 
	 * @param request
	 * @return
	 */
	private List<Role> showRole(HttpServletRequest request) {
		RoleDAO roleDAO = new RoleDAO();
		List<Role> roleList = new ArrayList();
		try {
			roleList = roleDAO.roleList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.getSession().setAttribute("roleList", roleList);

		page = "listRole";
		return roleList;
	}

	/**
	 * method that sends us to the page "createBook"
	 * 
	 * @param request
	 */
	private void changePageCB(HttpServletRequest request) {
		page = "createBook";
	}

	/**
	 * method that sends us to the page "createUser"
	 * 
	 * @param request
	 */
	private void changePageCU(HttpServletRequest request) {
		page = "createUser";
	}

	/**
	 * method that sends us to the page "updateBook" with the id of the book
	 * 
	 * @param request
	 * @return
	 */
	private Long changePageUB(HttpServletRequest request) {
		Long id_book = Long.parseLong(request.getParameter("id_book"));

		page = "updateBook";
		return id_book;
	}

	/**
	 * method that sends us to the page "updateUser" with the id of the user
	 * 
	 * @param request
	 * @return
	 */
	private Long changePageUU(HttpServletRequest request) {

		Long id_user = Long.parseLong(request.getParameter("id_user"));
		/*
		 * id_user = id_user - 1; String prova; user = userList.get(id_user);
		 * System.out.println("stampo user"); System.out.println(user.getName());
		 * 
		 * UserForm uf = new UserForm(); uf.setId_user(user.getId_user());
		 * uf.setName(user.getName()); uf.setSurname(user.getSurname());
		 * uf.setAddress(user.getAddress()); uf.setEmail(user.getEmail());
		 * uf.setPassword(user.getPassword()); System.out.println("stampo form");
		 * System.out.println(uf.getName());
		 * 
		 * setAttribute(request, uf);
		 */
		page = "updateUser";
		return id_user;
	}

	/*
	 * private void setAttribute(HttpServletRequest request, UserForm uf) {
	 * System.out.println("sto nel set"); System.out.println(uf.getName());
	 * request.setAttribute("name", uf.getName()); request.setAttribute("surname",
	 * uf.getSurname()); request.setAttribute("address", uf.getAddress());
	 * request.setAttribute("email", uf.getEmail());
	 * request.setAttribute("password", uf.getPassword());
	 * System.out.println(uf.getName()); }
	 */

	/**
	 * method that sends us to the page "loan" with the id of the book
	 * 
	 * @param request
	 * @return
	 */
	private Long changePageLOAN(HttpServletRequest request) {
		Long id_book = Long.parseLong(request.getParameter("id_book"));
		page = "loan";
		return id_book;
	}

	/**
	 * method that decreases the quantity field when a loan is created
	 * 
	 * @param request
	 * @param bookList, the list where the book is located
	 * @param id_book,  the id of the book that we want decreases
	 * @throws Exception
	 */
	private void quantityMinus(HttpServletRequest request, List<Book> bookList, Long id_book) throws Exception {

		Book book = new Book();
		book = bookList.get(Math.toIntExact(id_book) - 1);
		BookDAO bookDAO = new BookDAO();

		try {
			bookDAO.quantityMinus(book, id_book);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method that sends us to the page "listLoan"
	 * 
	 * @param request
	 */
	private void changePageLL(HttpServletRequest request) {
		page = "listLoan";
		showLoan(request);
	}

	/**
	 * method that sends us to the page "updateLoan" with the id of the loan
	 * 
	 * @param request
	 * @return
	 */
	private Long changePageUL(HttpServletRequest request) {
		Long id_loan = Long.parseLong(request.getParameter("id_loan"));
		page = "updateLoan";
		return id_loan;
	}

	/**
	 * method that sends us to the page "createRole" with the id of the user
	 * 
	 * @param request
	 * @return
	 */
	private Long changePageCR(HttpServletRequest request) {
		Long id_user = Long.parseLong(request.getParameter("id_user"));
		page = "createRole";
		return id_user;
	}

	/**
	 * 
	 * method that sends us to the page "updateRole" with the id of the role
	 * 
	 * @param request
	 * @return
	 */
	private Long changePageUR(HttpServletRequest request) {
		Long id_role = Long.parseLong(request.getParameter("id_role"));
		page = "updateRole";
		return id_role;
	}

	/**
	 * method that sends us to the home
	 * 
	 * @param request
	 */
	private void backHome(HttpServletRequest request) {
		page = "login";
	}
}
