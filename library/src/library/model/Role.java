package library.model;

public class Role {
	private Long id_role;
	private Long id_user;
	private Long id_profile;

	public Role() {
		super();
	}

	public Role(Long id_role, Long id_user, Long id_profile) {
		super();
		this.id_role = id_role;
		this.id_user = id_user;
		this.id_profile = id_profile;
	}

	public Long getId_role() {
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Long getId_profile() {
		return id_profile;
	}

	public void setId_profile(Long id_profile) {
		this.id_profile = id_profile;
	}

}
