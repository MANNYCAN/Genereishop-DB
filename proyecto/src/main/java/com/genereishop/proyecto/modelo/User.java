package com.genereishop.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	private Long userId;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private Long userPhone;
	@Column(nullable = false)
	private String userEmail;
	@Column(nullable = false)
	private String userPassword;
	//@ManyToOne
	//@JoinColumn(name ="adress_adressId", nullable = false, referencedColumnName = "adressId")
	//@Column(nullable = false)
	private Long adressAdressId ;//llave foranea 
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_userId", referencedColumnName = "userId")
	List<Order> orders = new ArrayList<Order>();

	public List<Order> getOrders() {
		return orders;
	}//getOrders

	public User(String userName, Long userPhone, String userEmail, String userPassword, Long adressAdressId) {
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.adressAdressId= adressAdressId;
	}//Constructor de User 

	public User() {
	}//Constructor vacio 

	//=========== getter & setters
	
	public Long getUserId() {
		return userId;
	}//getuser

	public Long getAdressAdressId() {
		return adressAdressId;
	}//getadress_adressId

	public void setAdressAdressId(Long adressAdressId) {
		this.adressAdressId = adressAdressId;
	}//setadress_adressId

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
	}//toString
	
	
	
	
}//classe User


