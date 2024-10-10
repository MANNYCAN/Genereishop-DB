package com.genereishop.proyecto.modelo;

public class OrderHasProduct {
	
	private Long orderId;
	private Long oHPQuantity;
	private Long productId;
	
	private static Long total = Long.valueOf(0);
	
	public OrderHasProduct(Long oHPQuantity) {
		this.oHPQuantity = oHPQuantity;
		OrderHasProduct.total++;
		orderId = OrderHasProduct.total;
	}//OrderHasProduct Constructor
	
	public OrderHasProduct() {
		OrderHasProduct.total++;
		orderId = OrderHasProduct.total;
	} //Constructor vacio
	
	public Long getoHPQuantity() {
		return oHPQuantity;
	}//getoHPQuantity
	public void setoHPQuantity(Long oHPQuantity) {
		this.oHPQuantity = oHPQuantity;
	}//setoHPQuantity
	
	
	public Long getOrderId() {
		return orderId;
	}//getOrderId
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}//setOrderId
	
	@Override
	public String toString() {
		return "OrderHasProduct [oHPQuantity=" + oHPQuantity + ", orderId=" + orderId + ", productId=" + productId
				+ "]";
	}//toString
	
	
	
}//class OrderHasProduct
