package libraryon.form;

public class UserForm {
	private Long id_user;
	private String name;
	private String surname;
	private String address;
	private String email;
	private String password;
	
	public UserForm(Long id_user ,String name, String surname, String address, String email, String password) {
		super();
		this.id_user = id_user;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public UserForm() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}