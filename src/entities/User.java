package entities;

public class User {

	private int id;
	String name,userId,password;
	
	
	public User() {
		super();
	}
	public User(String name, String userId, String password) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
