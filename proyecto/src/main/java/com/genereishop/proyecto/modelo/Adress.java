package com.genereishop.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adress")
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adressId", unique = true, nullable = false)
	private Long adressId;
	@Column(nullable = false)
	private String adressState;
	@Column(nullable = false)
	private Integer adressZip;
	@Column(nullable = false)
	private String adressStreet;
	@Column(nullable = false)
	private String adressExtNum;
	private String adressIntNum;
	
	//private static Long total = Long.valueOf(0);

	public Adress(String adressState, Integer adressZip, String adressStreet, String adressExtNum,
			String adressIntNum) {
		this.adressState = adressState;
		this.adressZip = adressZip;
		this.adressStreet = adressStreet;
		this.adressExtNum = adressExtNum;
		this.adressIntNum = adressIntNum;
//		Adress.total++;
//		adressId = Adress.total;
	}//constructor

	public Adress() {
//		Adress.total++;
//		adressId = Adress.total;
	}//constructor

	public Long getId() {
		return adressId;
	}//getAdressId

	public void setId(Long adressId) {
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
		return "Adress [Id=" + adressId + ", adressState=" + adressState + ", adressZip=" + adressZip
				+ ", adressStreet=" + adressStreet + ", adressExtNum=" + adressExtNum + ", adressIntNum=" + adressIntNum
				+ "]";
	}//toString	

}// class Adress
