package library.model;

import java.util.Date;

public class Loan {
	private Long id_loan;
	private Long id_book;
	private Long id_user;
	private Date assignment_date;
	private Date expiration_date;
	private String state;

	public Loan() {
		super();
	}

	public Loan(Long id_loan, Long id_book, Long id_user, Date assignment_date, Date expiration_date, String state) {
		super();
		this.id_loan = id_loan;
		this.id_book = id_book;
		this.id_user = id_user;
		this.assignment_date = assignment_date;
		this.expiration_date = expiration_date;
		this.state = state;
	}

	public Long getId_loan() {
		return id_loan;
	}

	public void setId_loan(Long id_loan) {
		this.id_loan = id_loan;
	}

	public Long getId_book() {
		return id_book;
	}

	public void setId_book(Long id_book) {
		this.id_book = id_book;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Date getAssignment_date() {
		return assignment_date;
	}

	public void setAssignment_date(Date assignment_date) {
		this.assignment_date = assignment_date;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
