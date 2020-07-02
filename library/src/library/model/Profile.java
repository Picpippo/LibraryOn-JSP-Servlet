package library.model;

public class Profile {
	private Long id_profile;
	private String type;
	
	public Profile() {
		super();
	}
	public Profile(Long id_profile, String type) {
		super();
		this.id_profile = id_profile;
		this.type = type;
	}
	public Long getId_profile() {
		return id_profile;
	}
	public void setId_profile(Long id_profile) {
		this.id_profile = id_profile;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
