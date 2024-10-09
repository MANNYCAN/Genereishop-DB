package com.genereishop.proyecto.modelo;

public class Adress {
	private Long adressId;
	private String adressState;
	private Integer adressZip;
	private String adressStreet;
	private String adressExtNum;
	private String adressIntNum;
	
	private static Long total = Long.valueOf(0);

	public Adress(String adressState, Integer adressZip, String adressStreet, String adressExtNum,
			String adressIntNum) {
		this.adressState = adressState;
		this.adressZip = adressZip;
		this.adressStreet = adressStreet;
		this.adressExtNum = adressExtNum;
		this.adressIntNum = adressIntNum;
		Adress.total++;
		adressId = Adress.total;
	}//constructor

	public Adress() {
		Adress.total++;
		adressId = Adress.total;
	}//constructor

	public Long getAdressId() {
		return adressId;
	}//getAdressId

	public void setAdressId(Long adressId) {
		this.adressId = adressId;
	}//setAdressId

	public String getAdressState() {
		return adressState;
	}//getAdressState

	public void setAdressState(String adressState) {
		this.adressState = adressState;
	}//setAdressState

	public Integer getAdressZip() {
		return adressZip;
	}//getAdressZip

	public void setAdressZip(Integer adressZip) {
		this.adressZip = adressZip;
	}//setAdressZip

	public String getAdressStreet() {
		return adressStreet;
	}//getAdressStreet

	public void setAdressStreet(String adressStreet) {
		this.adressStreet = adressStreet;
	}//setAdressStreet

	public String getAdressExtNum() {
		return adressExtNum;
	}//getAdressExtNum

	public void setAdressExtNum(String adressExtNum) {
		this.adressExtNum = adressExtNum;
	}//setAdressExtNum

	public String getAdressIntNum() {
		return adressIntNum;
	}//getAdressIntNum

	public void setAdressIntNum(String adressIntNum) {
		this.adressIntNum = adressIntNum;
	}//setAdressIntNum

	@Override
	public String toString() {
		return "Adress [adressId=" + adressId + ", adressState=" + adressState + ", adressZip=" + adressZip
				+ ", adressStreet=" + adressStreet + ", adressExtNum=" + adressExtNum + ", adressIntNum=" + adressIntNum
				+ "]";
	}//toString	

}// class Adress
