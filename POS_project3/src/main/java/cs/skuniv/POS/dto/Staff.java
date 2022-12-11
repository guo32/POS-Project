package cs.skuniv.POS.dto;

public class Staff {
		
	private String id; // 스태프 아이디
	private String password; // 스태프 비밀번호
	private String name; // 스태프 이름
	private String role; // 역할(manager or staff)
	
	public Staff(String id, String password, String name, String role) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
