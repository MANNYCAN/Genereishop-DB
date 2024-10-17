package com.genereishop.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order_has_Product")
public class OrderHasProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderHasProductId", unique = true, nullable = false)
	private Long orderHasProductId;
	@Column(nullable = false)
	private Long oHPQuantity;
	@Column(nullable = false)
	private Long orderOrderIdFk;
	@Column(nullable = false)
	private Long productProductIdFk;
	
	public OrderHasProduct(Long oHPQuantity) {
		this.oHPQuantity = oHPQuantity;
	}//OrderHasProduct Constructor
	
	public OrderHasProduct() {} //Constructor vacio
	
	public Long getoHPQuantity() {
		return oHPQuantity;
	}//getoHPQuantity
	public void setoHPQuantity(Long oHPQuantity) {
		this.oHPQuantity = oHPQuantity;
	}//setoHPQuantity
	

	public Long getOrderHasProductId() {
		return orderHasProductId;
	}//getOrderHasProductId

	public void setOrderHasProductId(Long orderHasProductId) {
		this.orderHasProductId = orderHasProductId;
	}//setOrderHasProductId

	public Long getOrder_orderId_fk() {
		return orderOrderIdFk;
	}//getOrder_orderId_fk

	public void setOrder_orderId_fk(Long orderOrderIdFk) {
		this.orderOrderIdFk = orderOrderIdFk;
	}//setOrder_orderId_fk

	public Long getProduct_productId_fk() {
		return productProductIdFk;
	}//getProduct_productId_fk

	public void setProduct_productId_fk(Long productProductIdFk) {
		this.productProductIdFk = productProductIdFk;
	}//setProduct_productId_fk

	@Override
	public String toString() {
		return "OrderHasProduct [orderHasProductId=" + orderHasProductId + ", oHPQuantity=" + oHPQuantity
				+ ", orderOrderIdFk=" + orderOrderIdFk + ", productProductIdFk=" + productProductIdFk + "]";
	}//toString

	
	
	
	
}//class OrderHasProduct
