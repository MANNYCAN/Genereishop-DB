package com.genereishop.proyecto.dto;

public class ChangePassword {
	private String password;
	private String npassword;
	
	public ChangePassword(String password, String npassword) {
		this.password = password;
		this.npassword = npassword;
	}//constructor 
	
	public ChangePassword() {

	}//constructor 
	

	public String getPassword() {
		return password;
	}//getpass

	public void setPassword(String password) {
		this.password = password;
	}//setpass

	public String getNpassword() {
		return npassword;
	}//getnpass

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}//setnpass

	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", npassword=" + npassword + "]";
	}//tostring
	
	
}//classchange
