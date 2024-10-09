package com.genereishop.proyecto.modelo;

public class User {
	private Long userId;
	private String userName;
	private Long userPhone;
	private String userEmail;
	private String userPassword;
	private Long Adress_adressId;//llave foranea 
	
	private static Long total = Long.valueOf(0);
	
	public User(String userName, Long userPhone, String userEmail, String userPassword) {
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		User.total++;
		userId = User.total;
	}//Constructor de User 

	public User() {
		User.total++;
		userId = User.total;
	}//Constructor vacio 

	//=========== getter & setters
	public Long getUserId() {
		return userId;
	}//getuser

	public void setUserId(Long userId) {
		this.userId = userId;
	}//setuser

	public String getUserName() {
		return userName;
	}//getname

	public void setUserName(String userName) {
		this.userName = userName;
	}//setname

	public Long getUserPhone() {
		return userPhone;
	}//getphone

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}//setphone

	public String getUserEmail() {
		return userEmail;
	}//getemail

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}//setemail

	public String getUserPassword() {
		return userPassword;
	}//getpass

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}//setpass

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", userEmail="
				+ userEmail + ", userPassword=" + userPassword + "]";
	}
	
	
	
	
}//classe User


