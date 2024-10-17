package com.genereishop.proyecto.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="`order`")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId", unique = true, nullable = false)
	private Long orderId;
	@Column(nullable = false)
	private LocalDate orderDate;
	@Column(nullable = false)
	private Long user_userId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderOrderIdFk", referencedColumnName = "orderId")
	List<OrderHasProduct> orderHasProducts = new ArrayList<OrderHasProduct>();
	
	
	
	
	
public List<OrderHasProduct> getOrderHasProducts() {
		return orderHasProducts;
	}//getOrderHasProducts

	///////////////////////Constructores///////////////////////////
	public Order(LocalDate orderDate, Long user_userId) {
		this.orderDate = orderDate;
		this.user_userId = user_userId;
	}
	
	public Order() {
	}// (2)contructor Order
	

	///////////////////////Setters & Getters//////////////////////
	public Long getUserId() {
		return user_userId;
	}

	public void setUserId(Long userId) {
		this.user_userId = userId;
	}

	public Long getOrderId() {
		return orderId;
	}//getOrderId
	

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}//setOrderId

	public LocalDate getOrderDate() {
		return orderDate;
	}//getOrderDate
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}//setOrderDate

//	public Long getUserId() {
//		return userId;
//	}//getUserId
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}//setUserId

	
////////////////////////to String/////////////////////////////
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + "]";
	}//toString

	
}// class Order

