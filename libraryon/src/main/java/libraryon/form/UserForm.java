package libraryon.form;

public class UserForm {

	private String name;
	private String surname;
	private String address;
	private String email;
	private String password;
	
	public UserForm(String name, String surname, String address, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.email = email;
		this.password = password;
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
