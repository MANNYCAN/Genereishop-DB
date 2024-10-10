package com.genereishop.proyecto.modelo;

import java.time.LocalDate;


public class Order {
	private Long orderId;
	private LocalDate orderDate;
	private Long userId;
	
	private static Long total = Long.valueOf(0);
	
///////////////////////Constructores///////////////////////////

	public Order(LocalDate orderDate) {
		this.orderDate = orderDate;
		Order.total++;
		orderId = Order.total;
		//userId = Order.total;
	}// (1)Constructor Order 

	public Order() {
		Order.total++;
		orderId = Order.total;
		//userId = Order.total;
	}// (2)contructor Order
	

///////////////////////Setters & Getters//////////////////////


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

