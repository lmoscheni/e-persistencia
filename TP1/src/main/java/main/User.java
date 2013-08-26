package main;

public class User {

	protected String name;
	protected String userName;
	protected String surname;
	protected String birth;
	protected String email;
	protected String password;
	
	public User(String userName, String name, String surname, String email, String birth, String password){
		this.userName = userName;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birth = birth;
		this.password = password;
	}
	
	//****************************************************************************************************************
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
	//****************************************************************************************************************
	
	
	
}
